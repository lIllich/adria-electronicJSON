package package1;

import java.util.ArrayList;

public class Configuration {
	public General general = new General();
	public Dashboard dashboard = new Dashboard();
	public ArrayList<Lights> light = new ArrayList<Lights>();
	public HVAC hvac = new HVAC();
	public ArrayList<Blinds> blinds = new ArrayList<Blinds>();
	public Room room = new Room();

}
