package k.lei.subway;

public class Station {
	
	private String name;
	
	public Station(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean equals(Object station){
		if(station instanceof Station){
			Station anotherStation = (Station)station;
			return name.equalsIgnoreCase(anotherStation.getName());
		}
		return false;
	}
	
	public int hashCode(){
		return name.toLowerCase().hashCode();
	}
}
