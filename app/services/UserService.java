package services;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.apache.http.client.ClientProtocolException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.uitoolkit.impl.fx.Utils;

import models.FoodTruckInfo;
import views.FoodTruckRequestVO;


public class UserService {
	
	static Map<String, String> userCityMap = new HashMap<String, String>();
	
	public CompletableFuture<String> getTrucksByApplicantName(String applicantName) throws ClientProtocolException, IOException{
		CompletableFuture<String> ss = new CompletableFuture<>();
		List<FoodTruckInfo> listOfFT =  Ebean.find(FoodTruckInfo.class).where().eq("applicant", applicantName).findList();
		if(listOfFT!=null){
			ss.complete(utils.Utils.getJsonStringFromObject(listOfFT));
		}
		else ss.complete("No food truck found");
		return ss;
	}
	
	public CompletableFuture<String> getExpiredPermits(String date) throws ClientProtocolException, IOException{
		CompletableFuture<String> ss = new CompletableFuture<>();
		date = date.replaceAll(" " , "+");
		List<FoodTruckInfo> listOfFT =  Ebean.find(FoodTruckInfo.class).where().lt("expirationdate", date).findList();
		if(listOfFT!=null){
			ss.complete(utils.Utils.getJsonStringFromObject(listOfFT));
		}
		else ss.complete("No food truck found");
		return ss;
	}
	
	public CompletableFuture<String> getByStreetName(String streetName) throws ClientProtocolException, IOException{
		CompletableFuture<String> ss = new CompletableFuture<>();
		List<FoodTruckInfo> listOfFT =  Ebean.find(FoodTruckInfo.class).where().ilike("locationdescription", "%"+streetName+"%").findList();
		if(listOfFT!=null){
			ss.complete(utils.Utils.getJsonStringFromObject(listOfFT));
		}
		return ss;
	}
	
	public CompletableFuture<String> getBestNearByTruck(String latitude, String longitude) throws ClientProtocolException, IOException{
		CompletableFuture<String> ss = new CompletableFuture<>();
		List<FoodTruckInfo> listOfFT =  Ebean.find(FoodTruckInfo.class).findList();
		JsonNode nearestTruck = getNearestFoodTruck(listOfFT, latitude, longitude);
		if(nearestTruck!=null)ss.complete(nearestTruck.toString());
		else ss.complete("no truck found");
		return ss;
	}

	private JsonNode getNearestFoodTruck(List<FoodTruckInfo> listOfFT, String lat22, String lon22) throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode nearestTruck = null;
		Double minDiance=999999.0;
		for(FoodTruckInfo foodtruck : listOfFT){
			JsonNode node  = mapper.readTree(foodtruck.getLocation());
			if(node!=null){
				JsonNode cornidates = node.get("coordinates");
				String lat11=null;
				String lon11=null;
				if(cornidates!=null){
					lat11 = cornidates.get(0).toString();
					lon11 = cornidates.get(1).toString();
					Double distance = calculateDistance(lat11, lon11, lat22, lon22);
					if(minDiance>distance){
						minDiance=distance;
						nearestTruck=utils.Utils.convertObjectToJsonNode(foodtruck);
					}
				}
				
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


	public CompletableFuture<String> addTruck(FoodTruckRequestVO requestVO) {
		CompletableFuture<String> ss = new CompletableFuture<>();
		try {
			FoodTruckInfo foodtruckModel = requestVO.getModelFronVO();
			Ebean.save(foodtruckModel);
			ss.complete(("data added"));
			
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ss.complete(("not added"));
		}
		
		return ss;
	}

	public CompletableFuture<String> markLicenceExpired() {
		CompletableFuture<String> ss = new CompletableFuture<>();
		
		List<FoodTruckInfo> listOfFT =  Ebean.find(FoodTruckInfo.class).findList();
		SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		String current_time_str = time_formatter.format(System.currentTimeMillis());
		for(FoodTruckInfo foodtruck : listOfFT){
			if(foodtruck.getExpirationdate().compareTo(current_time_str)<0){
				foodtruck.setStringstatus("EXPIRED");
				Ebean.update(foodtruck);
			}
		}
		ss.complete(("Foodtrucks updated"));
		return ss;
	}

	public CompletableFuture<String> deleteFoodTruck(String cnn) {
		CompletableFuture<String> ss = new CompletableFuture<>();
		List<FoodTruckInfo> foodTrucks = Ebean.find(FoodTruckInfo.class).where().eq("cnn", cnn).findList();
		if(foodTrucks!=null && foodTrucks.size()>0){
			Ebean.delete(foodTrucks.get(0));
			ss.complete(("Foodtruck Removed"));
		}
		else ss.complete("No Foodtruck founf with given cnn");
		return ss;
	}
	
	
	
}
