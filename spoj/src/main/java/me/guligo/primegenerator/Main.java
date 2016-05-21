package me.guligo.primegenerator;

import java.io.*;

/**
 * http://www.spoj.com/problems/PRIME1
 */
class Main {

	static final long MAX = 1000000000;
	static final int FIRST_PRIME = 2;

	private static boolean isPrime(long n) {
		long m = (long) Math.sqrt(n);
		for (long i = FIRST_PRIME; i <= m; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("unused")
	private static int getNumberOfPrimes(long n) {
		int r = 0;
		for (int i = FIRST_PRIME; i < (int) Math.sqrt(MAX); i++) {
			if (isPrime(i)) {
				r++;
			}
		}
		return r;
	}

	public static int[] getPrimes(long n) {
		int[] r = new int[3401]; // getNumberOfPrimes(MAX) returns 3401;
		for (int i = FIRST_PRIME, j = 0; i < (int) Math.sqrt(MAX); i++) {
			if (isPrime(i)) {
				r[j] = i;
				j++;
			}
		}
		return r;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());

		int[] ps = getPrimes(MAX);
		for (int i = 0; i < t; i++) {
			String[] s = reader.readLine().split("\\s+");
			long m = Long.parseLong(s[0]);
			long n = Long.parseLong(s[1]);

			for (long j = m; j <= n; j++) {
				boolean print = true;

				for (int p : ps) {
					if (p > n) {
						break;
					} else if (j < FIRST_PRIME || (j != p && j % p == 0)) {
						print = false;
						break;
					}
				}

				if (print) {
					System.out.println(j);
				}
			}
			System.out.println();
		}
	}

}
