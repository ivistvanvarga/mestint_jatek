package jatek;
import allapotter.*;
/**
 * 
 * @author hallgato
 * Alfa- beta Minimax lepesajanlo algoritmus
 */
public class A_BMiniMax extends LepesAjanlo {

	protected int alfa;
	protected int beta;
	public A_BMiniMax(Allapot a,int melyseg) {
		// TODO Auto-generated constructor stub
		this(a,melyseg,MINUSZ_VEGTELEN,VEGTELEN);
	}
	public A_BMiniMax(Allapot a,int melyseg,int al,int b) {
		this.a=a;
		this.melyseg=melyseg;
		this.kiertekelve=1;
		this.alfa=al;
		this.beta=b;
		if(a.vegAllapote()|| melyseg==0)
		{
			this.hasznossag=a.miniMaxJosag();
		}
		else if(a.getKovetkezo()=='A')
		{
			for(Operator op: Allapot.getOperatorok())
			{
				if(alfa>=beta)break;
				else if(a.alkalmazhato(op))
					{
					Allapot uj= a.alkalmaz(op);
					A_BMiniMax t=new A_BMiniMax(uj,melyseg-1,alfa,beta);
					if(t.hasznossag>alfa){
						alfa=t.hasznossag;
						lepes=op;
					}
					kiertekelve+=t.kiertekelve;
					}
			}
			hasznossag= alfa>=beta ? beta : alfa;
		}
		else{
			for(Operator op: Allapot.getOperatorok())
			{
				if(alfa>=beta) break;
				if(a.alkalmazhato(op))
				{
					Allapot uj=a.alkalmaz(op);
					A_BMiniMax t=new A_BMiniMax(uj,melyseg-1,alfa,beta);
					if(t.hasznossag<beta)
					{
						beta=t.hasznossag;
						lepes=op;
					}
					kiertekelve+=t.kiertekelve;
				}
			}
			hasznossag= alfa>= beta ? alfa :beta;
		}
			
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return ""+a+"("+this.melyseg+","+hasznossag+""+kiertekelve+")";
	}

}
