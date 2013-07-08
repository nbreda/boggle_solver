import java.util.ArrayList;
import java.util.Collection;


public class board {

	public Collection<Vertex> items;
	public ArrayList<String> allWords;
	
	
	
	public board(){
		String[][] grid = { { "C", "A", "T", "X", }, 
                {"X", "B", "C", "H", },
                {"X", "X", "X", "Y",},
                {"D", "O", "G","G",}};

		allWords = new ArrayList<String>();
		
		Vertex[][] boardg = new Vertex[4][4];
	    items = new ArrayList<Vertex>(16);
	    for (int i = 0; i < grid.length; i++) {
	      for (int j = 0; j < grid[i].length; j++) {
	        boardg[i][j] = new Vertex(grid[i][j]);
	        items.add(boardg[i][j]);
	      }
	    }
	    
	    for (int i = 0; i < boardg.length; i++) {
	      for (int j = 0; j < boardg[i].length; j++) {
	        if (i > 0)
	          boardg[i][j].addNeighbor(boardg[i-1][j]);
	        if (i < boardg.length-1)
	          boardg[i][j].addNeighbor(boardg[i+1][j]);
	        if (j > 0)
	          boardg[i][j].addNeighbor(boardg[i][j-1]);
	        if (j < boardg[i].length-1)
	          boardg[i][j].addNeighbor(boardg[i][j+1]);
	      }
	    }
	}
	
	
	public ArrayList<String> returnAllWords(){	
		for (Vertex vert: this.items){       
		      dfs(vert, "");
		      }
		
		return allWords;
	}
	
	
	
	private void dfs(Vertex u, String currentWord){
	    String currentLetter = u.visit();
	    currentWord= currentWord + currentLetter;
	     allWords.add(currentWord);
	     u.visited = true;
	     Iterable<Vertex> vertices =u.getVertices();
	     for (Vertex v : vertices){
	       if (v.isVisited() != true){
	         dfs(v,currentWord);
	       }     
	     }
	     u.visited = false;
	   }
	
	public void printWords(){
		for (String word: allWords){
			System.out.println(word);
		}
			
	}
	
	
}
