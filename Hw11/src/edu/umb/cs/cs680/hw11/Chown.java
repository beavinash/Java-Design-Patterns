package edu.umb.cs.cs680.hw11;

/**
 * @author avinashreddy
 *
 */

public class Chown extends Command{

	public String owner;
	FileSystem fs;

	public Chown(FileSystem fs, String owner) {
		this.fs = fs;
		this.owner = owner;
	}

	public void execute() {
		fs.getCurrent().setOwner(owner);
	}

	@Override
	public void display() {
	}

}
