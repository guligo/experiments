package me.guligo.experiments.mavenmodularity.generator;

import java.io.IOException;
import java.nio.file.Paths;

import me.guligo.experiments.mavenmodularity.generator.utils.CommonsUtil;
import me.guligo.tools.gentool.format.GenTool;

/**
 * Generates Maven project with flat structure.
 * 
 * @author guligo
 */
public class MavenFlatProjectGenerator {

	public void generateMavenProject(String projectDir, String projectName, int classCount1, int classCount2) throws IOException {
		System.out.println("Generating " + projectName + " project");
		
		generatePom(projectDir, projectName);
		generateCommons(projectDir, projectName);
		for (int i = 0; i < classCount1; i++) {
			generateClasses(projectDir, projectName, CommonsUtil.getLetter(i), classCount2);
		}
		
		System.out.println("Generation of " + projectName + " project completed!");
	}

	private void generatePom(String projectDir, String rootParamValue) throws IOException {
		GenTool genTool = new GenTool(Paths.get("gen/flat/pom-xml.gen"), Paths.get(projectDir));
		genTool.setParameter("root", rootParamValue);
		genTool.process();
	}

	private void generateCommons(String projectDir, String rootParamValue) throws IOException {
		GenTool genTool = new GenTool(Paths.get("gen/flat/commons.gen"), Paths.get(projectDir));
		genTool.setParameter("root", rootParamValue);
		genTool.process();
	}

	private void generateClasses(String projectDir, String rootParamValue, String tagParamValue, int classCount2) throws IOException {
		for (int i = 0; i < classCount2; i++) {
			GenTool genTool = new GenTool(Paths.get("gen/classes.gen"), Paths.get(projectDir));
			genTool.setParameter("root", rootParamValue);
			genTool.setParameter("tag", tagParamValue);
			genTool.setParameter("index", String.valueOf(i));
			genTool.process();
		}
	}

}
