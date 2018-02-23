package edu.umb.cs.cs680.hw11;

/**
 * @author avinashreddy
 *
 */

import java.util.Date;

enum FileType {
	DIRECTORY, LINK, FILE;
	@Override
	public String toString() {
		switch (this) {
		case DIRECTORY:
			return "directory";
		case LINK:
			return "link";
		case FILE:
			return "file";
		}
		return super.toString();
	}
}

public abstract class FSElement implements Comparable<FSElement> {

	protected String name;
	protected String owner;
	protected Date created;
	protected FileType fileType;
	protected Date lastModified;
	protected int size;
	protected Directory parent;

	public FSElement(Directory parent, FileType file_type, String name, String owner, Date created, int size) {
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
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

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
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created
	 *            the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the lastModified
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified
	 *            the lastModified to set
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * @return the parent
	 */
	public Directory getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(Directory parent) {
		this.parent = parent;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	public boolean isFile() {
		return this instanceof File;
	}

	public boolean isDir() {
		return this instanceof Directory;
	}

	public boolean isLink() {
		return this instanceof Link;
	}

	public void display() {

	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		FSElement fe = (FSElement) obj;
		return name.equals(fe.name);
	}

	@Override
	public int compareTo(FSElement o) {
		return name.compareTo(o.name);
	}

}
