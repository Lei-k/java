package k.lei.gsf.unit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Unit {
	
	private String type;
	private int id;
	private String name;
	private List<Weapon> weapons;
	private Map<String, Object> properties;
	
	public Unit(int id){
		this.id = id;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
	
	public int getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		    return name;
	}
	
	public void addWeapon(Weapon weapon){
		if(weapons == null){
			weapons = new LinkedList<>();
		}
		weapons.add(weapon);
	}
	
	public List<Weapon> getWeapons(){
		return weapons;
	}
	
	public void setProperty(String property, Object value){
		if(properties == null){
			properties = new HashMap<>();
		}
		properties.put(property, value);
	}
	
	public Object getProperty(String property){
		if(property == null){
			throw new RuntimeException("No properties for this Unit.");
		}
		Object value = properties.get(property);
		if(value != null){
			return value;
		}else{
			return new String("[no values]");
		}
	}
}
