package controllers;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import play.mvc.Controller;
import play.mvc.Http.Request;
import play.mvc.Result;
import services.UserService;
import views.ApplicantNameVo;
import views.FoodTruckRequestVO;

public class UserController extends Controller {
	
	UserService service = new UserService();
	
	public CompletableFuture<Result> getTrucksByApplicantName() throws InterruptedException, ExecutionException, JsonProcessingException, IOException {
		CompletableFuture<Result> result = new CompletableFuture<>();
		JsonNode request = request().body().asJson();
		play.data.Form<ApplicantNameVo> requestForm = play.data.Form.form(ApplicantNameVo.class);
		ApplicantNameVo requestOffer =  requestForm.bind(request).get();
		try{
			service.getTrucksByApplicantName(requestOffer.getApplicantName()).thenApply(searchResults -> {
	 	        result.complete(ok((searchResults)));
	 	        return null;
			});
		}catch(Exception ex){
			play.Logger.error("Error in finding foodtruck by applicant name "+ex);
		}
 		return result;
	}
	
	public CompletableFuture<Result> getExpiredPermitsByDate(String date) throws InterruptedException, ExecutionException, JsonProcessingException, IOException {
		CompletableFuture<Result> result = new CompletableFuture<>();
		try{
			service.getExpiredPermits(date).thenApply(searchResults -> {
	 	        result.complete(ok((searchResults)));
	 	        return null;
			});
		}catch(Exception ex){
			play.Logger.error("Error find expired permits "+ex);
		}
 		return result;
	}
	
	public CompletableFuture<Result> getTrucksByStreetName(String streetName) throws InterruptedException, ExecutionException, JsonProcessingException, IOException {
		CompletableFuture<Result> result = new CompletableFuture<>();
		try{
			service.getByStreetName(streetName).thenApply(searchResults -> {
	 	        result.complete(ok((searchResults)));
	 	        return null;
			});
		}catch(Exception ex){
			play.Logger.error("Error in finding foodtruck by street name "+ex);
		}
 		return result;
	}
	
	
	public CompletableFuture<Result> getBestTruckFor(String latitude, String longitude) throws InterruptedException, ExecutionException, JsonProcessingException, IOException {
		CompletableFuture<Result> result = new CompletableFuture<>();
		try{
			service.getBestNearByTruck(latitude, longitude).thenApply(searchResults -> {
	 	        result.complete(ok((searchResults)));
	 	        return null;
			});
		}catch(Exception ex){
			play.Logger.error("Error in finding best nearby truck "+ex);
		}
 		return result;
	}
	
	
	public CompletableFuture<Result> addFoodTruck() throws InterruptedException, ExecutionException, JsonProcessingException, IOException {
		CompletableFuture<Result> result = new CompletableFuture<>();
		JsonNode request = request().body().asJson();
		play.data.Form<FoodTruckRequestVO> requestForm = play.data.Form.form(FoodTruckRequestVO.class);
		FoodTruckRequestVO requestVO =  requestForm.bind(request).get();
		try{
			service.addTruck(requestVO).thenApply(searchResults -> {
	 	        result.complete(ok((searchResults)));
	 	        return null;
			});
		}catch(Exception ex){
			play.Logger.error("Error in adding foodtruk to db "+ex);
		}
 		return result;
	}
	
	
	public CompletableFuture<Result> markLicenceExpired() throws InterruptedException, ExecutionException, JsonProcessingException, IOException {
		CompletableFuture<Result> result = new CompletableFuture<>();
		try{
			service.markLicenceExpired().thenApply(searchResults -> {
	 	        result.complete(ok((searchResults)));
	 	        return null;
			});
		}catch(Exception ex){
			play.Logger.error("Error in marking licence expired "+ex);
		}
 		return result;
	}
	public CompletableFuture<Result> deleteFoodTruck(String cnn) throws InterruptedException, ExecutionException, JsonProcessingException, IOException {
		CompletableFuture<Result> result = new CompletableFuture<>();
		try{
			service.deleteFoodTruck(cnn).thenApply(searchResults -> {
	 	        result.complete(ok((searchResults)));
	 	        return null;
			});
		}catch(Exception ex){
			play.Logger.error("Error in deleting food truck "+ex);
		}
 		return result;
	}
}
