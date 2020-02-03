package nim;

import allapotter.Operator;

public class Elvesz extends Operator {
protected int honnan,menyit;

public Elvesz(int honnan, int menyit) {
	
	this.honnan = honnan;
	this.menyit = menyit;
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return "Elvesz("+honnan+","+menyit+")";
}

public int getHonnan() {
	return honnan;
}

public int getMenyit() {
	return menyit;
}

}
