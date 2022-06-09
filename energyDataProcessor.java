import java.net.URL;
import java.text.SimpleDateFormat;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

//these import will be replaced by GSON
//import org.json.JSONObject;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONString;

//importing GSON which will be necessary for creating JSON Objects in our code
import com.google.gson.JsonElement;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class energyDataProcessor {
	
	String url;
	
	public energyDataProcessor(String url) {
		// TODO Auto-generated constructor stub
		this.url = url;
	}
	
	// here we are creating a an abstract method that will take a URL in order to run a data process
	public void run() throws Exception {
		
		// Here we are creating a var httpsURL which takes the argument and then --> to URL
		URL myUrl = new URL(this.url);
		
		// opening a connect, must ensure that there is a try/catch in case there are failures in this process
		int count = 0;
		int maxTries = 3;
		
		HttpsURLConnection conn = null;
		
		// purpose is to try the opening of the connection 3 times before failure
		while(true) {
			try {
				conn = (HttpsURLConnection)myUrl.openConnection();
			} catch (IOException e) {
				// essentially, if tries reach max int then throw e
				if (++count == maxTries) throw e;
				e.printStackTrace();
			}
			break;
		}
		
		// Input
		InputStream is = conn.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String inputLine;
		
		//here we are creating a new array list which we will be using later
		List <eiaRows> rowList = new ArrayList <eiaRows>();
		
		// in essence, as long as br is not empty, run the following
		while ((inputLine = br.readLine()) != null) {
            
            // [new code] in essence, we create a json parser first, then we create fileElement which is the parsed aspect of our inputLine
            // lastly, we convert this JsonElement to a json object 
            // create parser, then create JsonElement, then JsonElement -> JsonObject
            JsonParser parser = new JsonParser();
            JsonElement fileElement = new JsonParser().parse(inputLine);
            JsonObject obj_JsonObject = fileElement.getAsJsonObject();

            // [new code]
            JsonObject request = obj_JsonObject.getAsJsonObject("request");

            
            // [new code]
            JsonArray series = obj_JsonObject.getAsJsonArray("series");

            
            // [new code]
            JsonObject arrayIndex0 = series.get(0).getAsJsonObject();
            
            // [new code]
            JsonArray dataGrabbed = arrayIndex0.getAsJsonArray("data");
            
            // purpose is to now grab arrays within dataGrabbed that each contain "time" in "YYYYMM" format and value in int format
            // recursion will be the best way to go about this considering how many arrays there are in dataGrabbed
            for (int i = 0; i < dataGrabbed.size(); ++i) {        
            	
            	// [new code]
            	JsonArray data = dataGrabbed.get(i).getAsJsonArray();
            	
            	// [new code]
            	String time = data.get(0).getAsString();
            	
            	// here we will split the 'time' string
            	String year = time.substring(0, 4);
            	String month = time.substring(4);
            	
            	// purpose is to now put back together year and month in a date format "MM-YYYY"
            	String timeDated = year + "-" + month + "-" + "01";
            	
            	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMdd");
            	
            	String dateInString = timeDated;
            	
            	// converting String of timeDated to the Simple Date Format
            	Date date = formatter.parse(dateInString);
				
				// [new code]
            	Double value;
				try {
					value = data.get(1).getAsDouble();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					value = null;
				}
            	
            	// [new code] 
            	JsonObject json = new JsonObject();
            	
            	// [new code]
            	json.addProperty("date", timeDated);
            	json.addProperty("value", value);
            	json.addProperty("units", arrayIndex0.get("units").getAsString());
            	json.addProperty("name", arrayIndex0.get("name").getAsString());
            	
            	// [new code]
            	eiaRows row = new eiaRows();
            	row.setName(arrayIndex0.get("name").getAsString());
            	row.setValue(value);
            	row.setUnits(arrayIndex0.get("units").getAsString());
            	row.setDate(date);
            	
            	// if statement taking into account that not all will include geography
            	if (arrayIndex0.has("geography")) {
            		row.setGeography(arrayIndex0.get("geography").getAsString());
            	} else {
            		row.setGeography(null);
            	}
            	
            	rowList.add(row);
            	
            	System.out.println(row);
            	
		}
				
	}
		br.close();
	}

}
