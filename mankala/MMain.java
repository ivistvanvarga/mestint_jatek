package mankala;



public class MMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mankala s=new Mankala();
		System.out.println("Mankala j�t�k:)");
		System.out.println("A j�t�k c�lja az, hogy az ed�nyekbe minnn�l t�bb babot �sszegy�jts�nk.");
		System.out.println("L�p�sn�l meg kell adni melyik g�dr�db�l veszed ki az �sszes babot.");
		System.out.println("A j�t�k akkor �r v�get, ha  minden g�d�r �res.");
		
    Vezerlo j=new Vezerlo(s,7,7);    j.jatszik();
   
	}
	
}
