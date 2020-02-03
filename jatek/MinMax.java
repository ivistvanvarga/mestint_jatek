package jatek;

import allapotter.*;
/**
 * 
 * @author Varga Istvan
 * MiniMax lepesajanlo algoritmus
 *
 */
public class MinMax extends LepesAjanlo {

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer s=new StringBuffer("Ez egy MinMax lépésajánló algoritmus, amely ");
		s.append("az ").append(a).append(" allapotból ");
		s.append(melyseg).append(" db lépésig előrrentekintve ajánl egy lépést. ");
		return s.toString();
	}
	public MinMax(Allapot a,int melyseg )
	{
		this.a=a;
		this.melyseg=melyseg;
		this.kiertekelve=1;
		if(a.vegAllapote()|| melyseg==0)
			this.hasznossag=a.miniMaxJosag();
		else if(a.getKovetkezo()=='A')
			{
			hasznossag=LepesAjanlo.MINUSZ_VEGTELEN;
			for(Operator op: Allapot.getOperatorok())
				{
				if(a.alkalmazhato(op))
					{
					Allapot uj=a.alkalmaz(op);
					MinMax muj=new MinMax(uj,melyseg-1);
					if(muj.hasznossag>hasznossag)
						{
						hasznossag=muj.hasznossag;
						lepes=op;
						}
					kiertekelve+=muj.kiertekelve;
					}
				}
			}
		else{
			hasznossag=VEGTELEN;
			for(Operator op: Allapot.getOperatorok())
			{
				if(a.alkalmazhato(op))
				{
				Allapot uj=a.alkalmaz(op);
				MinMax muj=new MinMax(uj,melyseg-1);
				if(muj.hasznossag<hasznossag)
					{
					hasznossag=muj.hasznossag;
					lepes=op;
					}
				kiertekelve+=muj.kiertekelve;
				}	
			}
		}
	}

}
