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
	
	@Override
	public int eval(Environment env) throws EvalException
	{
		return Integer.parseInt(sign == null ? digit : sign+digit);
	}
}
