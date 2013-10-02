/**
 *
 * @author reuben
 */
public class NodeUnary extends Node
{
	private String unaryMinus;

	public NodeUnary(String unaryMinus)
	{
		this.unaryMinus = unaryMinus;
	}

	@Override
	public double eval(Environment env) throws EvalException
	{
		return env.put(unaryMinus, pos);
	}
}
