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

public class playgame {
	static final Dictionary dictionary = BoggleDictionaryFromWordList.fromDefault();
	  public static void main(String[] argv) {
	    
		 board thisBoard = new board();
		 ArrayList<String> allPossibleCombinations = thisBoard.returnAllWords();
		 for (String word:allPossibleCombinations){
			 if (dictionary.isWord(word)){
				 System.out.println(word);	 
			 }
		 }
		  
	    
	  }    
	     
	  
}
