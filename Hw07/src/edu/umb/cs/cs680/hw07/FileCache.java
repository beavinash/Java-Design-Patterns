/**
 * 
 */
package edu.umb.cs.cs680.hw07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * @author avinashreddy
 *
 */
public class FileCache {
	
	private LinkedHashMap <String, String> cache = new LinkedHashMap<String, String>();
	private static CacheReplacementPolicy replacementPolicy;
	private static FileCache instance = null;
	/**
	 * 
	 */
	public static FileCache getInstance() {
		// TODO Auto-generated constructor stub
		if(instance==null) {
			instance = new FileCache();
			replacementPolicy = new NullReplacement();
		}
		return instance;
	}
	
	public String fetch(String targetFile) {
		
		StringBuffer b= new StringBuffer();
        
            BufferedReader br = null;
            FileReader fr = null;
            
            try {
                fr = new FileReader(targetFile);
                br = new BufferedReader(fr);
                
                String sCurrentLine;
                
                while ((sCurrentLine = br.readLine()) != null) {
                    b.append(sCurrentLine);
                }
                
                
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
        
		if(cache.containsKey(targetFile)) {
			return cache.get(targetFile);
		}else {
            if(cache.size()<3) {
                cache.put(targetFile, b.toString());
            }
			else {
				replace(targetFile);
			}
		}
	
		return b.toString();
	}

	private void replace(String targetFile) {
		if(replacementPolicy != null)
		    replacementPolicy.replace(this.cache, targetFile);
	}
	
	public void changePolicy(CacheReplacementPolicy replacementPolicy) {
		this.replacementPolicy = replacementPolicy;
		
	}
	
	public LinkedHashMap <String, String>  getCache(){
		return this.cache;
	}

}
