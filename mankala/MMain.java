package mankala;



public class MMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mankala s=new Mankala();
		System.out.println("Mankala játék:)");
		System.out.println("A játék célja az, hogy az edényekbe minnnél több babot összegyüjtsünk.");
		System.out.println("Lépésnél meg kell adni melyik gödrödbõl veszed ki az összes babot.");
		System.out.println("A játék akkor ér véget, ha  minden gödör üres.");
		
    Vezerlo j=new Vezerlo(s,7,7);    j.jatszik();
   
	}
	
}
