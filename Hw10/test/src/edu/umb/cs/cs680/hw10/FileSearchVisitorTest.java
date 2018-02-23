/**
 * 
 */
package edu.umb.cs.cs680.hw10;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

/**
 * @author avinashreddy
 *
 */
public class FileSearchVisitorTest {

	@Test
	public void test() {
		Date date = new Date();

		FileSystem file = FileSystem.getFileSystem();
		
		Directory root = new Directory(null, "root", "Avi",date);
		Directory home = new Directory(root, "Home", "Avi", date);
		Directory pictures = new Directory(root, "Picture", "Avi", date);
		Directory system = new Directory(file.root, "system", "Avi", date);


		root.appendChild(home);
		root.appendChild(system);
		root.appendChild(pictures);

		File a = new File(system, "a", "Avinash", date, 1);
		File b = new File(system, "b", "Avinash", date, 1);
		File c = new File(system, "c", "Avinash", date, 1);
		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);

		//home = new Directory(file.root, "home", "Avi", date);
		File d = new File(home, "d", "Avi", date, 1);
		Link x = new Link(home, "x", "Avi", date,date,0,system);
		home.appendChild(d);
		home.appendChild(x);

		//pictures = new Directory(home, "pictures", "Avi", date);
		File e = new File(pictures, "e", "Avin", date, 1);
		File f = new File(pictures, "f", "Avin", date, 1);
		Link y = new Link(home, "y", "Avin", date,date,0,system);
		pictures.appendChild(e);
		pictures.appendChild(f);
		pictures.appendChild(y);


		file.setRoot(root);
		file.showAllElements();
		

		FileSearchVisitor visitor = new FileSearchVisitor(".txt");
		file.root.accept(visitor);
		visitor.getFoundFiles().size();


		assertEquals(6,file.getRoot().getSize());
	}

}
