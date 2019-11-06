package com.datastructure.exercice;

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
				// TODO
			}

			if (next == ')' || next == ']' || next == '}') {
				// TODO
			}
		}
		
		// TODO : something if the stack is not empty 
		
		throw new ParseException("Check for balanced bracket failed at char "
				+ 0 + " in string [" + text + "]",
				0);
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
