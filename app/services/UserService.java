package services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.apache.http.client.ClientProtocolException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.MobileFoodTruckConstants;
import play.api.libs.json.Json;
import utils.HttpUtils;


public class UserService {
	
	static Map<String, String> userCityMap = new HashMap<String, String>();
	
	public CompletableFuture<String> getTrucksByApplicantName(String applicantName) throws ClientProtocolException, IOException{
		CompletableFuture<String> ss = new CompletableFuture<>();
		applicantName = applicantName.replaceAll(" " , "+");
		String completeUrl = MobileFoodTruckConstants.MOBILE_FOOD_SCHEDULE_URL+"?$where=applicant='"+applicantName+"'";
		Map<String, String> responseMap = null;
		if(applicantName!=null){
			responseMap=HttpUtils.executeGet(completeUrl, null, null, "UTF-8", 5000);
		}
		if(responseMap!=null){
			ss.complete(responseMap.get("response"));
		}
		else ss.complete("Failed to get any food truck data");
		return ss;
	}
	
	public CompletableFuture<String> getExpiredPermits(String date) throws ClientProtocolException, IOException{
		CompletableFuture<String> ss = new CompletableFuture<>();
		date = date.replaceAll(" " , "+");
		String completeUrl = MobileFoodTruckConstants.FOOD_TRUCK_PERMIT_URL+"?$where=expirationdate%3E'"+date+"'";
		completeUrl=completeUrl.replace(" ", "");
		Map<String, String> responseMap = null;
		if(date!=null){
			responseMap=HttpUtils.executeGet(completeUrl, null, null, "UTF-8", 5000);
		}
		if(responseMap!=null){
			ss.complete(responseMap.get("response"));
		}
		else ss.complete("Failed to get any food truck data");
		return ss;
	}
	
	public CompletableFuture<String> getByStreetName(String streetName) throws ClientProtocolException, IOException{
		CompletableFuture<String> ss = new CompletableFuture<>();
		streetName = streetName.replaceAll(" " , "+");
		String completeUrl = MobileFoodTruckConstants.FOOD_TRUCK_PERMIT_URL+"?$q="+streetName;
		completeUrl=completeUrl.replace(" ", "");
		Map<String, String> responseMap = null;
		if(streetName!=null){
			responseMap=HttpUtils.executeGet(completeUrl, null, null, "UTF-8", 5000);
		}
		if(responseMap!=null){
			ss.complete(responseMap.get("response"));
		}
		else ss.complete("Failed to get any food truck data");
		return ss;
	}
	
	public CompletableFuture<String> getBestNearByTruck(String latitude, String longitude) throws ClientProtocolException, IOException{
		CompletableFuture<String> ss = new CompletableFuture<>();
		String completeUrl = MobileFoodTruckConstants.FOOD_TRUCK_PERMIT_URL;
		completeUrl=completeUrl.replace(" ", "");
		Map<String, String> responseMap = null;
		responseMap=HttpUtils.executeGet(completeUrl, null, null, "UTF-8", 5000);
		String response  = responseMap.get("response");
		JsonNode nearestTruck = getNearestFoodTruck(response, latitude, longitude);
		if(nearestTruck!=null)ss.complete(nearestTruck.toString());
		else ss.complete("no truck found");
		return ss;
	}

	private JsonNode getNearestFoodTruck(String response, String lat22, String lon22) throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(response);
		JsonNode nearestTruck = null;
		Double minDiance=999999.0;
		for(JsonNode node : actualObj){
			JsonNode cornidates = node.get("location").get("coordinates");
			String lat11 = cornidates.get(0).toString();
			String lon11 = cornidates.get(1).toString();
			Double distance = calculateDistance(lat11, lon11, lat22, lon22);
			if(minDiance>distance){
				minDiance=distance;
				nearestTruck=node;
			}
		}
		return nearestTruck;
	}
	
	Double calculateDistance(String lat11, String lon11, String lat22, String lon22){
	        final int R = 6371; // Radius of the earth
	        Double lat1 = Double.parseDouble(lat11);
	        Double lon1 = Double.parseDouble(lon11);
	        Double lat2 = Double.parseDouble(lat22);
	        Double lon2 = Double.parseDouble(lon22);
	        Double latDistance = toRad(lat2-lat1);
	        Double lonDistance = toRad(lon2-lon1);
	        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + 
	                   Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) * 
	                   Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	        Double distance = R * c;
	        return distance;
	 }
		
	private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }
	
	
	
}
