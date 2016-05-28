package me.guligo.transformtheexpression;

import java.io.*;

/**
 * http://www.spoj.com/problems/ONP
 */
public class Main {

	private static class Node {

		Node left;
		Node right;
		char value;

		Node(Node left, Node right, char op) {
			this.left = left;
			this.right = right;
			this.value = op;
		}

		@Override
		public String toString() {
			return "{left: " + left + ", right: " + right + ", value: " + value + "}";
		}

	}

	private static class Leaf extends Node {

		Leaf(char value) {
			super(null, null, value);
		}

		@Override
		public String toString() {
			return "{value: " + value + "}";
		}
	}

	private static Node getExpTree(String exp) {
		Node left = null, right = null;
		char op;

		int pos = 0, dpt = 0;
		if (exp.charAt(pos) == '(') {
			dpt++;

			int ipos = pos++;
			for (; pos < exp.length(); pos++) {
				if (exp.charAt(pos) == '(') {
					dpt++;
				} else if (exp.charAt(pos) == ')') {
					if (--dpt == 0) {
						left = getExpTree(exp.substring(ipos + 1, pos++));
						if (ipos == 0 && pos == exp.length()) {
							return left;
						}
						break;
					}
				}
			}
		} else {
			left = new Leaf(exp.charAt(pos++));
		}

		op = exp.charAt(pos++);

		if (exp.charAt(pos) == '(') {
			dpt++;

			int ipos = pos++;
			for (; pos < exp.length(); pos++) {
				if (exp.charAt(pos) == '(') {
					dpt++;
				} else if (exp.charAt(pos) == ')') {
					if (--dpt == 0) {
						right = getExpTree(exp.substring(ipos + 1, pos++));
						break;
					}
				}
			}
		} else {
			right = new Leaf(exp.charAt(pos++));
		}

		return new Node(left, right, op);
	}

	private static void traverseExpTree(Node node) {
		if (node != null) {
			traverseExpTree(node.left);
			traverseExpTree(node.right);
			System.out.print(node.value);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());

		String[] e = new String[t];
		for (int i = 0; i < e.length; i++) {
			e[i] = reader.readLine();
		}

		for (int i = 0; i < t; i++) {
			traverseExpTree(getExpTree(e[i]));
			System.out.println();
		}
	}

}
