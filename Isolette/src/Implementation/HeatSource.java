package Implementation;
/**
 * The heat source is turned ON by the thermostat when the current temperature drops below the desired temperature.
 * 
 */
public class HeatSource {

	private boolean heatStatus ;

	private double heatgradient;
	
	HeatSource(){
//		heatStatus = false;
//		heatgradient = 0;
	}
	public HeatSource(Boolean heat) {
		this.heatStatus = heat;
	}
	/**
	 * Increases the temperature when ON.
	 */
	public double incrTemp(Boolean r) {

		boolean h = getheatStatus();
		System.out.println(r);
		System.out.println(h);
		if (r) {
			heatgradient = +3;
			System.out.println(" increment temperature in thermostat via heatsource");
		
		}
		else {
			heatgradient = -2;
			System.out.println(" decrement temperature in thermostat as heatsource is off");
		}
		return heatgradient;
	}

	/**
	 * gets the heat status form the thermostat (ON or OFF) 
	 */
	
	public boolean getheatStatus() {
		return heatStatus;
	}
	public void setheatStatus(Boolean h) {
		this.heatStatus = h;
		if (heatStatus) {
		System.out.println(" heat status set on");}
		
	}

}
