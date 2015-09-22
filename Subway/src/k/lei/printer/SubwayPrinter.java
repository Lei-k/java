package k.lei.printer;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

import k.lei.subway.Connection;

public class SubwayPrinter {
	
	private PrintStream out;
	
	public SubwayPrinter(OutputStream out){
		this.out = new PrintStream(out);
	}
	
	public void printDirections(List<Connection> route){
		Iterator<Connection> i = route.iterator();
		Connection current = (Connection)i.next();
		out.println("Start out at " + current.getStation1().getName());
		out.println("Get on the " + current.getLineName() + 
				" heading towards " + current.getStation2().getName());
		do{
			Connection next = (Connection)i.next();
			if(!current.getLineName().equals(next.getLineName())){
				out.println("When you get to " + current.getStation2().getName() + 
						", get of the " + current.getLineName());
				out.println("Switch over to the " + next.getLineName() + 
						", heading towards " + next.getStation2().getName());
			}else{
			    out.println("  Continue past " + current.getStation2().getName());
			}
			current = next;
		}while(i.hasNext());
		out.println("Get off at " + current.getStation2().getName() + 
				" and enjoy yourself!");
	}
}
