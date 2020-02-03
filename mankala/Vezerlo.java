package mankala;

import allapotter.Allapot;
import jatek.Jatekvezerlo;
/**
 * 
 * @author Varga Istvan
 *A jatek vezerlese
 */
public class Vezerlo extends Jatekvezerlo {
	/**
	 * Alapertelmezett jatekvezerolo konstruktora. 
	 * A melyseg megadja hany lepest nezhet elore a gep es a jatekos.
	 * @param kezdo
	 * @param melyseg
	 */
	public Vezerlo(Allapot kezdo, int melyseg)
	{
		super(kezdo, melyseg);
	}
	/**
	 *  A melyseg megadja hany lepest nezhet elore  a jatekos.
	 * A gmelyseg megadja hany lepest nezhet elore a gep.
	 * @param kezdo
	 * @param melyseg
	 * @param gmelyseg
	 */
	public Vezerlo(Allapot kezdo, int melyseg, int gmelyseg) {
		super(kezdo, melyseg, gmelyseg);
		// TODO Auto-generated constructor stub
	}

}
