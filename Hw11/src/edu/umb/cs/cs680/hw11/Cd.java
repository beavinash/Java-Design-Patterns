package edu.umb.cs.cs680.hw11;

/**
 * @author avinashreddy
 *
 */

public class Cd extends Command {

	public Cd(FileSystem fs) {
		this.fs = fs;
	}

	public void execute() {
		if (path.equals("")) {
			fs.setCurrent(fs.getRoot());
		} else if (path.equals("..")) {
			Directory target = fs.getCurrent().parent;
			if (target != null)
				fs.setCurrent(target);
		} else {
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
					if (fse.getName().equals(fileElementsNames.get(i)) && fse.isDir()) {
						elm = fse;
					}
				}
				if (elm == null) {
					System.out.println("\"" + path + "\" no such directory");
					return;
				}
				current = (Directory) elm;
			}
			fs.setCurrent(current);
		}
	}

	@Override
	public void display() {
		System.out.println("cd "+ path);
	}
}
