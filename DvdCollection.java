import java.time.LocalTime;

/**
 * Created by tomas on 9/2/16.
 */
public class DvdCollection {
	private static final int INITIAL_SIZE = 2;
	private static final int EXPAND_BY = 10;
	private Dvd[] data = new Dvd[INITIAL_SIZE];
	private LocalTime[] timestamps = new LocalTime[INITIAL_SIZE];
	private int size = 0;

	public boolean add(Dvd dvd){
		if(size == data.length) expandArray();

		data[size] = dvd;
		timestamps[size]=LocalTime.now();
		size++;
		return true;
	}
	public void expandArray(){
		Dvd[] temp = new Dvd[data.length+EXPAND_BY];
		LocalTime[] tempTime = new LocalTime[temp.length];
		for(int i=0; i<size; i++){
			temp[i] = data[i];
			tempTime[i] = timestamps[i];
		}
		data = temp;
		timestamps = tempTime;
		/*
		data = new Dvd[temp.length];
		timestamps = new LocalTime[temp.length];
		for(int i=0; i<size; i++) {
			data[i]=temp[i];
			timestamps[i] = tempTime[i];
		}*/

	}
	public String get(int index){
		if(index>=0 && index< size) return data[index].toString().concat("  Added: ".concat(timestamps[index].toString()));
		else return "ERROR";
	}
	public String get(String title){
		return get(getIndex(title));
	}
	public boolean contains(String title){
		for(int i = 0; i< size; i++){
			if(data[i].equals(title)) return true;
		}
		return false;
	}
	public int getIndex(String title){
		for(int i = 0; i< size; i++){
			if(data[i].equals(title)) return i;
		}
		return -1;
	}

	public boolean remove(int index){
		if(index <0 || index >= size) return false;
		for(int i = index; i< size; i++){		// Fjern ved at skifte efterfølgende elementer til plads venstre.
			data[i]= data[i+1];
		}
		for(int i = index; i< size; i++) {    // Skift også timestamps en plads til venstre.
			timestamps[i]=timestamps[i+1];
		}
		size--;
		return true;
	}
	public boolean remove(String title){
		return remove(getIndex(title));
	}
	public int size(){ return size; }
	public Dvd[] getArray(){
		return data;
	}
	public void printCollection(){
		for(int i = 0; i< size; i++){
			System.out.println(data[i].toString().concat(timestamps[i].toString()));
		}
		System.out.println();
	}
}
