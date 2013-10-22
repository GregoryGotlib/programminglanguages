
/**
 * The workhorse of our interpreter that combines scanned lexemes into the framework of our grammar
 * @author reuben
 */
public class Parser
{

	private Scanner scanner;

	/**
	 * Calls the scanners match function
	 * @param s - the token being matched
	 * @throws SyntaxException 
	 */
	private void match(String s) throws SyntaxException
	{
		scanner.match(new Token(s));
	}

	/**
	 * Returns the current token returned from the scanner
	 */
	private Token curr()
	{
		return scanner.curr();
	}

	/**
	 * Returns the position of the scanner to the parser
	 * @return - the character position of the scanner
	 */
	private int pos()
	{
		return scanner.pos();
	}

	/**
	 * Parses a mulop 
	 * @return - a mulop node
	 * @throws SyntaxException 
	 */
	private NodeMulop parseMulop() throws SyntaxException
	{
		if (curr().equals(new Token("*")))
		{
			match("*");
			return new NodeMulop(pos(), "*");
		}
		if (curr().equals(new Token("/")))
		{
			match("/");
			return new NodeMulop(pos(), "/");
		}
		return null;
	}

	/**
	 * Parses an addop
	 * @return - a addop node
	 * @throws SyntaxException 
	 */
	private NodeAddop parseAddop() throws SyntaxException
	{
		if (curr().equals(new Token("+")))
		{
			match("+");
			return new NodeAddop(pos(), "+");
		}
		if (curr().equals(new Token("-")))
		{
			match("-");
			return new NodeAddop(pos(), "-");
		}
		return null;
	}
	
	/**
	 * Parses any number of consecutive unary + or -
	 * @return a NodeUnary that contains the result one or many unary + or -s
	 * @throws SyntaxException 
	 */
	private NodeUnary parseUnary() throws SyntaxException
	{
		int i = 1;
		while (curr().lex().equals("-") || curr().lex().equals("+"))
		{
			if (curr().lex().equals("-"))
			{
				i*=-1;
				match("-");
			}
			else
			{
				match("+");
			}
				
		}
		return i == -1 ? new NodeUnary("-") : null;
	}
	
	/**
	 * Parses a digit
	 * @return a NodeNum with the parsed digit
	 * @throws SyntaxException 
	 */
	private NodeNum parseDigit() throws SyntaxException
	{
		String lex = curr().lex();
		return new NodeNum(lex);
	}

	/**
	 * Parses the "fact" terminal of the grammar for use in either a term or an expr.
	 * @return - returns a fact id, fact num or fact expr
	 * @throws SyntaxException 
	 */
	private NodeFact parseFact() throws SyntaxException
	{
		NodeUnary unary = parseUnary();
		if (curr().equals(new Token("(")))
		{
			match("(");
			NodeExpr expr = parseExpr();
			match(")");
			return new NodeFactExpr(expr, unary);
		}
		if (curr().equals(new Token("id")))
		{
			Token id = curr();
			match("id");
			NodeFactId factId = new NodeFactId(pos(), id.lex(), unary);
			return factId;
		}
		NodeNum node = parseDigit();
		node.setUnary(unary);
		match("digit");
		return new NodeFactNum(node);
	}

	/**
	 * Parses a term
	 * @return - a term node
	 * @throws SyntaxException 
	 */
	private NodeTerm parseTerm() throws SyntaxException
	{
		NodeFact fact = parseFact();
		NodeMulop mulop = parseMulop();
		if (mulop == null)
		{
			return new NodeTerm(fact, null, null);
		}
		NodeTerm term = parseTerm();
		term.append(new NodeTerm(fact, mulop, null));
		return term;
	}

	/**
	 * Parses an expression
	 * @return - an expression node
	 * @throws SyntaxException 
	 */
	private NodeExpr parseExpr() throws SyntaxException
	{
		NodeTerm term = parseTerm();
		NodeAddop addop = parseAddop();
		if (addop == null)
		{
			return new NodeExpr(term, null, null);
		}
		NodeExpr expr = parseExpr();
		expr.append(new NodeExpr(term, addop, null));
		return expr;
	}

	/**
	 * Parses an assignment 
	 * @return - an assignment node
	 * @throws SyntaxException 
	 */
	private NodeAssn parseAssn() throws SyntaxException
	{
		Token id = curr();
		match("id");
		match("=");
		NodeExpr expr = parseExpr();
		NodeAssn assn = new NodeAssn(id.lex(), expr);
		return assn;
	}

	/**
	 * Parses a statement
	 * @return - a statement node
	 * @throws SyntaxException 
	 */
	private NodeStmt parseStmt() throws SyntaxException
	{
		NodeAssn assn = parseAssn();
		match(";");
		NodeStmt stmt = new NodeStmt(assn);
		return stmt;
	}

	/**
	 * Parses the given input program
	 * @param program - the program to parse
	 * @return - some type of node
	 * @throws SyntaxException 
	 */
	public Node parse(String program) throws SyntaxException
	{
		scanner = new Scanner(program);
		scanner.next();

		return scanner.getNoTokensFound()
				? null
				: parseStmt();
	}
}