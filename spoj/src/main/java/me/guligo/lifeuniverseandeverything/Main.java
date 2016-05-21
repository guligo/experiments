package me.guligo.lifeuniverseandeverything;

import java.io.*;

/**
 * http://www.spoj.com/problems/TEST
 */
class Main {

	public static void main (String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int number;
		while ((number = Integer.parseInt(reader.readLine())) != 42) {
			System.out.println(number);
		}
	}

}
