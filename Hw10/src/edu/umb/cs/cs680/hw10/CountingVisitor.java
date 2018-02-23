/**
 * 
 */
package edu.umb.cs.cs680.hw10;

/**
 * @author avinashreddy
 *
 */
public class CountingVisitor implements FSVisitor {
	private int fileNum;
    private int linkNum;
    private int dirNum;

    CountingVisitor() {
        this.fileNum = 0;
        this.linkNum = 0;
        this.dirNum = 0;
    }

    @Override
    public void visit(File file) {
        this.fileNum++;
    }
    @Override
    public void visit(Link link) {
        this.linkNum++;
    }
    @Override
    public void visit(Directory dir) {
        this.dirNum++;
    }
    public int getFileNum() {
        return this.fileNum;
    }
    public int getLinkNum() {
        return this.linkNum;
    }
    public int getDirNum() {
        return this.dirNum;
    }
}
