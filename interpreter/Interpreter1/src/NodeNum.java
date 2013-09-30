/**
 * @author reuben
 */
public class NodeNum extends Node
{
	private String digit;
	private String sign;
	
	public NodeNum(String digit, String sign)
	{
		this.digit=digit;
		this.sign=sign;
	}
	
	public double eval(Environment env) throws EvalException
	{
		return Double.parseDouble(sign == null ? digit : sign+digit);
	}
}
