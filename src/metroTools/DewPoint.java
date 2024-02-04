package metroTools;

public class DewPoint {
	
	/**
	 * Calculates the dew point based on current temperature and relative
	 * humidity based on the formula by <i>Magnus</i>.
	 * 
	 * @param currentTempIn_C
	 * @param relativeHumidity_Percent
	 * @return dew point temperature in C&ordm;
	 */
	public static float dewPointTemperature_C(float currentTempIn_C, float relativeHumidity_Percent) {
		final float FAKTOR = 6.1078f;

		float a=0,b=0;
		if (currentTempIn_C >= 0) {
			a = 7.5f;
			b = 237.3f;
		} 
		
		if (currentTempIn_C < 0) {
			a = 7.6f;
			b = 240.7f;
		} 

		float sdd_hPa = (float) (FAKTOR * Math.pow(10, ((a * currentTempIn_C) / (b + currentTempIn_C))));
		float dd_hPA = (relativeHumidity_Percent / 100) * sdd_hPa;
		float v = (float) Math.log10(dd_hPA / FAKTOR);
		float Td_C = (b * v / (a - v));

		return Td_C;
	}
}
