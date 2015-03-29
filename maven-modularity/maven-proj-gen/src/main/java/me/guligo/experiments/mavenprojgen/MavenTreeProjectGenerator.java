package me.guligo.experiments.mavenprojgen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.guligo.tools.gentool.format.GenTool;

public class MavenTreeProjectGenerator {

	private final static int LEVELS = 3;
	private final static int MODULES_PER_LEVEL = 5;

	public static void main(String[] args) throws IOException {
		MavenTreeProjectGenerator projectGenerator = new MavenTreeProjectGenerator();
		projectGenerator.generateProject("dummy_tree", LEVELS, MODULES_PER_LEVEL);
	}

	public void generateProject(String projectName, int level, int modulesPerLevel) throws IOException {
		generateCommons("tmp", projectName);
		generateProject("tmp", level, projectName, "", modulesPerLevel);
	}

	private void generateProject(String projectDir, int level, String path, String name, int modulesPerLevel) throws IOException {
		if (level > 0) {
			List<String> newNames = new ArrayList<String>();
			for (int i = 0; i < modulesPerLevel; i++) {
				newNames.add(name + (char) ('A' + i));
			}

			if (level == 1) {
				generateLeafPom(projectDir, path, name);
				generateClasses(projectDir, path, name);
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
				generateProject(projectDir, level - 1, path + "/" + newName, newName, modulesPerLevel);
			}
		}
	}

	private void generateCommons(String projectDir, String rootParamValue) throws IOException {
		GenTool genTool = new GenTool("gen/tree/commons.gen", projectDir);
		genTool.setParameter("root", rootParamValue);
		genTool.process();
	}

	private void generateClasses(String projectDir, String rootParamValue, String tagParamValue) throws IOException {
		GenTool genTool = new GenTool("gen/classes.gen", projectDir);
		genTool.setParameter("root", rootParamValue);
		genTool.setParameter("tag", tagParamValue);
		genTool.process();
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
