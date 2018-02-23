/**
 * 
 */
package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;

/**
 * @author avinashreddy
 *
 */
public class FileSearchVisitor implements FSVisitor {
	private String extension;
    private ArrayList<File> foundFiles;

    FileSearchVisitor(String extension) {
        this.extension = extension;
        foundFiles = new ArrayList<File>();
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(this.extension))
            this.foundFiles.add(file);
    }
    @Override
    public void visit(Link link) { }
    @Override
    public void visit(Directory dir) { }
    
    public ArrayList<File> getFoundFiles() {
        return this.foundFiles;
    }
}
