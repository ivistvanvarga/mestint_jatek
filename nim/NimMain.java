package nim;

public class NimMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Nim kezdo=new Nim();
                /*JatekvezerloGUI abl=new JatekvezerloGUI(kezdo,3){};
                abl.setVisible(true);*/
		Vezerlo v=new Vezerlo(kezdo,3);
		v.jatszik();
	}

}
