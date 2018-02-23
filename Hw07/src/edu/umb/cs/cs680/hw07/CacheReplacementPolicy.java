/**
 * 
 */
package edu.umb.cs.cs680.hw07;

import java.util.LinkedHashMap;

/**
 * @author avinashreddy
 *
 */
public interface CacheReplacementPolicy {

	public void replace(LinkedHashMap<String, String> cache, String targetFile);
}
