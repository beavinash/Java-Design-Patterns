package edu.umb.cs.cs680.hw11;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * @author avinashreddy
 *
 */

public class CommandHistory {
	Deque<Command> commands = new ArrayDeque<Command>();
	
	public void push(Command cmd) {
		commands.push(cmd);
	}
	
	public Command pop() {
		return commands.pop();
	}
	
	public void print() {
		for (Iterator<Command> iter = commands.iterator(); iter.hasNext();  ) {
		    iter.next().display();
		}
	}
	
}
