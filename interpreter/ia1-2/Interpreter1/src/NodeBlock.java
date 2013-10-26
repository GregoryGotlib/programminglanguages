
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author reuben
 */
class NodeBlock extends Node {
    List<NodeStmt> statements = new LinkedList<NodeStmt>();
    
    public NodeBlock(List<NodeStmt> statements)
    {
        this.statements = statements;
    }
    public NodeBlock()
    {
    }
    
    public void addStatement(NodeStmt statement)
    {
        statements.add(statement);
    }
    
    /**
     * Evaluates the contained assignment
     * @param env - the environment which contains the variables being operated on
     * @return - perhaps some kind of id from the environment
     * @throws EvalException 
     */
    public Double eval(Environment env) throws EvalException
    {
        for (NodeStmt nodeStmt : statements)
        {
            nodeStmt.eval(env);
        }
        return null;
    }
}
