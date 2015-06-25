package me.guligo.experiments.mavenprojgen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.guligo.tools.gentool.format.GenTool;

public class MavenTreeProjectGenerator {

	private final static String PROJECT_DIR = "tmp";
	private final static String PROJECT_NAME = "maven-proj-tree-twp";
	private final static int PROJECT_LEVELS = 2;
	private final static int PROJECT_MODULES_PER_LEVEL = 5;
	private final static int PROJECT_CLASSES_PER_MODULE = 5 * 125;

	public static void main(String[] args) throws IOException {
		MavenTreeProjectGenerator projectGenerator = new MavenTreeProjectGenerator();
		projectGenerator.generateProject(PROJECT_DIR, PROJECT_NAME, PROJECT_LEVELS, PROJECT_MODULES_PER_LEVEL, PROJECT_CLASSES_PER_MODULE);
	}

	public void generateProject(String projectDir, String projectName, int level, int modulesPerLevel, int classesPerModule) throws IOException {
		generateCommons(projectDir, projectName);
		generateProject(projectDir, level, projectName, "", modulesPerLevel, classesPerModule);
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
		GenTool genTool = new GenTool("gen/tree/commons.gen", projectDir);
		genTool.setParameter("root", rootParamValue);
		genTool.process();
	}

	private void generateClasses(String projectDir, String rootParamValue, String tagParamValue, int classesPerModule) throws IOException {
		for (int i = 0; i < classesPerModule; i++) {
			GenTool genTool = new GenTool("gen/classes.gen", projectDir);
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

		GenTool genTool = new GenTool("gen/tree/pom-xml-node.gen", projectDir);
		genTool.setParameter("root", rootParamValue);
		genTool.setParameter("tag", tagParamValue);
		genTool.setParameter("modules", sb.toString());
		genTool.process();
	}

	private void generateLeafPom(String projectDir, String rootParamValue, String tagParamValue) throws IOException {
		GenTool genTool = new GenTool("gen/tree/pom-xml-leaf.gen", projectDir);
		genTool.setParameter("root", rootParamValue);
		genTool.setParameter("tag", tagParamValue);
		genTool.process();
	}

}
