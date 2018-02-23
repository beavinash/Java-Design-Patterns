package edu.umb.cs.cs680.hw10;

/**
 * @author avinashreddy
 *
 */

public class FileSystem {
	
	private static FileSystem fsinstance = null;
	public Directory root;
	
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

}
