package allapotter;
import java.util.*;
public abstract class Allapot {
protected static Vector<Operator> operatorok;
protected char jatekos;
static{
    operatorok= new Vector<Operator>();
}
protected static int elore;

public static int getElore() {
	return elore;
}

public static void setElore(int elore) {
	Allapot.elore = elore;
}

public void jatekosValto()
{
jatekos= (jatekos == 'A') ? 'B' : 'A';	
}

public static Vector<Operator> getOperatorok() {
	return operatorok;
}

public char getJatekos() {
	return jatekos == 'A' ? 'B' : 'A';
}
public char getKovetkezo(){
	return jatekos == 'A' ? 'B' : 'A';
}

public abstract boolean alkalmazhato(Operator op);
public abstract Allapot alkalmaz(Operator op);
public abstract boolean nyertA();
public abstract boolean nyertB();
public abstract int miniMaxJosag();
public abstract int negaMaxJosag();
public abstract boolean vegAllapote();
public abstract Operator beolvas();
public abstract String toString();
}
