package edu.umb.cs.cs680.hw10;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author avinashreddy
 *
 */

public class Directory extends FSElement {
	
	ArrayList<FSElement> childern;
	
	
	public Directory(Directory parent,String name, String owner, Date created) {
		super(parent, FileType.DIRECTORY, name, owner, created, created, 0);
		
		childern = new ArrayList<FSElement>();
		
	}

	public ArrayList<FSElement> getChildren(){
		return this.childern;
	}
	
	public void appendChild(FSElement newChild) {
		this.childern.add(newChild);
	}
	
	@Override
	public void accept(FSVisitor fsv) {
	    fsv.visit(this);
	    for(FSElement child: this.childern) {
	        child.accept(fsv);
        }
    }
	
	@Override
	public int getSize() {
		this.size = 0;
		for(FSElement fChildren:this.childern) {
			this.size = this.size + fChildren.getSize(); 
		}
		return this.size;
	}
	
	@Override
	public void display() {
		System.out.println("Directory Name:"+this.getName());
		System.out.println("Owner Name:"+this.getOwner());
		for(FSElement fChildren: this.childern) {
			fChildren.display();
		}
	}

}
