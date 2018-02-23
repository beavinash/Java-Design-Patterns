package edu.umb.cs.cs680.hw11;

/**
 * @author avinashreddy
 *
 */

public class Count extends Command{
	public Count(FileSystem fs) {
		this.fs = fs;
	}
	@Override
	public void execute() {
		System.out.println("Count :" + fs.getCurrent().getChildren().size());
	}
	
	@Override
	public void display() {
		System.out.println("count");
	}
}
