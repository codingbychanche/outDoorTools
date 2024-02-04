package metroTools;

/**
 * Metrological tools. 
 * 
 * @author berthold
 *
 */
public class AirPressure {
	
	/**
	 * Calculates the altitude based on the actual pressure mesured at an observers position
	 * relative to a reffernce pressure. Pressures units are [hPa]. 
	 * 
	 * @param actualPressure_hPa		Pressure measured.
	 * @param reffernecePressure_hPA	Refference pressure.
	 * @return	Altitide in [m].
	 */
	public static float altitude (float actualPressure_hPa,float reffernecePressure_hPA){
		float pow=1/5.255f;
		float alt=(float) ((288.15/0.0065)*(1-(Math.pow((actualPressure_hPa/reffernecePressure_hPA),pow))));
	
		return alt;
	}
}
