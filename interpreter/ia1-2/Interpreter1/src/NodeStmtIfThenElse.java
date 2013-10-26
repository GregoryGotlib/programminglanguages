/**
 *
 * @author reuben
 */
public class NodeStmtIfThenElse extends NodeStmt {
    private BoolExpr bexpr;
    private NodeStmt ifThenStmt;
    private NodeStmt elseStmt;
    
    public NodeStmtIfThenElse(BoolExpr bexpr, NodeStmt ifThenStmt, NodeStmt elseStmt)
    {
        this.bexpr = bexpr;
        this.ifThenStmt = ifThenStmt;
        this.elseStmt = elseStmt;
    }
    
    public Double eval(Environment env) throws EvalException
    {
        if (bexpr.eval(env))
        {
            return ifThenStmt.eval(env);
        } 
        else
        {
            return elseStmt.eval(env);
        }
    }
}
