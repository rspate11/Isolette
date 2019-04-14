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
	
	}
	
	

	public void settemp(float roomt) {
		this.roomtemp = roomt;		
		//System.out.println(roomtemp);
	}
	
	
	public float gettemp(float c, double d, double b) {
		this.roomtemp = c;
//		System.out.println(roomtemp);
		roomtemp = (float) (roomtemp + d + b);
		
		return roomtemp;
	}
}
