/**
 *
 * @author reuben
 */
public class NodeStmtWhile extends NodeStmt {
    private BoolExpr boolExpr;
    private NodeStmt stmt;

    public NodeStmtWhile(BoolExpr boolExpr, NodeStmt stmt)
    {
        this.boolExpr = boolExpr;
        this.stmt = stmt;
    }
    
    public Double eval(Environment env) throws EvalException
    {
        while (boolExpr.eval(env))
        {
            stmt.eval(env);
        }
        return null;
    }
}
