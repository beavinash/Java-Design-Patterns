package edu.umb.cs.cs680.hw10;

/**
 * @author avinashreddy
 *
 */

import java.util.Date;

enum FileType {
    DIRECTORY,
    LINK,
    FILE
}

public abstract class FSElement {
	
	String name;
	String owner;
	Date created;
	FileType fileType;
	Date lastModified;
	int size;
	Directory parent;
	
	public FSElement(Directory parent, FileType file_type, String name, String owner, Date created, Date lastModified, int size) {
		super();
		this.parent = parent;
		this.name = name;
		this.owner = owner;
		this.created = new Date();
		this.lastModified = this.created;
		this.fileType = file_type;
		this.size = size;
	}
	
	abstract public void accept(FSVisitor fsv);
	
	public int getSize() {
		return size;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
//	public void setName(String name) {
//		this.name = name;
//	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	
	public FileType getType() {
	    return this.fileType;
    }

	/**
	 * @param owner the owner to set
	 */
//	public void setOwner(String owner) {
//		this.owner = owner;
//	}

	/**
	 * @return the created
	 */
//	public Date getCreated() {
//		return created;
//	}

	/**
	 * @param created the created to set
	 */
//	public void setCreated(Date created) {
//		this.created = created;
//	}

	/**
	 * @return the lastModified
	 */
//	public Date getLastModified() {
//		return lastModified;
//	}

	/**
	 * @param lastModified the lastModified to set
	 */
//	public void setLastModified(Date lastModified) {
//		this.lastModified = lastModified;
//	}

	/**
	 * @return the parent
	 */
//	public Directory getParent() {
//		return parent;
//	}

	/**
	 * @param parent the parent to set
	 */
//	public void setParent(Directory parent) {
//		this.parent = parent;
//	}

	/**
	 * @param size the size to set
	 */
//	public void setSize(int size) {
//		this.size = size;
//	}

	public boolean isFile() {
		return true;
	}
	
	public void display() {
		System.out.println("File Name: " + this.getName());
		System.out.println("Owner Name: " + this.getOwner());
	}
	
	
	

}

