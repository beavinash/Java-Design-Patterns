package edu.umb.cs.cs680.hw11;

/**
 * @author avinashreddy
 *
 */

public class Redo extends Command{
	CommandHistory ch;
	
	public Redo(CommandHistory ch) {
		this.ch = ch;
	}

	@Override
	public void execute() {
		ch.pop().execute();
	}

	@Override
	public void display() {
		System.out.println("redo");
	}

}
