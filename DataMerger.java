import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class DataMerger {
	
	public static void main(String[] args) throws Exception {

		// save original out stream
		PrintStream originalOut = System.out;
		
		// create a new file file output stream
		PrintStream fileOut = new PrintStream("./mergedEnergyData.json");
		
		// redirect standard out to file
		System.setOut(fileOut);
		
		// let's establish a list of URLs that we want to use
		List <String> urlList = new ArrayList <String>();
		
		// us crude oil production data
		urlList.add("https://api.eia.gov/series/?api_key=45fc211dc417f6b7a53609c99ab0546a&series_id=STEO.COPRPUS.M");
		
		// electricity pricing data
		urlList.add("https://api.eia.gov/series/?api_key=45fc211dc417f6b7a53609c99ab0546a&series_id=STEO.ESTCU_US.M");
		
		// energy expenditure data
		urlList.add("https://api.eia.gov/series/?api_key=45fc211dc417f6b7a53609c99ab0546a&series_id=TOTAL.TEGDSUS.A");
		
		// industrial commercial solar generation
		urlList.add("https://api.eia.gov/series/?api_key=45fc211dc417f6b7a53609c99ab0546a&series_id=STEO.SOCHGEN_US.M");
		
		// renewable energy consumption data
		urlList.add("https://api.eia.gov/series/?api_key=45fc211dc417f6b7a53609c99ab0546a&series_id=STEO.RETCBUS.M");
		
		// small scale solar capacity data
		urlList.add("https://api.eia.gov/series/?api_key=45fc211dc417f6b7a53609c99ab0546a&series_id=STEO.SODTC_US.M");
		
		// solar net summer capacity data
		urlList.add("https://api.eia.gov/series/?api_key=45fc211dc417f6b7a53609c99ab0546a&series_id=STEO.SOEPCAPX_US.M");
		
		// total energy carbon emissions data
		urlList.add("https://api.eia.gov/series/?api_key=45fc211dc417f6b7a53609c99ab0546a&series_id=STEO.TETCCO2.M");
		
		// total primary energy consumption data
		urlList.add("https://api.eia.gov/series/?api_key=45fc211dc417f6b7a53609c99ab0546a&series_id=TOTAL.TETCBUS.M");
		
		// total primary energy production data
		urlList.add("https://api.eia.gov/series/?api_key=45fc211dc417f6b7a53609c99ab0546a&series_id=TOTAL.TEPRBUS.M");
		
		// total renewable energy production data
		urlList.add("https://api.eia.gov/series/?api_key=45fc211dc417f6b7a53609c99ab0546a&series_id=TOTAL.REPRBUS.M");
		
		// here we want to automate a process where we create a list of given series_id and the api key
		
		
		// here we are going to iterate over a list and apply the energy data processor method
		for (int i = 0; i < urlList.size(); i++) {
			
			// run the energy data processor main method
			energyDataProcessor edp = new energyDataProcessor(urlList.get(i));
			edp.run();
			
		
	}

}
}
