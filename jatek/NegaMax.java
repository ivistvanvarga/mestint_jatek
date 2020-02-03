package jatek;

import allapotter.*;
/**
 * 
 * @author Varga Istvan	
 * Negamax lepesajanlo algoritmus.
 *
 */
public class NegaMax extends LepesAjanlo {
	public NegaMax(Allapot a,int melyseg)
	{
		this.a=a;
		this.melyseg=melyseg;
		this.kiertekelve=1;
		if(a.vegAllapote()||melyseg==0)
		{	
		hasznossag=a.negaMaxJosag();	
		}
		else
		{
		hasznossag=MINUSZ_VEGTELEN;
		for(Operator op: Allapot.getOperatorok())
			{
			if(a.alkalmazhato(op))
				{	
				Allapot uj= a.alkalmaz(op);
				NegaMax t=new NegaMax(uj,melyseg-1);
				if(-t.hasznossag>hasznossag){
					hasznossag=t.hasznossag;
					lepes=op;
				}
				kiertekelve+=t.kiertekelve;
				}
			}
	
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return "Ez egy negamax algoritmus, amely "+melyseg+" lépésre elõre kiszámolta az ajánlott lépést."+
		" és közben kiértékelt "+kiertekelve+" db lehetséges lépést.";
	}

}
