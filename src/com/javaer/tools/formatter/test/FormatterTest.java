package com.javaer.tools.formatter.test;

import com.javaer.tools.common.Formatter;

public class FormatterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "<ul><li>sub1</li><li>sub中文2<ul><li>sub21</li></ul></li></ul>";
		try {
			String prettyHtml = Formatter.htmlFormatter(input);
			System.out.println(prettyHtml);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
