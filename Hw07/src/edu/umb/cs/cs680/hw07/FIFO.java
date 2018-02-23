/**
 * 
 */
package edu.umb.cs.cs680.hw07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;



/**
 * @author avinashreddy
 *
 */
public class FIFO implements CacheReplacementPolicy {

	public void replace(LinkedHashMap<String, String> cache, String targetFile) {
		// TODO Auto-generated method stub
		Iterator <String>it = cache.keySet().iterator();
		String toRemove = null;
		while(it.hasNext()){
		       toRemove = it.next();
		       break; // remove break if fifo is not working
		}
		cache.remove(toRemove);
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(targetFile);
			br = new BufferedReader(fr);

			String sCurrentLine;
			StringBuffer b= new StringBuffer();
			while ((sCurrentLine = br.readLine()) != null) {
				b.append(sCurrentLine);
			}
			cache.put(targetFile, b.toString());

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}
}
