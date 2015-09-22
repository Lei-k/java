package k.lei.gsf.unit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class UnitGroup {
	
	private Map<Integer, Unit> units;
	
	public UnitGroup(){
		this(new LinkedList<Unit>());
	}
	
	public UnitGroup(List<Unit> unitList){
		units = new HashMap<>();
		for(Iterator<Unit> i = unitList.iterator() ; i.hasNext() ; ){
			Unit unit = i.next();
			units.put(unit.getId(), unit);
		}
	}
	
	public void addUnit(Unit unit){
		units.put(unit.getId(), unit);
	}
	
	public void removeUnit(int id){
		units.remove(id);
	}
	
	public void removeUnit(Unit unit){
		units.remove(unit.getId());
	}
	
	public Object getUnit(int id){
		return units.get(id);
	}
	
	public List<Unit> getUnits(){
		List<Unit> unitList = new LinkedList<>();
		for(Iterator<Entry<Integer, Unit>> i = units.entrySet().iterator() ; i.hasNext() ;){
			Unit unit = (Unit)i.next();
			unitList.add(unit);
		}
		return unitList;
	}
}
