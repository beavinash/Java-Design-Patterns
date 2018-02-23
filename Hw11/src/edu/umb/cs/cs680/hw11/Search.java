package edu.umb.cs.cs680.hw11;

/**
 * @author avinashreddy
 *
 */

import java.util.List;

public class Search extends Command{
	
	String name;
	
	public Search(FileSystem fs, String name) {
		this.fs = fs;
		this.name = name;
	}

	@Override
	public void execute() {
		List<FSElement> result = fs.getCurrent().search(name);
		if(result.size() < 1){
			System.out.println("no such dir/file found");
		}else{
			System.out.println("Search result:");
			for (FSElement fse : result) {
				System.out.println(String.format("%-20s-%s", fse.getName(), fse.getType()));
			}
		}
	}

	@Override
	public void display() {
		System.out.println("search " + name);
	}
	
}
