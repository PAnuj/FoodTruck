package controllers;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import play.mvc.Controller;
import play.mvc.Http.Request;
import play.mvc.Result;
import services.UserService;

public class UserController extends Controller {
	
	UserService service = new UserService();
	
	public CompletableFuture<Result> getTrucksByApplicantName(String applicantName) throws InterruptedException, ExecutionException, JsonProcessingException, IOException {
		CompletableFuture<Result> result = new CompletableFuture<>();
		service.getTrucksByApplicantName(applicantName).thenApply(searchResults -> {
 	        result.complete(ok((searchResults)));
 	        return null;
		});
 		return result;
	}
	
	public CompletableFuture<Result> getExpiredPermitsByDate(String applicantName) throws InterruptedException, ExecutionException, JsonProcessingException, IOException {
		CompletableFuture<Result> result = new CompletableFuture<>();
		service.getExpiredPermits(applicantName).thenApply(searchResults -> {
 	        result.complete(ok((searchResults)));
 	        return null;
		});
 		return result;
	}
	
	public CompletableFuture<Result> getTrucksByStreetName(String streetName) throws InterruptedException, ExecutionException, JsonProcessingException, IOException {
		CompletableFuture<Result> result = new CompletableFuture<>();
		service.getByStreetName(streetName).thenApply(searchResults -> {
 	        result.complete(ok((searchResults)));
 	        return null;
		});
 		return result;
	}
	
	
	public CompletableFuture<Result> getBestTruckFor(String latitude, String longitude) throws InterruptedException, ExecutionException, JsonProcessingException, IOException {
		CompletableFuture<Result> result = new CompletableFuture<>();
		service.getBestNearByTruck(latitude, longitude).thenApply(searchResults -> {
 	        result.complete(ok((searchResults)));
 	        return null;
		});
 		return result;
	}
	
}
