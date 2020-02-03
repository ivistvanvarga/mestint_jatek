package mankala;

import allapotter.Allapot;
import allapotter.Operator;


import java.util.*;
import jatek.*;

public class Mankala extends Allapot {

	
	protected int[] tabla;
	
	
	/**
	 * operatorok feltoltese
	 */
	static{
		for(int i=1;i<7;++i)
			operatorok.add(new Elvesz(i));
		
	}
	/**
	 * Alapertelmezett konstruktor
	 *
	 */
	public Mankala()
	{
	tabla=new int[14];
	for(int i=0;i<14;++i)
		tabla[i]= (i==0 || i==7) ? 0 : 4;
	
	}
	/**
	 * Masolo konstruktor
	 * @param a
	 */
	public Mankala(Mankala a)
	{
	//tabla=Arrays.copyOf(a.tabla, a.tabla.length);
		tabla=new int [14];
	System.arraycopy(a.tabla,0,tabla,0,tabla.length);
	 jatekos=a.jatekos;
	}
	
	/**
	 * operator alkalmazasa a játékszabályok alapján
	 */
	@Override
	public Allapot alkalmaz(Operator op) {
		// TODO Auto-generated method stub
		if(!(op instanceof Elvesz)) return null;
		Mankala uj= new Mankala(this);
		Elvesz o=(Elvesz)op;
		//lepes es utési szabály alkalmazása
		if(uj.getJatekos()=='A'){int i=1;int l=tabla[o.getHonnan()];
		uj.tabla[o.getHonnan()]=0;	
		for(;i<=l-1;++i)
			{
				++uj.tabla[(i+o.getHonnan())%14];
			}
		
		if(tabla[(o.getHonnan()+i)%14]==0 && (o.getHonnan()+i)%14>0 && (o.getHonnan()+i)%14<7 )
		{++uj.tabla[7];
			
			uj.tabla[7] += uj.tabla[7+(7-(o.getHonnan()+i)%14)];
			uj.tabla[7+(7-(o.getHonnan()+i)%14)]=0;
		}else ++uj.tabla[(i+o.getHonnan())%14];
		
		}
		else
		{int i=1;int l=tabla[o.getHonnan()+7];
		uj.tabla[o.getHonnan()+7]=0;	
			for(;i<=l-1;++i)
			{
				++uj.tabla[(i+o.getHonnan()+7)%14];
			}
			
			if(tabla[(o.getHonnan()+i+7)%14]==0 && (o.getHonnan()+i+7)%14>7 && (o.getHonnan()+i+7)%14<14 )
			{
			++uj.tabla[0];
			
			uj.tabla[0]+=uj.tabla[14-(o.getHonnan()+i+7)%14];
			uj.tabla[14-(o.getHonnan()+i+7)%14]=0;
			}else ++uj.tabla[(i+o.getHonnan()+7)%14];	
		}
		
		uj.jatekosValto();
		
		//ha a következö jatekos nem tud lépni.
		if(uj.getJatekos()=='A')
		{
		boolean t=false;
		for(Operator k: Allapot.getOperatorok())
		if(uj.alkalmazhato(k))t=true;
			if(!t){
			
			for(int i=8;i<14;++i)
				{uj.tabla[0]+=uj.tabla[i]; uj.tabla[i]=0;}			
				}	
			
		}
		else  
		{//egy kicsit elírtam:(
			/*if(uj.tabla[1]==0){
				boolean t=false;
				t=uj.tabla[8]==0 && uj.tabla[9]==0 && uj.tabla[10]==0 && uj.tabla[11]==0 && uj.tabla[12]==0 && uj.tabla[13]==0 ; 
			*/
			boolean t=false;
			for(Operator k: Allapot.getOperatorok())
			if(uj.alkalmazhato(k))t=true;
			
			if(!t){
				
			for(int i=1;i<7;++i)
				{uj.tabla[7]+=uj.tabla[i];uj.tabla[i]=0;}
			}
		}
				
		
		
		return uj;
	}
	/**
	 *Alkalmazható az operator??? 
	 */
	@Override
	public boolean alkalmazhato(Operator op) {
		// TODO Auto-generated method stub
		if(!(op instanceof Elvesz))return false;
		Elvesz o=(Elvesz)op;
		if(getJatekos()=='A')
		{
		return(tabla[o.getHonnan()]!=0);	
		}
		else return(tabla[o.getHonnan()+7]!=0);
		
	}
	/**
	 * Lepes beolvasasa.
	 */
	@Override
	public Operator beolvas() {
		// TODO Auto-generated method stub
		Operator op;
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.print("Honnan szeretnéd elvenni a babokat(1-6):");
			int e=sc.nextInt();
			if(e>0 && e<7){
			op=new Elvesz(e);
			if(alkalmazhato(op)) break;
			else System.out.println("Onnan nam lehet elvenni babot.\n");
			}else if(e==0)
			{
			A_BNegaMax t=new A_BNegaMax(this,Allapot.getElore()); 	
			System.out.println("Az ajanlott lepes: "+ t.getLepes());
			System.out.println(t);
			} else 
						
			System.out.println("Ezt nem lehet elvégezni adj meg más számot (1-6)\n vagy kérj ajánlatot a géptõl(0). :)");
			}
		return op;
		
	}
	/**
	 *Menyire hasznos a lepes az A jatekosnak.
	 * 
	 */
	@Override
	public int miniMaxJosag() {
		// TODO Auto-generated method stub
		// Annál jobb minél több bab van az edényben.
		if(this.vegAllapote() && getJatekos()=='A')
		{
		if(tabla[7]>=tabla[0]) return 200;
		else return -200;
		}
		else if(this.vegAllapote()&& getJatekos()=='B')
		{
			if(tabla[7]>=tabla[0]) return -200;
			else return 200;	
			
		}
		int h=0;
		if(getJatekos()=='A'){
			for(int i=1;i<8;++i)
				h+=tabla[i];
		}else{
			for(int i=8;i<13;++i)
				h+=tabla[i];
			h+=tabla[0];
			h*=-1;
		}
		
		return h;
	}
	/**
	 * Menyire hasznos egy lepes a jatekosnak.
	 */
	@Override
	public int negaMaxJosag() {
		// TODO Auto-generated method stub
		// Annál jobb minél több bab van az edényben.
		if(this.vegAllapote())
		{
			if(getJatekos()=='A')
			{
			if(tabla[7]>=tabla[0]) return 500;
			else return -500;
			}
			else
				{
				if(tabla[0]>=tabla[7]) return 500;
				else return -500;
				}	
		}
		int h=0;
		if(getJatekos()=='A'){
			for(int i=1;i<8;++i)
				h+=tabla[i];
		}else{
			for(int i=8;i<13;++i)
				h+=tabla[i];
			h+=tabla[0];
			
		}
		
		return h;
	}

	/**
	 * A jatekos nyert??
	 */
	@Override
	public boolean nyertA() {
		// TODO Auto-generated method stub
		
			if(!vegAllapote())	return false;
		return tabla[7]>=tabla[0];
	}
	/**
	 * B jatekos nyert??
	 */
	@Override
	public boolean nyertB() {
		// TODO Auto-generated method stub
		if(!vegAllapote())	return false;
		return tabla[7]<tabla[0];
	}
	/**
	 * Tabla kiíratasa.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer s=new StringBuffer("\n\tB:");
		for(int i=1;i<7;++i)
			s.append("[").append(tabla[14-i]).append("] ");
		s.append("\n\t<").append(tabla[0]).append(">\t\t\t").append("<").append(tabla[7]).append("> ");
		s.append("\n\tA:");
		for(int i=1;i<7;++i)
			s.append("[").append(tabla[i]).append("] ");
		s.append("\n");
	
		return s.toString();
	}

	
	/**
	 * Vegallapot vizsgalat
	 */
	@Override
	public boolean vegAllapote() {
		
		
		for(int i=1;i<7;++i)
			if(tabla[i]!=0) return false;
		for(int i=1;i<7;++i)
			if(tabla[i+7]!=0) return false;
		
		
		
		return true;
	}

}
