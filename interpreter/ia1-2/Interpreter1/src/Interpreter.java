
/**
 * The driver class for running the interpreter on an input program
 * @author buff
 */
public class Interpreter
{

	/**
	 * The driver function
	 * @param args - the source program broken up 
	 */
	public static void main(String[] args)
	{
		Parser parser = new Parser();
		Environment env = new Environment();
		for (String stmt : args)
		{
			try
			{
				Node node = parser.parse(stmt);
				System.out.print(node == null ? "" : node.eval(env) + "\n");
			}
			catch (SyntaxException e)
			{
				System.err.println(e);
			}
			catch (EvalException e)
			{
				System.err.println(e);
			}
		}
	}
}
