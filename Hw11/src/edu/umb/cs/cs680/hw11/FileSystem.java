package edu.umb.cs.cs680.hw11;

import java.util.List;

/**
 * @author avinashreddy
 *
 */

public class FileSystem {
	
	private static FileSystem fsinstance = null;
	public Directory root;
	public Directory current;
	
	public static FileSystem getFileSystem() {
		if(fsinstance == null)
			fsinstance = new FileSystem();
		return fsinstance;
	}
	
	private FileSystem() {
		super();
	}
	
	public void showAllElements() {
		this.root.display();
	}

	/**
	 * @return the root
	 */
	public Directory getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(Directory root) {
		this.root = root;
	}

	public Directory getCurrent() {
		return current;
	}

	public void setCurrent(Directory current) {
		this.current = current;
	}

	public List<FSElement> getChildren() {
		// TODO Auto-generated method stub
		return current.getChildren();
	}
	
	

}
