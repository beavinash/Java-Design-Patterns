package edu.umb.cs.cs680.hw11;

/**
 * @author avinashreddy
 *
 */

public class Dir extends Command {
	
	public Dir(FileSystem fs) {
		this.fs = fs;
	}

	public void execute() {
		if (path.equals("")) {
			for (FSElement fse : fs.getCurrent().getChildren()) {
				fse.display();
			}
		} else if (path.equals("..")) {
			for (FSElement fse : fs.getCurrent().getParent().getChildren()) {
				fse.display();
			}
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
			int size = fileElementsNames.size();
			for (; i < size; i++) {
				elm = null;
				for (FSElement fse : current.getChildren()) {
					if (fse.getName().equals(fileElementsNames.get(i)) && (fse.isDir() || i == size - 1)) {
						elm = fse;
					}
				}
				if (elm == null)
					return;
				if (elm.isDir()) {
					for (FSElement fse : ((Directory) elm).getChildren()) {
						fse.display();
					}
				} else {
					elm.display();
				}
			}

		}
	}

	@Override
	public void display() {
		System.out.println("dir "+ path);
	}
}
