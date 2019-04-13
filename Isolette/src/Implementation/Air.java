package Implementation;

/**
 * Air is affected by the room temperature, baby temperature and heat source.
 */
public class Air {

	private float roomtemp ;
	public float t; 

	/**
	 * calculates the current temperature of the room.
	 */
	
	Air(){
	roomtemp = 99;
		
	}
	public void settemp(float roomt) {
		this.roomtemp = roomt;		
		System.out.println(roomtemp);
	}
	
	
	public float gettemp(double d, double b) {
		
		roomtemp = (float) (roomtemp + d + b);
		
		return roomtemp;
	}
}
