import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * Created by tomas on 9/2/16.
 */
public class RunClient {

	public static void main(String[] args) {
		DvdCollection dvds = new DvdCollection();
		dvds.add("DVD-title number One");
		delay();
		dvds.add("DVD-title number TWo");
		delay();
		dvds.add("DVD-title number THRee");
		delay();
		dvds.add("DVD-title number FOUR");

		for (int i = 0; i < dvds.size(); i++) System.out.println(dvds.get(i));
		dvds.remove(2);
		System.out.println();
		for (int i = 0; i < dvds.size(); i++) System.out.println(dvds.get(i));
	}

	public static void delay(){	//Gør noget der tager lidt tid.
		for(int i=0; i<10000000; i++){ int dummy=i*314;}
		}
}
