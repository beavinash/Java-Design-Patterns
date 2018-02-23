package edu.umb.cs.cs680.hw11;

/**
 * @author avinashreddy
 *
 */

import java.util.Date;

public class Mkdir extends Command {
	String name;

	public Mkdir(FileSystem fs, String name) {
		this.fs = fs;
		this.name = name;
	}

	public void execute() {
		if (name.isEmpty())
			System.out.println("invalid mkdir command");
		else
			new Directory(fs.getCurrent(), name, "", new Date());
	}

	@Override
	public void display() {
		System.out.println("mkdir "+ name);
	}

}
