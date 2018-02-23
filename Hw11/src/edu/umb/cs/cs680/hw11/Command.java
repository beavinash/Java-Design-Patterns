package edu.umb.cs.cs680.hw11;

/**
 * @author avinashreddy
 *
 */

import java.util.List;

public abstract class Command {
	FileSystem fs;
	String path;
	
	List<String> fileElementsNames;

	public abstract void execute();

	public abstract void display();
}
