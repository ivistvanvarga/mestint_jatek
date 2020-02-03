package mankala;
import allapotter.Operator;
/**
 * 
 * @author Varga Istvan
 *
 */
public class Elvesz extends Operator {
/**
 * Melyik gödörbõl vegye ki az osszes babot.
 */
protected int honnan;
protected char jatekos;

public Elvesz(int honnan)
{
	this.honnan=honnan;
}

public int getHonnan() {
	return honnan;
}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Elvesz("+honnan+") ";
	}

}
