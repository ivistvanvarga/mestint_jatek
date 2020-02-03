package jatek;
import allapotter.*;
/**
 * 
 * @author Varga Istvan
 * Alfa- beta Negamax lepesajanlo algoritmus
 */
public class A_BNegaMax extends LepesAjanlo {

	protected int alfa, beta;
	public A_BNegaMax(Allapot a,int melyseg){
		this(a,melyseg,MINUSZ_VEGTELEN,VEGTELEN);
	}
	
	public A_BNegaMax(Allapot a,int melyseg,int al,int b){

		this.a=a;
		this.melyseg=melyseg;
		this.kiertekelve=1;
		alfa=al;
		beta=b;
		if(a.vegAllapote()|| melyseg==0)
			hasznossag=a.negaMaxJosag();
		else{
			for(Operator op: Allapot.getOperatorok())
			{
			if(alfa>=beta) break;
			if(a.alkalmazhato(op))
				{
				Allapot uj=a.alkalmaz(op);
				A_BNegaMax t= new A_BNegaMax(uj,melyseg-1);
				if(-t.hasznossag>alfa)
					{
					alfa=-t.hasznossag;
					lepes=op;
					}
				kiertekelve+=t.kiertekelve;
				}
			}
			hasznossag=alfa;
		}
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ez egy alfa-béta negamax algoritmus, amely "+melyseg+" lépésre elõre kiszámolta\naz ajánlott lépést,"+
		" és közben kiértékelt "+kiertekelve+" db lehetséges lépést.";
	}

}
