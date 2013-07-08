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

public class BufferedReaderLineIterator implements Iterator <String> {
		private final BufferedReader reader;
	  private String next;

	  BufferedReaderLineIterator(BufferedReader reader) {
	    this.reader = reader;
	    updateNext();
	  }

	  private String updateNext() {
	    try {
	      return next;
	    } finally {
	      try {
	        next = reader.readLine();
	      } catch (IOException ex) {
	        throw new IllegalStateException(ex);
	      }
	    }
	  }

	  @Override public boolean hasNext() {
	    return next != null;
	  }

	  @Override public String next() {
	    if (!hasNext()) {
	      throw new NoSuchElementException();
	    }
	    return updateNext();
	  }

	  @Override public void remove() {
	    throw new UnsupportedOperationException(this.getClass() + " does not support remove().");
	  }
}
