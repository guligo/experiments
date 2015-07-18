package me.guligo.experiments.mavenmodularity.generator;

import java.io.IOException;

/**
 * Main runnable class.
 * 
 * @author guligo
 */
public class Main {
	
	private final static String FLAT = "flat";
	private final static String TREE = "tree";
	
	public static void main(String[] args) throws IOException {
		if (FLAT.equals(args[0])) {
			MavenFlatProjectGenerator flatProjectGenerator = new MavenFlatProjectGenerator();
			flatProjectGenerator.generateMavenProject(args[1], args[2], Integer.valueOf(args[3]), Integer.valueOf(args[4]));
		} else if (TREE.equals(args[0])) {
			MavenTreeProjectGenerator treeProjectGenerator = new MavenTreeProjectGenerator();
			treeProjectGenerator.generateProject(args[1], args[2], Integer.valueOf(args[3]), Integer.valueOf(args[4]), Integer.valueOf(args[5]));
		}
	}
	
}
