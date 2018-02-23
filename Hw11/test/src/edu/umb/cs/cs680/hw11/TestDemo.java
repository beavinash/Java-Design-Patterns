/**
 * 
 */
package edu.umb.cs.cs680.hw11;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;


import org.junit.Before;
import org.junit.Test;

import edu.umb.cs.cs680.hw11.Cd;
import edu.umb.cs.cs680.hw11.Chown;
import edu.umb.cs.cs680.hw11.CommandHistory;
import edu.umb.cs.cs680.hw11.CountingVisitor;
import edu.umb.cs.cs680.hw11.Directory;
import edu.umb.cs.cs680.hw11.File;
import edu.umb.cs.cs680.hw11.FileSystem;
import edu.umb.cs.cs680.hw11.Link;
import edu.umb.cs.cs680.hw11.Ln;
import edu.umb.cs.cs680.hw11.Mkdir;
import edu.umb.cs.cs680.hw11.Rmdir;
import edu.umb.cs.cs680.hw11.Shell;

import java.util.Date;

/**
 * @author avinashreddy
 *
 */
public class TestDemo {

		private FileSystem fs;
		private CommandHistory history;
		private String path;
		private Shell shell;
		@Before
		public void CommandTest()
		{
			fs = FileSystem.getFileSystem();
			Date date = new Date();
			fs.setRoot(new Directory(null, "/", "CS680", date));
			fs.setCurrent(fs.getRoot());
			fileDirectoryExecution(date);
			history = new CommandHistory();
			this.path = "/home/pictures";
			this.shell = new Shell();
		}

		private void fileDirectoryExecution(Date date) {
			Directory sys = new Directory(fs.getRoot(), "system", "Avi", date);
			File a = new File(sys, "a", "Avi", date, 1);
			File b = new File(sys, "b", "Avi", date, 1);
			File c = new File(sys, "c", "Avi", date, 1);
			Directory home = new Directory(fs.getRoot(), "home", "Avi", date);
			File d = new File(home, "d", "Avi", date, 1);
			Link x = new Link(home, "x", "Avi", date, sys);
			x.getTaregetSizer();
			Directory pictures = new Directory(home, "pictures", "Avi", date);
			File e = new File(pictures, "e", "Avi", date, 1);
			File f = new File(pictures, "f", "Avi", date, 1);
			Link y = new Link(pictures, "y", "Avi", date, e);
		}
		
		@Test
		public void testCdExecute() {
			Cd cd;
			cd = new Cd(fs);
			cd.path=this.path;
			codeExecution(cd);
			assertThat(fs.getCurrent().getName(), is("pictures"));
		}

		private void codeExecution(Cd cd) {
			cd.fileElementsNames = shell.parse(cd.path,"/");
			
			cd.execute();
			
			this.history.push(cd);
		}
		
		
		@Test
		public void testCdExecute2() {
			Cd cd;
			cd = new Cd(fs);
			cd.path=this.path;
			codeExecution2(cd);
			assertThat(fs.getCurrent().getName(), is("pictures"));
		}

		private void codeExecution2(Cd cd) {
			cd.fileElementsNames = shell.parse(cd.path,"/");
			
			cd.execute();
			
			this.history.push(cd);
			this.history.pop();
			this.history.push(cd);
			this.history.print();
		}
		
		@Test
		public void testMkdirExecute() {
			int c;
			c = fs.getChildren().size();
			Mkdir mkdir;
			codeMkdirExecution();
			assertThat(fs.getChildren().size(), is(c+1));
		}

		private void codeMkdirExecution() {
			Mkdir mkdir;
			mkdir = new Mkdir(fs,"test1");
			mkdir.execute();
			this.history.push(mkdir);
			
			mkdir.display();
		}
		
		@Test
		public void testCdRootExecute() {
			Cd cd = new Cd(fs);
			cd.path="";
			codeExecution(cd);
			assertThat(fs.getCurrent().getName(), is("/"));
		}
		
		
		
		@Test
		public void testRmdirExecute() {
			int c;
			c = fs.getChildren().size();
			codeRmdirExecution();
			assertThat(fs.getChildren().size(), is(c-1));
		}

		private void codeRmdirExecution() {
			Rmdir rmdir;
			rmdir = new Rmdir(fs,"home");
			rmdir.execute();
			this.history.push(rmdir);
			rmdir.display();
		}
		
		@Test
		public void testVirusExecute() {
			
			Virus v;
			v = new Virus(fs);
			v.display();
			
			
			
		}
		
		@Test
		public void testCountExecute() {
			
			Count c;
			c = new Count(fs);
			c.display();
			
			
			
		}
		
		@Test
		public void testSortExecute() {
			
			Sort c;
			c = new Sort(fs);
			c.display();
			
			
			
			
			
		}
		
		@Test
		public void testPwdExecute() {
			
			Pwd c;
			c = new Pwd(fs);
			c.display();
			
			
			
			
			
		}

		
		
		@Test
		public void testLnExecute() {
			int c;
			c = fs.getChildren().size();
			Ln ln;
			ln = new Ln(fs,"testLink1");
			codeLnExecution(ln);
			assertThat(fs.getChildren().size(), is(c+1));
		}

		private void codeLnExecution(Ln ln) {
			ln.path = "/home";
			ln.fileElementsNames = shell.parse(ln.path,"/");
			ln.execute();
			this.history.push(ln);
			ln.display();
		}
		
		@Test
		public void testChownExecute() {
			Chown chown;
			chown = new Chown(fs,"TTD");
			chown.path = "";
			codeChownExecution(chown);
			assertThat(fs.getCurrent().getOwner(), is("TTD"));
		}

		private void codeChownExecution(Chown chown) {
			chown.fileElementsNames = shell.parse(chown.path,"/");
			chown.execute();
			this.history.push(chown);
			chown.display();
		}
		
		@Test
		public void test() {
			
			
			Date date = new Date();

			FileSystem file = FileSystem.getFileSystem();
			
			
			
			Directory root = new Directory(null, "root", "Avi",date);
			Directory home = new Directory(root, "Home", "Avi", date);
			Directory pictures = new Directory(root, "Picture", "Avi", date);
			Directory system = new Directory(file.root, "system", "Avi", date);

			File a = new File(system, "a", "Avinash", date, 1);
			File b = new File(system, "b", "Avinash", date, 1);
			File c = new File(system, "c", "Avinash", date, 1);

			//home = new Directory(file.root, "home", "Avi", date);
			File d = new File(home, "d", "Avi", date, 1);
			Link x = new Link(home, "x", "Avi", date,system);

			//pictures = new Directory(home, "pictures", "Avi", date);
			File e = new File(pictures, "e", "Avin", date, 1);
			File f = new File(pictures, "f", "Avin", date, 1);
			Link y = new Link(home, "y", "Avin", date,system);


			file.setRoot(root);
			file.showAllElements();
			CountingVisitor visitor = new CountingVisitor();
			file.getRoot().accept(visitor);
			
			visitor.getDirNum();
			visitor.getFileNum();
			visitor.getLinkNum();
			
			System.out.println("Avinash");
			System.out.println(visitor.getDirNum());


			assertEquals(6,file.getRoot().getSize());
		}

}
