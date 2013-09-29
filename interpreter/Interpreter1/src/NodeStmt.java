
/**
 * A node containing the stmt terminal of the grammar, statements contain assignments.
 * @author buff
 */
public class NodeStmt extends Node
{

	private NodeAssn assn;

	/**
	 * Constructs a statement node with the given assignment
	 * @param assn 
	 */
	public NodeStmt(NodeAssn assn)
	{
		this.assn = assn;
	}

	/**
	 * Evaluates the contained assignment
	 * @param env - the environment which contains the variables being operated on
	 * @return - perhaps some kind of id from the environment
	 * @throws EvalException 
	 */
	public int eval(Environment env) throws EvalException
	{
		return assn.eval(env);
	}
}
