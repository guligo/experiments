package me.guligo.experiments.mavenmodularity.generator;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import me.guligo.tools.gentool.format.GenTool;

/**
 * Generates Maven project with tree structure.
 * 
 * @author guligo
 */
public class MavenTreeProjectGenerator {

	public void generateProject(String projectDir, String projectName, int level, int modulesPerLevel, int classesPerModule) throws IOException {
		System.out.println("Generating " + projectName + " project");
		
		generateCommons(projectDir, projectName);
		generateProject(projectDir, level, projectName, "", modulesPerLevel, classesPerModule);
		
		System.out.println("Generation of " + projectName + " project completed!");
	}

	private void generateProject(String projectDir, int level, String path, String name, int modulesPerLevel, int classesPerModule) throws IOException {
		if (level > 0) {
			List<String> newNames = new ArrayList<String>();
			for (int i = 0; i < modulesPerLevel; i++) {
				newNames.add(name + (char) ('A' + i));
			}

			if (level == 1) {
				generateLeafPom(projectDir, path, name);
				generateClasses(projectDir, path, name, classesPerModule);
			} else {
				if (name.isEmpty()) {
					newNames.add("commons");
					generateNodePom(projectDir, path, "dummy", newNames);
					newNames.remove("commons");
				} else {
					generateNodePom(projectDir, path, name, newNames);
				}
			}

			for (String newName : newNames) {
				generateProject(projectDir, level - 1, path + "/" + newName, newName, modulesPerLevel, classesPerModule);
			}
		}
	}

	private void generateCommons(String projectDir, String rootParamValue) throws IOException {
		GenTool genTool = new GenTool(Paths.get("gen/tree/commons.gen"), Paths.get(projectDir));
		genTool.setParameter("root", rootParamValue);
		genTool.process();
	}

	private void generateClasses(String projectDir, String rootParamValue, String tagParamValue, int classesPerModule) throws IOException {
		for (int i = 0; i < classesPerModule; i++) {
			GenTool genTool = new GenTool(Paths.get("gen/classes.gen"), Paths.get(projectDir));
			genTool.setParameter("root", rootParamValue);
			genTool.setParameter("tag", tagParamValue);
			genTool.setParameter("index", String.valueOf(i));
			genTool.process();
		}
	}

	private void generateNodePom(String projectDir, String rootParamValue, String tagParamValue, List<String> modules) throws IOException {
		StringBuilder sb = new StringBuilder();
		for (String module : modules) {
			sb.append("<module>" + module + "</module>");
		}

		GenTool genTool = new GenTool(Paths.get("gen/tree/pom-xml-node.gen"), Paths.get(projectDir));
		genTool.setParameter("root", rootParamValue);
		genTool.setParameter("tag", tagParamValue);
		genTool.setParameter("modules", sb.toString());
		genTool.process();
	}

	private void generateLeafPom(String projectDir, String rootParamValue, String tagParamValue) throws IOException {
		GenTool genTool = new GenTool(Paths.get("gen/tree/pom-xml-leaf.gen"), Paths.get(projectDir));
		genTool.setParameter("root", rootParamValue);
		genTool.setParameter("tag", tagParamValue);
		genTool.process();
	}

}
