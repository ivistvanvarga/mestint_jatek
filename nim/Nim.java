package nim;

import allapotter.Allapot;
import allapotter.Operator;
import java.util.*;

public class Nim extends Allapot {

public static final int KUPACOK=3;	
public static final int MAXSZAM=17;
static{
	for(int i=1;i<=KUPACOK;++i)
		for(int j=1;j<MAXSZAM;++j)
			operatorok.add(new Elvesz(i,j));
}
protected int[] kupac;
public Nim()
{
	kupac=new int[KUPACOK+1];
	kupac[0]=0;
	kupac[1]=2;
	kupac[2]=2;
	kupac[3]=2;
	jatekos='A';
}
public Nim(Nim a)
{
	//this.kupac=Arrays.copyOf(a.kupac,a.kupac.length );
	kupac=new int[KUPACOK+1];
	System.arraycopy(kupac,0,a.kupac,0,kupac.length);
	jatekos=a.jatekos;
}

	@Override
	public Allapot alkalmaz(Operator op) {
		// TODO Auto-generated method stub
		if( !(op instanceof Elvesz )) return null;
		Nim uj=new Nim(this);
		Elvesz o=(Elvesz)op;
		uj.kupac[o.getHonnan()]-=o.getMenyit();
		uj.jatekosValto();
		return uj;
	}

	@Override
	public boolean alkalmazhato(Operator op) {
		// TODO Auto-generated method stub
		if(! (op instanceof Elvesz )) 	return false;
		Elvesz o=(Elvesz)op;
		return kupac[o.getHonnan()]>=o.getMenyit();
	}

	@Override
	public Operator beolvas() {
		// TODO Auto-generated method stub
		Operator op;
		Scanner sc=new Scanner(System.in);
		while(true)
		{
		System.out.println("Add meg melyiki kupacból és menyit szeretnél elvenni.\n honnan menyit:");
		int h=sc.nextInt();
		int m=sc.nextInt();
		if(h>KUPACOK || m>kupac[h]) 
			{
			System.out.println("Ezt nem lehet végrehajtani!!\n");
			continue;
			}
		op=new Elvesz(h,m);
		if(alkalmazhato(op)) break;
		else System.out.println("Ezt nem lehet elvégezni.\n");
		}
		return op;
	}

	@Override
	public int negaMaxJosag() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int miniMaxJosag() {
		// TODO Auto-generated method stub
		
		return 1;
	}

	@Override
	public boolean vegAllapote() {
		// TODO Auto-generated method stub
		for(int i=1;i<kupac.length;++i)
			if(kupac[i]!=0)return false;
		return true;
	}
	@Override
	public boolean nyertA() {
		// TODO Auto-generated method stub
		
		return !(vegAllapote() && jatekos=='B');
	}

	@Override
	public boolean nyertB() {
		// TODO Auto-generated method stub
		return !(vegAllapote()&& jatekos=='A');
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer s=new StringBuffer("A kupacokban ");
		for(int i=1;i<kupac.length;++i)
			s.append("[").append(i).append(",").append(kupac[i]).append("] ");
		return s.toString();
	}

}
