package edu.umb.cs.cs680.hw11;

/**
 * @author avinashreddy
 *
 */

import java.util.Collections;

public class Sort extends Command {

	public Sort(FileSystem fs) {
		this.fs = fs;
	}

	@Override
	public void execute() {
		Collections.sort(fs.getCurrent().getChildren());
	}

	@Override
	public void display() {
		System.out.println("sort");
	}

}
