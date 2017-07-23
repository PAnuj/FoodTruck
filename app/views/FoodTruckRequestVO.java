package views;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sun.deploy.uitoolkit.impl.fx.Utils;

import models.FoodTruckInfo;

public class FoodTruckRequestVO {
	
//	 ":@computed_region_bh8s_q3mv": "29491",
//	  ":@computed_region_fyvs_ahh9": "35",
//	  ":@computed_region_p5aj_wyqh": "8",
//	  ":@computed_region_rxqg_mtj9": "3",
//	  ":@computed_region_yftq_j783": "1",
	  String address; //"2401 36TH AVE",
	  String applicant;  //"Swell Cream & Coffee",
	  String block; // "2389",
	  String blocklot; //"2389001",
	  String cnn;  // "12412000",
	  String expirationdate;  //"2018-01-30T00:00:00.000",
	  String facilitytype; //"Truck",
	  String fooditems; //"Ice cream: coffee: pastries",
	  String latitude; // "37.7412902847707",
	  
	  FoodTruckLocationVO location;
	  
	  String locationdescription; //"TARAVAL ST: 36TH AVE to SUNSET BLVD (2600 - 2649)",
	  String longitude; // "-122.494377920435",
	  String lot;  //"001",
	  String objectid; //"931093",
	  String permit; //"17MFF-0002",
	  String priorpermit; // "0",
	  String received; //"2017-01-30",
	  String schedule; // "http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=17MFF-0002&ExportPDF=1&Filename=17MFF-0002_schedule.pdf",
	  String status; //: "REQUESTED",
	  String x; // "5985030.8",
	  String y; // "2098527.088"
	  
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String getBlocklot() {
		return blocklot;
	}
	public void setBlocklot(String blocklot) {
		this.blocklot = blocklot;
	}
	public String getCnn() {
		return cnn;
	}
	public void setCnn(String cnn) {
		this.cnn = cnn;
	}
	public String getExpirationdate() {
		return expirationdate;
	}
	public void setExpirationdate(String expirationdate) {
		this.expirationdate = expirationdate;
	}
	public String getFacilitytype() {
		return facilitytype;
	}
	public void setFacilitytype(String facilitytype) {
		this.facilitytype = facilitytype;
	}
	public String getFooditems() {
		return fooditems;
	}
	public void setFooditems(String fooditems) {
		this.fooditems = fooditems;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public FoodTruckLocationVO getLocation() {
		return location;
	}
	public void setLocation(FoodTruckLocationVO location) {
		this.location = location;
	}
	public String getLocationdescription() {
		return locationdescription;
	}
	public void setLocationdescription(String locationdescription) {
		this.locationdescription = locationdescription;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLot() {
		return lot;
	}
	public void setLot(String lot) {
		this.lot = lot;
	}
	public String getObjectid() {
		return objectid;
	}
	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}
	public String getPermit() {
		return permit;
	}
	public void setPermit(String permit) {
		this.permit = permit;
	}
	public String getPriorpermit() {
		return priorpermit;
	}
	public void setPriorpermit(String priorpermit) {
		this.priorpermit = priorpermit;
	}
	public String getReceived() {
		return received;
	}
	public void setReceived(String receive) {
		this.received = receive;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getStatus() {
		return status;
	}
	public void setStringstatus(String status) {
		this.status = status;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	  
	public FoodTruckInfo getModelFronVO() throws JsonGenerationException, JsonMappingException, IOException{
		FoodTruckInfo foodtruck = new FoodTruckInfo();
		foodtruck.setAddress(this.address);
		foodtruck.setApplicant(this.applicant);
		foodtruck.setBlock(this.block);
		foodtruck.setBlocklot(this.blocklot);
		foodtruck.setCnn(this.cnn);
		foodtruck.setExpirationdate(this.expirationdate);
		foodtruck.setFacilitytype(this.facilitytype);
		foodtruck.setFooditems(this.fooditems);
		foodtruck.setLatitude(this.latitude);
		
		foodtruck.setLocation(utils.Utils.getJsonStringFromObject(this.location));
		foodtruck.setLocationdescription(this.locationdescription);
		foodtruck.setLongitude(this.longitude);
		foodtruck.setLot(this.lot);
		foodtruck.setObjectid(this.objectid);
		foodtruck.setPermit(this.permit);
		foodtruck.setPriorpermit(this.priorpermit);
		foodtruck.setReceive(this.received);
		foodtruck.setSchedule(this.schedule);
		foodtruck.setStringstatus(this.status);
		foodtruck.setX(this.x);
		foodtruck.setY(this.y);
		return foodtruck;
		
	}
	  

}
