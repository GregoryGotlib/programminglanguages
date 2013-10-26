/**
 *
 * @author reuben
 */
public class NodeStmtWr extends NodeStmt {
    private NodeExpr expr;

    public NodeStmtWr(NodeExpr expr)
    {
        this.expr = expr;
    }
    
    /**
     * Evaluates the read statement. The read only accepts double values into the variable.
     *
     * @param env - the environment which contains the variables being operated on
     * @return - previous value of variable being read, returns 0 if variable is new
     * @throws EvalException
     */
    @Override
    public Double eval(Environment env) throws EvalException
    {
        System.out.println(expr.eval(env));
        return null;
    }
}