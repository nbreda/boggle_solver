
// C A T X
// X B C H
// X X X Y
// D O G G

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

public class Vertex {
	private final String item;
	  private final Collection<Vertex> neighbors = new ArrayList<Vertex>();
	  boolean visited;
	  
	  public Iterable<Vertex> getVertices(){
	    return neighbors;
	  }
	  
	  public boolean isVisited(){
	    return visited;
	  }
	  
	  public String visit(){
	    return item;
	  }
	  
	  public Vertex(String item) {
	    this.item = item;
	  }
	  
	  public void addNeighbor(Vertex neighbor) {
	    neighbors.add(neighbor);
	  }
}
