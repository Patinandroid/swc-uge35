import java.time.LocalTime;

/**
 * Created by tomas on 9/2/16.
 */
public class DvdCollection {
	private static final int MAX_DVDS = 100;
	private String[] titles = new String[MAX_DVDS];
	private LocalTime[] timestamps = new LocalTime[MAX_DVDS];
	private int next = 0;

	public boolean add(String title){
		if(next == MAX_DVDS) return false;

		titles[next] = title;
		timestamps[next]=LocalTime.now();
		next++;
		return true;
	}
	public String get(int index){
		if(index>=0 && index<next) return titles[index].concat("  Added: ".concat(timestamps[index].toString()));
		else return "ERROR";
	}
	public String get(String title){
		return get(getIndex(title));
	}
	public boolean contains(String title){
		for(int i=0; i<next; i++){
			if(titles[i].equals(title)) return true;
		}
		return false;
	}
	public int getIndex(String title){
		for(int i=0; i<next; i++){
			if(titles[i].equals(title)) return i;
		}
		return -1;
	}

	public boolean remove(int index){
		if(index <0 || index >= next) return false;
		for(int i=index; i<next; i++){		// Fjern ved at skifte efterfølgende elementer til venstre.
			titles[i]=titles[i+1];
		}
		for(int i=index; i<next; i++) {    // Skift også timestamps en plads til venstre.
			timestamps[i]=timestamps[i+1];
		}

		next--;
		return true;
	}
	public boolean remove(String title){
		return remove(getIndex(title));
	}
	public int size(){ return next; }
}
