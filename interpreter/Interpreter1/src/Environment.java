/**
 * A stubbed class that will probably store assigned variables and such in the future
 * @author reuben
 */
public class Environment {

	/**
	 * Put a variable into the environment
	 * @param var - the var
	 * @param val - it's value
	 * @return - ?
	 */
    public int put(String var, int val) { return val; }
	/**
	 * Gets a variable from the environment
	 * @param pos - the position of the scanner/parser where the variable should be
	 * @param var - the variable name
	 * @return - probably the variable
	 * @throws EvalException 
	 */
    public int get(int pos, String var) throws EvalException { return 0; }

}
