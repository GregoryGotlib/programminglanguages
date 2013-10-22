
/**
 * A node for storing assignments that are found in statements
 * @author buff
 */
public class NodeAssn extends Node
{

	private String id;
	private NodeExpr expr;

	public NodeAssn(String id, NodeExpr expr)
	{
		this.id = id;
		this.expr = expr;
	}

	/**
	 * Evaluates the given assignment
	 * @param env - the environment which contains the variables being operated on
	 * @return - perhaps some kind of id from the environment
	 * @throws EvalException 
	 */
	public double eval(Environment env) throws EvalException
	{
		return env.put(id, expr.eval(env));
	}
}
