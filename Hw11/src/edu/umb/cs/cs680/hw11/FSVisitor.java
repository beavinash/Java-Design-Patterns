/**
 * 
 */
package edu.umb.cs.cs680.hw11;

/**
 * @author avinashreddy
 *
 */
public interface FSVisitor {
	public void visit(Link link);
	public void visit(Directory dir);
	public void visit(File file);
}