package edu.umb.cs.cs680.hw11;

/**
 * @author avinashreddy
 *
 */

public class Pwd extends Command {
	
	public Pwd(FileSystem fs) {
		this.fs = fs;
	}

	public void execute() {
		System.out.println("Current directory: " + fs.getCurrent().getName());
	}

	@Override
	public void display() {	
		System.out.println("pwd");
	}
}
