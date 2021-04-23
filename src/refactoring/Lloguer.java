package refactoring;
  
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
  
public class Lloguer {
	private Date data;
	private int dies;
	private Vehicle vehicle;
	private double quantitat;
	
	public Lloguer(Date data, int dies,  Vehicle vehicle) {
		super();
		this.data = data;
		this.dies = dies;
		this.vehicle = vehicle;
	}
	public Date getData() { return data; }
	public int getDies() { return dies;	}
	public Vehicle getVehicle() { return vehicle; }
    
}
