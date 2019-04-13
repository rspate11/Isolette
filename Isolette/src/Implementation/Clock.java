package Implementation;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Clock provides with the even boolean which triggers the temperature sensors to get the current temperautre every second. 
 */
public class Clock {

	/**
	 * For triggering the temperature sensor
	 */
	
	private boolean eventsecond;
	private boolean on = false;
	/**
	 * This method sets the event variable whenever the isolette is turned ON by the Nurse.
	 */
	
	TempSensor ts ;
	Thermostat t ;
	Nurse n;
	public Clock(boolean onevent,TempSensor ts, Thermostat t, Nurse n,Baby b, HeatSource h) {
		this.ts= ts;
		this.t = t;
		this.n=n;
		this.on = onevent;
		Timer timer = new Timer();
		if (on) {


		timer.schedule( new TimerTask() {
		    public void run() {
		       setevent(on);
		       
		       t.setStatuses(n);
		       ts.setevent(on,b,h,t);
		       
//		       System.out.println(getevent());
		       
		    }
		 }, 0, 10*1000);
	}
		else {
			setevent(on);
			ts.setevent(on,b,h,t);
			timer.cancel();
			System.exit(0);
//			System.out.println(getevent());
		}
	}
	
	
//	public boolean getevent() {
//		return eventsecond;
//	}
	
	
	public void setevent(Boolean on) {
		this.eventsecond = on;
		
	}
	

}