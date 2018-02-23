package edu.umb.cs.cs680.hw09;

import java.util.Date;

/**
 * @author avinashreddy
 *
 */

public class Link extends FSElement {
	
	FSElement target;

	public Link(Directory parent, String name, String owner, Date created, Date lastModified, int size, FSElement target) {
		super(parent, name, owner, created, lastModified, size);
		this.target = target;
	}
	
	@Override
	public boolean isFile() {
		return true;
	}
	
	public int getTaregetSizer() {
		return this.target.size;
	}
	
	@Override
	public void display() {
		System.out.println("LinkName:" + this.getName());
		System.out.println("owner:" + this.getOwner());
		System.out.println("PointTo:" + this.target.getName());
		System.out.println("Link Size: " + this.getTaregetSizer());
	}

}
