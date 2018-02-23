package edu.umb.cs.cs680.hw11;

import java.util.Date;

/**
 * @author avinashreddy
 *
 */

public class Link extends FSElement {
	
	FSElement target;

	public Link(Directory parent, String name, String owner, Date created, FSElement target) {
		super(parent, FileType.LINK, name, owner, created, 0);
		this.target = target;
		if(parent != null){
			parent.getChildren().add(this);
		}
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
	}

	@Override
	public void accept(FSVisitor fsv) {
		// TODO Auto-generated method stub
		fsv.visit(this);
	}


}
