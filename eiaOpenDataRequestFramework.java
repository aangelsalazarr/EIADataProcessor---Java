import java.util.ArrayList;
import java.util.List;

public class eiaOpenDataRequestFramework {
	
	public static void main(String arg) throws Exception {
		
		
		// purpose is to create a variable apiKey that holds the api Key
		String apiKey = "insert_api_key_here";
		
		// purpose is to create a list or array of series_id that can be used
		List <String> seriesID = new ArrayList <String>();
		
		// series id 1: US Average Retail Price of Natural Gas, Residential Sector
		seriesID.add("STEO.NGRCUUS.M");
		
		// series id 2: US Average Retail Price of Natural Gas, Commercial Sector
		seriesID.add("STEO.NGCCUUS.M");
		
		// series id 3: US Average Retail Price on Natural Gas, Industrial Sector
		seriesID.add("STEO.NGICUUS.M");
		
		// series id 4: Cost of Natural Gas Delivered to Electric Generating Plants
		seriesID.add("STEO.NGEUDUS.M");
		
		// series id 5: Cost of Coal Delivered to Electric Generating Plants
		seriesID.add("STEO.CLEUDUS.M");
		
		// series id 6: US Total Retail Price of Electricity, All Sectors
		seriesID.add("STEO.ESTCU_US.M");
		
		// series id 7: Natural Gas Total Marketed Production
		seriesID.add("STEO.NGMPPUS.M");
		
		// series id 8: US Natural Gas Consumption
		seriesID.add("STEO.NGTCPUS.M");
		
		// series id 9: US Total Natural Gas Working Inventory
		seriesID.add("STEO.NGWGPUS.M");
		
		// series id 10: Total Consumption of Renewable Energy, All Sectors
		seriesID.add("STEO.RETCBUS.M");
		
		// series id: Electric Power Sector Large-Scale Solar Net Summer Capacity
		seriesID.add("STEO.SOEPCAPX_US.M");
		
		// series id: US Crude Oil Production
		seriesID.add("STEO.COPRPUS.M");
		
		// series id: Total Petroleum and Other Liquids Product Supplied
		seriesID.add("STEO.PATCPUSX.M");
		
		// series id: Total End of Period Commercial Crude Oil and Others Inventory
		seriesID.add("STEO.PASXPUS.M");
		
		// series id: Total Refinery Output
		seriesID.add("STEO.PAROPUS.M");
		
		// series id: Refinery Operable Distillation Capacity
		seriesID.add("STEO.ORCAPUS.M");
		
		// series id 17: Total Energy CO2 Emissions
		seriesID.add("STEO.TETCCO2.M");
		
		// series id: Energy Expenditures as Share of GDP
		seriesID.add("TOTAL.TEGDSUS.A");
		
		// series id: Total Primary Energy Consumption
		seriesID.add("TOTAL.TETCBUS.A");
		
		// series id: Energy Expenditures
		seriesID.add("TOTAL.TETCVUS.A");
		
		// series id: Energy Balance
		seriesID.add("TOTAL.TENIVUS.M");
		
		// series id: Crude Oil and Natural Gas Rotary Rigs in Operation
		seriesID.add("TOTAL.OGNRPUS.M");
		
		// series id: Total Footage Drilled
		seriesID.add("TOTAL.OGTFPUS.M");
		
		// series id: Wells Drilled, Crude Oil
		seriesID.add("TOTAL.PATWPUS.M");
		
		// series id: Total Natural Gas Wells Drilled
		seriesID.add("TOTAL.NGTWPUS.M");
		
		// series id: Total Fossil Fuels Production
		seriesID.add("TOTAL.FFPRBUS.M");
		
		// series id: Total Renewable Energy Production
		seriesID.add("TOTAL.REPRBUS.M");
		
		// series id: Primary Energy Stock Change and Other
		seriesID.add("TOTAL.TEAJBUS.M");
		
		// series id: Total Primary Energy Production
		seriesID.add("TOTAL.TEPRBUS.M");
		
		// series id: Total Small-Scale Solar Photovoltaic Capacity, Monthly
		seriesID.add("STEO.SODTC_US.M");
		
		// series id 31: Industrial and Commercial Sector Net Generation From Utilitiy-Scale Solar Capacity, Monthly 
		seriesID.add("STEO.SOCHGEN_US.M");
		
		// creating a new arraylist which will be the destination of the complete url that is needed to make a request
		List <String> urlComplete = new ArrayList <String>();
		
		// purpose is to iterate through arraylist and concatonate api key, url, and series id
		for (int i = 0; i < seriesID.size(); i++) {
			
			// adding complete url to our arraylist, urlComplete
			urlComplete.add("https://api.eia.gov/series/?api_key=" + apiKey + "&series_id=" + i);
		}
		
		// checking our arraylist seriesID
		System.out.println(seriesID);
		
		// checking our arraylist, urlComplete
		System.out.println(urlComplete);

	}

	
}
