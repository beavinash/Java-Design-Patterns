package edu.umb.cs.cs680.hw11;

import java.util.Date;

/**
 * @author avinashreddy
 *
 */

public class File extends FSElement {

	public File(Directory parent, String name, String owner, Date created,int size) {
		super(parent, FileType.FILE, name, owner, created, size);
		size = 1;
		if(parent !=null)
			parent.childern.add(this);
	}
	
	@Override
	public boolean isFile() {
		return true;
	}
	
	@Override
	public void accept(FSVisitor fsv) {
	    fsv.visit(this);
    }
	
	public int getSizer() {
		return this.size;
	}
	
	@Override
	public void display() {
		System.out.println("FileName:" + this.getName());
	}

}
