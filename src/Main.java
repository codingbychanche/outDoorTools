import TimeTools.TimeDateFormat;
import geoTools.SunriseSunset;
import metroTools.AirPressure;
import metroTools.DewPoint;

/**
 * Shows a demo of the various classes....
 * 
 * @author berthold
 *
 */
public class Main {

		private static final int DAY_OF_YEAR=260;
		private static final double LAT=54.2;
		private static final double LONG=6.12;
		private static final int TIME_ZONE=1;

		public static void main(String[] args) {
			
			//
			// Test of geo tools
			// Show sunrise/ sunset
			//
			
			int dayOfYear=DAY_OF_YEAR;  //TimeDateFormat.getDayOfCurrentYear();
			System.out.println("Day of year:"+dayOfYear);
			
			System.out.println("Timezone:"+TimeDateFormat.getCurrentTimezoneName());
			System.out.println("Timezone:"+TimeDateFormat.getCurrentTimezoneOffset());
			System.out.println("Timezone GMT +"+TimeDateFormat.getTimeZoneOffsetIn_h());
			System.out.println("Longtitute:"+LONG+"   Latitute:"+LAT);
		
			double dec=SunriseSunset.getSunDeclinationIn_Rad(DAY_OF_YEAR);
			System.out.println("Declination:"+SunriseSunset.toGrad(dec));
			
			double timeOfSunrise=SunriseSunset.getSunriseTimeAtObserversLocationIn_h(LONG, LAT, dayOfYear, TIME_ZONE);
			System.out.println("Sunrise:"+timeOfSunrise);
			System.out.println("Sunrise:"+TimeDateFormat.getTimeInTwentyFourHourFormat(timeOfSunrise));
			
			double timeOfSunset=SunriseSunset.getSunsetTimeAtObserversLocationIn_h(LONG, LAT, dayOfYear, TIME_ZONE);
			System.out.println("Sunset:"+timeOfSunset);
			System.out.println("Sunset:"+TimeDateFormat.getTimeInTwentyFourHourFormat(timeOfSunset));
	
			//
			// Metro tools
			//

			// Dew Point
			float temperature=28; // Degrees...
			float relHum=30; // percent		
			float dewPoint=DewPoint.dewPointTemperature_C(temperature,relHum );
			System.out.println("Dew point:"+dewPoint+" C'");
			
			// Altitute from air pressure
			float refferencePressure_hPa=1000f;
			float actualPressure_hPa=996;
			float alt=AirPressure.altitude(actualPressure_hPa,refferencePressure_hPa);
			System.out.println("Altitude (relative to reffernece="+refferencePressure_hPa+")="+alt+" m");
			
		
		}

}
