package edu.umb.cs.cs680.hw11;

/**
 * @author avinashreddy
 *
 */

public class Rmdir extends Command{
	
	String name;

	public Rmdir(FileSystem fs, String name) {
		this.fs = fs;
		this.name = name;
	}


	public void execute() {
		if (name.isEmpty()){
			System.out.println("invalid mkdir command");
			return;
		}
		Directory current = fs.getCurrent();
		FSElement elm = null;
		for (FSElement fse : current.getChildren()) {
			if(fse.getName().equals(name) && fse.isDir()){
				elm = fse;
			}
		}
		if(elm == null)
			return;
		current.getChildren().remove(elm);
	}


	@Override
	public void display() {
		System.out.println("rmdir "+ name);
	}

}
