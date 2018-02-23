/**
 * 
 */
package edu.umb.cs.cs680.hw10;

import java.util.Random;

/**
 * @author avinashreddy
 *
 */
public class VirusCheckingVisitor implements FSVisitor {
	private int quarantined;
    private Random quarantineRandomizer;

    VirusCheckingVisitor() {
        this.quarantined = 0;
        this.quarantineRandomizer = new Random();
    }

    private boolean hasVirus() {
        return quarantineRandomizer.nextBoolean();
    }
    @Override
    public void visit(File file) {
        if(this.hasVirus()) {
            this.quarantined++;
        }
    }
    
    @Override
    public void visit(Link link) { }
    
    @Override
    public void visit(Directory dir) { }
    public int getQuarantinedNum() {
        return this.quarantined;
    }
}
