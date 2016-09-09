import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.MILLIS;

/**
 * Created by tomas on 9/2/16.
 */
public class RunClient {
	static DvdCollection dvds;

	public static void main(String[] args) {
		// Test add()
		dvds = new DvdCollection();
		System.out.println("add title  "); dvds.add(new Dvd("DVD-title number One ")); dvds.printCollection(); delay();
		System.out.println("add title  "); dvds.add(new Dvd("DVD-title number TWo ")); printAll(); delay();
		System.out.println("add title  "); dvds.add(new Dvd("DVD-title number THRee ")); printAll(); delay();

		// Test delete()
		create(); printAll();
		System.out.println("Slet index 2"); dvds.remove(2); printAll();
		create();
		System.out.println("Slet index -1"); dvds.remove(-1); printAll();
		create();
		System.out.println("Slet index 101"); dvds.remove(101); printAll();
	}
	public static void delay(){ delay(1000); }
	public static void delay(int delay) {    //Gør noget der tager lidt tid.
		LocalTime then = LocalTime.now();
		while(MILLIS.between(then, LocalTime.now()) < delay );
	}
	public static void printAll(){
		for (int i = 0; i < dvds.size(); i++) System.out.println(dvds.get(i));
		System.out.println();
	}
	public static void create(){
		dvds = new DvdCollection();
		dvds.add(new Dvd("DVD-title number One"));
		delay(314);
		dvds.add(new Dvd("DVD-title number TWo"));
		delay(314);
		dvds.add(new Dvd("DVD-title number THRee"));
		delay(314);
		dvds.add(new Dvd("DVD-title number FOUR"));
	}
}
