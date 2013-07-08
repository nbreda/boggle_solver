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

public class BoggleDictionaryFromWordList implements Dictionary {
	  private final NavigableSet<String> words;

	  private BoggleDictionaryFromWordList(NavigableSet<String> words) {
	    this.words = words;
	  }

	  @Override public boolean isWord(String s) {
	    return words.contains(s);
	  }

	  public static BoggleDictionaryFromWordList fromDefault() {
	    return fromFile(new File("/usr/share/dict/words"));
	  } 

	  public static BoggleDictionaryFromWordList fromFile(final File file) {
	    return fromWords(new Iterable<String>() { 
	      @Override public Iterator<String> iterator() {
	        try {
	          return new BufferedReaderLineIterator(new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8")));
	        } catch (IOException ex) {
	          throw new RuntimeException(ex);
	        }
	      }
	    });
	  } 

	  public static BoggleDictionaryFromWordList fromWords(Iterable<String> iterable) {
	    NavigableSet<String> words = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
	    for (String s : iterable) {
	      if (!Character.isUpperCase(s.charAt(0))) {
	        words.add(s);
	      }
	    }
	    return new BoggleDictionaryFromWordList(words);
	  }
	}
