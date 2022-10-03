package package1;

public class Sustav {
	public String iD;
	public String type;
	public String locationID;
	public Configuration configuration = new Configuration();
	
	public String getID() {
		return iD;
	}
	public void setID(String iD) {
		this.iD = iD;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocationID() {
		return locationID;
	}
	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}
	public Configuration getConfiguration() {
		return configuration;
	}
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	
	
}
