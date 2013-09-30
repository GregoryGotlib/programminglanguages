
/**
 * A "fact" terminal containing a number
 * @author buff
 */
public class NodeFactNum extends NodeFact
{

	private NodeNum num;

//	/**
//	 * A "fact" terminal containing a number with no sign
//	 * @param num - the integer to create the terminal with
//	 */
//	public NodeFactNum(String num)
//	{
//		this.num = new NodeNum(num, null);
//	}
//
//	/**
//	 * A "fact" terminal containing a number with a sign
//	 * @param num - the integer to create the terminal with
//	 * @param sign - the sign of the integer
//	 */
//	public NodeFactNum(String num, String sign)
//	{
//		this.num = new NodeNum(num, sign);
//	}
	public NodeFactNum(NodeNum num)
	{
		this.num = num;
	}	
	

	/**
	 * Evaluates the fact number by obtaining its integer value
	 * @param env - the environment being
	 * @return
	 * @throws EvalException 
	 */
	public double eval(Environment env) throws EvalException
	{
		return num.eval(env);
	}
}
