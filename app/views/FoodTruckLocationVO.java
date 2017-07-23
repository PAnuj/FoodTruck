package views;


public class FoodTruckLocationVO {
	
    String type; // "Point",
    Double[] coordinates; //: [
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double[] getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Double[] coordinates) {
		this.coordinates = coordinates;
	}
	
}
