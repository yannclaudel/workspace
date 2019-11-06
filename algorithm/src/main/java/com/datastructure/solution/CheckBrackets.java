package com.datastructure.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Stack;

import com.datastructure.solution.Bracket;

public class CheckBrackets {
	/**
	 * 
	 * @param text
	 * @throws ParseException
	 */
	public static void checkBracket(String text) throws ParseException {

		Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();

		for (int position = 0; position < text.length(); ++position) {
			char next = text.charAt(position);

			if (next == '(' || next == '[' || next == '{') {
				opening_brackets_stack.push(new Bracket(next, position));
			}

			if (next == ')' || next == ']' || next == '}') {
				if (opening_brackets_stack.isEmpty()) {
					throw new ParseException(
							"Check for balanced bracket failed at char " + position + " in string [" + text + "]",
							position);
				} else {
					Bracket top = opening_brackets_stack.pop();
					if (!top.Match(next)) {
						throw new ParseException(
								"Check for balanced bracket failed at char " + position + " in string [" + text + "]",
								position);
					}
				}
			}
		}
		if (!opening_brackets_stack.isEmpty())
			throw new ParseException("Check for balanced bracket failed at char "
					+ opening_brackets_stack.peek().getPosition() + " in string [" + text + "]",
					opening_brackets_stack.peek().getPosition());
	}

	public static void main(String[] args) throws IOException, ParseException {
		InputStreamReader input_stream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input_stream);
		String text = reader.readLine();
		try {
			checkBracket(text);
			System.out.println("Check for balanced bracket is successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
