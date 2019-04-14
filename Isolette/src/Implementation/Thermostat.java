package Implementation;

/**
 * Thermostat interacts with the temperature sensor to know the current temperature and set the variables for heatsource and alarm
 */
public class Thermostat {

	/**
	 * Thermostat initially begins in the Normal mode but the mode changes when there is failure (internal , regualtor, monitor, display or invalid temperature inputs)
	 */
	private boolean mode = true;

	/**
	 * Status is changed when thermostat is working properly and the desired temperature is achieved to show that the nurse has put the baby inside the isolette
	 */
	boolean babyStatus  ;

	boolean heatStatus  ;

	private boolean alarmStatus ;
	private float currTemp  ;
	enum state{INIT,NORMAL,FAILURE;}
	/**
	 * Set when the desired temperatures put by the nurse are invalid
	 */
	private state regulatorStatus= state.INIT;

	/**
	 * Set when the alarm temperatures put by the nurse are invalid
	 */
	private state monitorStatus = state.INIT;
//	
//	HeatSource h = new HeatSource();
//	Baby b = new Baby();
	//TempSensor ts = new TempSensor(); 
	Nurse n = new Nurse();
	Alarm a = new Alarm();
	Thermostat(){
//		currTemp = 0;
//		babyStatus = false;
//		heatStatus = false;
//		alarmStatus = false;
	}

	/**
	 * Sets the thermostat mode
	 */
	public boolean setMode(Display d) {
	
	
		boolean m1 ;
		//= d.setStatus(n);

		boolean t = d.setStatus(n)[0];
		boolean m = d.setStatus(n)[1];
		if (t ) {regulatorStatus = state.FAILURE;
		System.out.printf("Regulator Failure" , regulatorStatus);
		System.out.println("");}
		if (m ) {monitorStatus = state.FAILURE;
		System.out.printf("Monitor Failure",monitorStatus);
		System.out.println("");}
		if (t||m ) {m1 = true;}
		else {m1 = false;}
		
		
		
		if(m1)
		{
			mode = false;
			alarmStatus = true;
			babyStatus = false;
			a.displayAlarm();
//			System.out.println(" ALARM ");
			d.setmode(mode);
			Baby b = new Baby(false);
			b.setbStatus(false);
		}
		else 
		{
			mode = true;
			d.setmode(mode);
		}

		return mode;

	}

	/**
	 * set the alarm and heat source status to be turned ON or OFF.
	 * @param nurse 
	 * @param t 
	 */

	public void setStatuses( Nurse n ) {
		//System.out.println(currTemp);
		//System.out.println(mode);	
		
		if(mode)
		{
			if(currTemp >= n.getDmin() && currTemp <= n.getDmax()) {
				Baby b = new Baby(true);
				babyStatus = true;
				b.setbStatus(true);
			} 
			if(currTemp < n.getDmin())
			{
				heatStatus = true;
				HeatSource h = new HeatSource(true);
				h.setheatStatus(true);
				
			}
			if(currTemp > n.getDmax())
			{
				heatStatus = false;
				HeatSource h = new HeatSource(false);
				h.setheatStatus(false);
			}
			if((currTemp >= n.getAmax()) || (currTemp <= n.getAmin()))
			{
				alarmStatus = true;
//				System.out.println(" ALARM  2");
				a.displayAlarm();
				Baby b = new Baby(false);
				babyStatus = false;
				b.setbStatus(false);
				
			}
			if((currTemp <= n.getAmax()) && (currTemp >= n.getAmin()))
			{
				alarmStatus = false;
				//b.setbStatus(true);
			}
		}
		
		else {
			System.out.println("Regulator / Monitor / Internal Failure has occured");
			System.exit(0);

			
		}
	}

	public void setcurrTemp(float currTemp) {
		this.currTemp = currTemp;
		
		
	}

}
