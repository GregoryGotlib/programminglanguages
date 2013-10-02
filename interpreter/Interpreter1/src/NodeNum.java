/**
 * @author reuben
 */
public class NodeNum extends Node
{
	private String digit;
	NodeUnary unary;
	
	public NodeNum(String digit)
	{
		this.digit=digit;
	}
	
	public double eval(Environment env) throws EvalException
	{
		return Double.parseDouble(unary == null ? digit : "-"+digit);
	}

	public void setUnary(NodeUnary unary)
	{
		this.unary=unary;
	}
}
