package edu.umb.cs.cs680.hw11;

import java.util.Date;

/**
 * @author avinashreddy
 *
 */

public class Ln extends Command {
	
	String name;

	public Ln(FileSystem fs, String name) {
		this.fs = fs;
		this.name = name;
	}

	@Override
	public void execute() {
		if(name.isEmpty() || path.isEmpty()){
			System.out.println("invaid ln command");
			return;
		}
		int i = 0;
		Directory current = null;
		if (path.startsWith("/")) {
			current = fs.getRoot();
			i = 1;
		} else {
			current = fs.getCurrent();
		}
		FSElement elm;
		for (; i < fileElementsNames.size(); i++) {
			elm = null;
			for (FSElement fse : current.getChildren()) {
				if (fse.getName().equals(fileElementsNames.get(i))) {
					elm = fse;
				}
			}
			if (elm == null) {
				System.out.println("\"" + path + "\" no such directory");
				return;
			}
			current = (Directory) elm;
		}
		new Link(fs.getCurrent(), name, "",	 new Date(), current);
	}

	@Override
	public void display() {
		System.out.println("ln "+ path + " " + name);
	}


}
