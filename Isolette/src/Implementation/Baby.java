package Implementation;
/**
 * Baby affects the temperature of the room 
 */
public class Baby extends User {

	/**
	 * Depicts if the baby is put in the isolette or not
	 */
	private boolean bStatus ;
	private double bgradient ;
	

	/**
	 * get the status of presence of baby form the thermostat. Baby is put inside when the temperature of the isolette is within the range of the desired ranges entered by the nurse
	 */
	public Baby(){
//		bStatus = false;
//		bgradient = 0;
	}
	public Baby(Boolean baby) {
		this.bStatus = baby;
	}
	
	public boolean getbStatus() {
		return this.bStatus;
	}
	
	
	public double bGradient(Boolean r) {

		boolean b = getbStatus();
		//System.out.println(r);
		//System.out.println(bStatus);
		if(r) {
			bgradient = + 1;
		}
		else {
			bgradient = 0;
		}
		
		return bgradient;
	}
	public void setbStatus(Boolean b) {
		this.bStatus = b;
		if (bStatus) {
			//System.out.println(" Baby is put inside");
		}
		else {
			//System.out.println(" Baby is removed ");
			}
	}
	
}
