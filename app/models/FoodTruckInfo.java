package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;

import views.FoodTruckLocationVO;

@Entity
public class FoodTruckInfo extends Model {
	  @Id
	  Long id;
	  String address; 
	  String applicant;  
	  String block; 
	  String blocklot; 
	  String cnn;  
	  String expirationdate;  
	  String facilitytype; 
	  String fooditems; 
	  String latitude; 
	  String location;
	  String locationdescription; 
	  String longitude; 
	  String lot;  
	  String objectid; 
	  String permit; 
	  String priorpermit; 
	  String receive; 
	  String schedule; 
	  String Stringstatus; 
	  String x;
	  String y; 
	  
	  
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getReceive() {
		return receive;
	}
	public void setReceive(String receive) {
		this.receive = receive;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getStringstatus() {
		return Stringstatus;
	}
	public void setStringstatus(String stringstatus) {
		Stringstatus = stringstatus;
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
	
	public static Finder<Long, FoodTruckInfo> find = new Finder<Long,FoodTruckInfo>(FoodTruckInfo.class);
	  
	  
	
}
