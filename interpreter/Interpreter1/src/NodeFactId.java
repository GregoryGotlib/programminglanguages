/**
 * A node for the "fact" terminal of the grammar containing an identifier
 * @author reuben
 */
public class NodeFactId extends NodeFact {

    private String id;
	private NodeUnary unary;

	/**
	 * Constructs a fact containing an id 
	 * @param pos - the position of the scanner/parser when it was found
	 * @param id - the identifier 
	 */
    public NodeFactId(int pos, String id) {
	this.pos=pos;
	this.id=id;
    }

	public NodeFactId(int pos, String id, NodeUnary unary)
	{
		this.pos = pos;
		this.id = id;
		this.unary=unary;
	}

	/**
	 * Evaluates the fact id by getting its position from the environment
	 * @param env - the environment to find the id in 
	 * @return - the id from the environment
	 * @throws EvalException 
	 */
    public double eval(Environment env) throws EvalException {
	return unary == null ? env.get(pos,id) : -1*env.get(pos,id);
    }

}
