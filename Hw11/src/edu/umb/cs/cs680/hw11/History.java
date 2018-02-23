package edu.umb.cs.cs680.hw11;

/**
 * @author avinashreddy
 *
 */

public class History extends Command{
	CommandHistory histroy;

	public History(CommandHistory history) {
		this.histroy = history;
	}

	@Override
	public void execute() {
		histroy.print();
	}

	@Override
	public void display() {
		System.out.println("history");		
	}

}
