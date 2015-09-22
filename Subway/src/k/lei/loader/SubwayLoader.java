package k.lei.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import k.lei.subway.Subway;

public class SubwayLoader {
	
	private Subway subway;
	
	public SubwayLoader(){
		this.subway = new Subway();
	}
	
	public Subway loadFromFile(File subwayFile) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(subwayFile));
		
		loadStations(subway, reader);
		String lineName = reader.readLine();
		while((lineName != null) && (lineName.length() > 0)){
			loadLine(subway, reader, lineName);
			lineName = reader.readLine();
		}
		return subway;
	}
	
	private void loadStations(Subway subway, BufferedReader reader)
	    throws IOException{
		String currentLine = reader.readLine();
		while(currentLine.length() > 0){
			subway.addStation(currentLine);
			currentLine = reader.readLine();
		}
	}
	
	private void loadLine(Subway subway, BufferedReader reader, String lineName)
	    throws IOException{
		String station1Name = reader.readLine();
		String station2Name = reader.readLine();
		while((station2Name != null) && (station2Name.length() > 0)){
			subway.addConnection(lineName, station1Name, station2Name);
			station1Name = station2Name;
			station2Name = reader.readLine();
		}
	}
}
