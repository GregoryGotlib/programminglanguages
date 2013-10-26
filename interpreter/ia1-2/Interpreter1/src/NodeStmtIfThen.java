/**
 *
 * @author reuben
 */
public class NodeStmtIfThen extends NodeStmt {
    private BoolExpr bexpr;
    private NodeStmt ifThenStmt;
    
    public NodeStmtIfThen(BoolExpr bexpr, NodeStmt ifThenStmt)
    {
        this.bexpr = bexpr;
        this.ifThenStmt = ifThenStmt;
    }
    
    public Double eval(Environment env) throws EvalException
    {
        if (bexpr.eval(env))
        {
            return ifThenStmt.eval(env);
        }
        return null;
    }
}
