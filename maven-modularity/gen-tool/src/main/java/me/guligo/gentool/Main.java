package me.guligo.gentool;

import java.io.IOException;

import me.guligo.gentool.format.GenTool;

/**
 * Main runnable class of the tool.
 * 
 * @author guligo
 */
public class Main {

	public static void main(String[] args) throws IOException {
		GenTool genFileProcessor = new GenTool(args[0], args[1]);
		for (int i = 2; i < args.length; i++) {
			genFileProcessor.setParameter(args[i++], args[i]);
		}
		genFileProcessor.process();
	}

}
