package edu.umb.cs.cs680.hw11;

/**
 * @author avinashreddy
 *
 */

public class Ls extends Command {
	FileSystem fs;

	public Ls(FileSystem fs) {
		this.fs = fs;
	}

	public void execute() {
		System.out.println("Current directory: " + fs.getCurrent().getName());
		if (fs.getCurrent().getChildren().size() < 1)
			System.out.println("empty directory");
		else
			for (FSElement fse : fs.getCurrent().getChildren()) {
				System.out.println(String.format("%-20s-%s", fse.getName(), fse.getType()));
			}
	}

	@Override
	public void display() {
		System.out.println("ls");
	}

}
