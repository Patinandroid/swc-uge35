
import java.time.LocalTime;

/**
 * Created by tomas on 9/2/16.
 */
public class Dvd {
	private String dvdTitle;

	public Dvd() {
		this.dvdTitle = "No title";
	}
	public Dvd(String dvdTitle){
		this.dvdTitle=dvdTitle;
	}

	public void setDvdTitle(String title){
		this.dvdTitle = title;
	}
	public String getDvdTitle(){
		return dvdTitle;
	}
	@Override
	public String toString() {
		return dvdTitle;
	}
}
