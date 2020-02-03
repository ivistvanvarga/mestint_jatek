package jatek;
import allapotter.*;
import java.util.*;
public abstract class Jatekvezerlo  {
protected Allapot kezdo;
protected int melyseg;
protected int gmelyseg; 
public Jatekvezerlo(Allapot kezdo,int melyseg)
{
	this.kezdo=kezdo;
	this.gmelyseg=this.melyseg=melyseg;
}
public Jatekvezerlo(Allapot kezdo, int melyseg, int gmelyseg) {
	
	this.kezdo = kezdo;
	this.melyseg = melyseg;
	this.gmelyseg = gmelyseg;
}
public void jatszik()
{
	Allapot akt=kezdo;
	LepesAjanlo ajanlat;
	if(melyseg!=Allapot.getElore())Allapot.setElore(melyseg);
	while(true)
	{
		System.out.println(akt);
		if(akt.vegAllapote())break;
		Operator op;
		if(akt.getKovetkezo()=='A')
			
				op=akt.beolvas();
		else {
			Collections.shuffle(Allapot.getOperatorok(),new Random(System.currentTimeMillis()));
				ajanlat=new A_BNegaMax(akt,gmelyseg);
				op=ajanlat.lepes;
				
				System.out.println("A B lépése: "+op);
			 }
	
		akt=akt.alkalmaz(op);
		
		}
	if(akt.nyertA())System.out.println(akt+"Te nyertél.(A)");
	else System.out.println(akt+"Ez ellenfél nyert nyert.(B)");
	}
}


