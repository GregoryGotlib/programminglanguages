/**
 * A node for the "fact" terminal of the grammar containing an identifier
 * @author reuben
 */
public class NodeFactId extends NodeFact {

    private String id;

	/**
	 * Constructs a fact containing an id 
	 * @param pos - the position of the scanner/parser when it was found
	 * @param id - the identifier 
	 */
    public NodeFactId(int pos, String id) {
	this.pos=pos;
	this.id=id;
    }

	/**
	 * Evaluates the fact id by getting its position from the environment
	 * @param env - the environment to find the id in 
	 * @return - the id from the environment
	 * @throws EvalException 
	 */
    public int eval(Environment env) throws EvalException {
	return env.get(pos,id);
    }

}
