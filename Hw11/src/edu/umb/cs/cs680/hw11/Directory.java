package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author avinashreddy
 *
 */

public class Directory extends FSElement {
	
	List<FSElement> childern;
	
	
	public Directory(Directory parent,String name, String owner, Date created) {
		super(parent, FileType.DIRECTORY, name, owner, created, 0);
		
		childern = new ArrayList<FSElement>();
		if(parent != null)
			parent.appendChild(this);
	}

	public List<FSElement> getChildren(){
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
		this.size = 1;
		for(FSElement f:this.childern) {
			this.size = this.size + f.getSize(); 
		}
		return this.size;
	}
	
	@Override
	public void display() {
		System.out.println("Directory Name:"+this.getName());
		System.out.println("Owner Name:"+this.getOwner());
		for(FSElement f: this.childern) {
			f.display();
		}
	}
	
	public List<FSElement> search(String name){
		List<FSElement> result = new ArrayList<>();
		for (FSElement fsElement : getChildren()) {
			if(fsElement.isDir()){
				result.addAll(((Directory)fsElement).search(name));
			}
			if(fsElement.getName().equals(name))
					result.add(fsElement);
			
		}
		return result;
	}
}
