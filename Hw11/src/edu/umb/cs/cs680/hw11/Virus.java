package edu.umb.cs.cs680.hw11;

/**
 * @author avinashreddy
 *
 */

public class Virus extends Command{
	public Virus(FileSystem fs) {
		this.fs = fs;
	}
	
	@Override
	public void execute() {
		VirusCheckingVisitor visitor = new VirusCheckingVisitor();
		for (FSElement fse : fs.getCurrent().getChildren()) {
			if(fse.isFile())
				visitor.visit((File) fse);
		}
		System.out.println("Quarantined: " + visitor.getQuarantinedNum());
	}
	
	@Override
	public void display() {
		System.out.println("virus");
	}
}
