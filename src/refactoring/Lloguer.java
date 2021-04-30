package refactoring;

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
    
	public double quantitat() {
    	double quantitat = 0;
        switch (this.getVehicle().getCategoria()) {
            case Vehicle.BASIC:
                quantitat += 3;
                if (this.getDies() > 3) {
                    quantitat += (this.getDies() - 3) * 1.5;
                }
            case Vehicle.GENERAL:
                quantitat += 4;
                if (this.getDies() > 2) {
                    quantitat += (this.getDies() - 2) * 2.5;
                }
                break;
            case Vehicle.LUXE:
                quantitat += this.getDies() * 6;
                break;
        }
		return quantitat;
    }
    public int bonificacions() {
	    int bonificacions = 0;
	    bonificacions++;
    	if (this.getVehicle().getCategoria() == Vehicle.LUXE &&
	            this.getDies()>1 ) {
	        bonificacions++;
	    }
    	return bonificacions;
    }
}
