/**
 * A node for the "fact" terminal of the grammar containing an expression
 * @author reuben
 */
public class NodeFactExpr extends NodeFact {

    private NodeExpr expr;

	/**
	 * Constructs a fact containing an expression
	 * @param expr - the expression contained in the fact (should have been found in parens)
	 */
    public NodeFactExpr(NodeExpr expr) {
	this.expr=expr;
    }

	/**
	 * Evaluates the fact expression in the same way typical expressions are evaluated
	 * @param env - the environment that is being operated on
	 * @return - either the value of the term or the value of whatever may be contained in it: an id, number or expression 
	 * @throws EvalException 
	 */
    public double eval(Environment env) throws EvalException {
	return expr.eval(env);
    }

}
