package jatek;
import allapotter.*;
public abstract class LepesAjanlo {
public static final int VEGTELEN=Integer.MAX_VALUE/2;
public static final int MINUSZ_VEGTELEN=Integer.MAX_VALUE/(-2);

protected Allapot a;
protected int melyseg;
protected Operator lepes;
protected int hasznossag;
protected int kiertekelve;
public abstract String toString();
public Operator getLepes() {
	return lepes;
}


}
