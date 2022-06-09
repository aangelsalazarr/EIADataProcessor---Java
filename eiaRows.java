import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class eiaRows {
	Date date;
	String name;
	String units;
	Double value;
	String geography;
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUnits() {
		return units;
	}
	
	public void setUnits(String units) {
		this.units = units;
	}
	
	public Double getValue() {
		return value;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}
	
	public String getGeography() {
		return geography;
	}
	
	public void setGeography (String geography) {
		this.geography = geography;
	}
	
	public String toString() {
		return (this.date + ", " + this.name + ", "+ this.units + ", " + this.value + ", " + this.geography);
	}

}
