package edu.umb.cs.cs680.hw11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author avinashreddy
 *
 */

public class Shell {
	
	private static FileSystem fs;
	private static CommandHistory history;
	private static String path;
	private static Shell shell;

	List<String> parse(String cmd, String delimtor) {
		return Arrays.asList(cmd.split(delimtor));
	}
	
	public static void main(String[] args) throws IOException {
		fs = FileSystem.getFileSystem();
		Date date = new Date();
		fs.setRoot(new Directory(null, "/", "CS680", date));
		fs.setCurrent(fs.getRoot());
		Directory sys = new Directory(fs.getRoot(), "system", "Avi", date);
		File a = new File(sys, "a", "Avi", date, 1);
		File b = new File(sys, "b", "Avi", date, 1);
		File c = new File(sys, "c", "Avi", date, 1);
		Directory home = new Directory(fs.getRoot(), "home", "Avi", date);
		File d = new File(home, "d", "Avi", date, 1);
		Link x = new Link(home, "x", "Avi", date, sys);
		Directory pictures = new Directory(home, "pictures", "Avi", date);
		File e = new File(pictures, "e", "Avi", date, 1);
		File f = new File(pictures, "f", "Avi", date, 1);
		Link y = new Link(pictures, "y", "Avi", date, e);
		history = new CommandHistory();
		shell = new Shell();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] command;
		while (true) {
			System.out.print(">");
			command = br.readLine().split(" ");

			switch (command[0]) {
			case CommandType.PWD:
				Pwd pwd = new Pwd(fs);
				pwd.execute();
				history.push(pwd);
				break;
			case CommandType.CD:
				Cd cd = new Cd(fs);
				cd.path= command.length >= 2 ? command[1] : "";
				cd.fileElementsNames = shell.parse(cd.path,"/");
				cd.execute();
				history.push(cd);
				break;
			case CommandType.LS:
				Ls ls = new Ls(fs);
				ls.execute();
				history.push(ls);
				break;
			case CommandType.LN:
				Ln ln = new Ln(fs,command.length >= 3 ? command[2] : "");
				ln.path= command.length >= 2 ? command[1] : "";
				ln.fileElementsNames = shell.parse(ln.path,"/");
				ln.execute();
				history.push(ln);
				break;
			case CommandType.MKDIR:
				Mkdir mkdir = new Mkdir(fs,command.length >= 2 ? command[1] : "");
				mkdir.execute();
				history.push(mkdir);
				break;
			case CommandType.RMDIR:
				Rmdir rmdir = new Rmdir(fs,command.length >= 2 ? command[1] : "");
				rmdir.execute();
				history.push(rmdir);
				break;
			case CommandType.DIR:
				Dir dir = new Dir(fs);
				dir.path= command.length >= 2 ? command[1] : "";
				dir.fileElementsNames = shell.parse(dir.path,"/");
				dir.execute();
				history.push(dir);
				break;
			case CommandType.CHOWN:
				Chown chown = new Chown(fs,command.length >= 2 ? command[1] : "");
				chown.execute();
				history.push(chown);
				break;
			case CommandType.HISTORY:
				History hs = new History(history);
				hs.execute();
				history.push(hs);
				break;
			case CommandType.REDO:
				Redo redo = new Redo(history);
				redo.execute();
				history.push(redo);
				break;
			case CommandType.SORT:
				Sort sort = new Sort(fs);
				sort.execute();
				history.push(sort);
				break;
			case CommandType.SEARCH:
				Search search = new Search(fs,command.length >= 2 ? command[1] : "");
				search.execute();
				history.push(search);
				break;
			case CommandType.COUNT:
				Count count = new Count(fs);
				count.execute();
				history.push(count);
				break;
			case CommandType.VIRUS:
				Virus virus = new Virus(fs);
				virus.execute();
				history.push(virus);
				break;
			case CommandType.QUIT:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid command");
			}
		}
	}
}
