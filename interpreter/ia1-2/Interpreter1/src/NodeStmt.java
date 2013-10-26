/**
 *
 * @author reuben
 */
public class NodeStmt extends Node{
    private boolean terminated;
    
    public void setTerminated(boolean terminated)
    {
        this.terminated = terminated;
    }
        
    public boolean isTerminated()
    {
        return terminated;
    }
}
