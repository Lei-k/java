package k.lei.test;

import java.io.File;
import java.io.IOException;

import k.lei.loader.SubwayLoader;
import k.lei.subway.Connection;
import k.lei.subway.Subway;

public class LoadTester {
	public static void main(String[] args){
		File subwayFile = new File("bin/k/lei/test", "ObjectvilleSubway.txt");
		SubwayLoader loader = new SubwayLoader();
		try {
			Subway subway = loader.loadFromFile(subwayFile);
			searchConnection(subway, "Ajax Rapids", "HTML Heights");
			searchConnection(subway, "Head First Labs", "LSP Lane");
			searchConnection(subway, "UML Walk", "Ajax Rapids");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void searchConnection(Subway subway, String station1Name, String station2Name){
		Connection connection;
		System.out.println("Search for " + station1Name + " to " + station2Name);
		if(subway.hasConnection(station1Name, station2Name)){
			connection = subway.getConnection(station1Name, station2Name);
			System.out.println(connection.getLineName() + " : " + 
			        connection.getStation1().getName() + 
					" to " + connection.getStation2().getName());
		}
	}
}
