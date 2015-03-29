package me.guligo.experiments.mavenprojgen;

import java.io.IOException;

import me.guligo.experiments.mavenprojgen.utils.CommonsUtil;
import me.guligo.tools.gentool.format.GenTool;

/**
 * Generates flat Maven project, based on values provided in constants.
 * 
 * @author guligo
 */
public class MavenFlatProjectGenerator {

	private final static String PROJECT_DIR = "tmp";
	private final static String PROJECT_NAME = "maven-proj-flat";
	private final static int PROJECT_CLASS_COUNT = 25;

	public static void main(String[] args) throws IOException {
		MavenFlatProjectGenerator projectGenerator = new MavenFlatProjectGenerator();
		projectGenerator.generateMavenProject(PROJECT_DIR, PROJECT_NAME, PROJECT_CLASS_COUNT);
	}

	public void generateMavenProject(String projectDir, String projectName, int moduleCount) throws IOException {
		generatePom(PROJECT_DIR, projectName);
		generateCommons(PROJECT_DIR, projectName);
		for (int i = 0; i < moduleCount; i++) {
			generateClasses(PROJECT_DIR, projectName, CommonsUtil.getLetter(i));
		}
	}

	private void generatePom(String projectDir, String rootParamValue) throws IOException {
		GenTool genTool = new GenTool("gen/flat/pom-xml.gen", projectDir);
		genTool.setParameter("root", rootParamValue);
		genTool.process();
	}

	private void generateCommons(String projectDir, String rootParamValue) throws IOException {
		GenTool genTool = new GenTool("gen/flat/commons.gen", projectDir);
		genTool.setParameter("root", rootParamValue);
		genTool.process();
	}

	private void generateClasses(String projectDir, String rootParamValue, String tagParamValue) throws IOException {
		GenTool genTool = new GenTool("gen/classes.gen", projectDir);
		genTool.setParameter("root", rootParamValue);
		genTool.setParameter("tag", tagParamValue);
		genTool.process();
	}

}
