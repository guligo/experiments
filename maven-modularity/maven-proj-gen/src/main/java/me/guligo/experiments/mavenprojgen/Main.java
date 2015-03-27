package me.guligo.experiments.mavenprojgen;

import java.io.IOException;

import me.guligo.tools.gentool.format.GenTool;

public class Main {

	private final static int LEVELS = 4;
	private final static int MODULES_PER_LEVEL = 4;

	public static void main(String[] args) throws IOException {
		doMagic(LEVELS, MODULES_PER_LEVEL);
	}

	public static void doMagic(int level, int modulesPerLevel) throws IOException {
		generateCommons("dummy");
		doMagic(level, "dummy", "", modulesPerLevel);
	}

	public static void doMagic(int level, String path, String name, int modulesPerLevel) throws IOException {
		if (level > 0) {
			if (level == 1) {
				generateClasses(path, name);
			}

			int o = 0;
			if (level == LEVELS) {
				o = 1;
			}
			String[] newNames = new String[modulesPerLevel + o];
			for (int i = 0; i < modulesPerLevel; i++) {
				newNames[i] = name + (char) ('A' + i);
			}
			if (level == LEVELS) {
				newNames[modulesPerLevel + o - 1] = "commons";
			}

			if (name.isEmpty()) {
				genertePom(path, "dummy", "pom", newNames);
			} else {
				if (level != 1) {
					genertePom(path, name, "pom", newNames);
				} else {
					genertePom(path, name, "jar", null);
				}
			}

			for (String newName : newNames) {
				if (!"commons".equals(newName)) {
					doMagic(level - 1, path + "/" + newName, newName, modulesPerLevel);
				}
			}
		}
	}

	public static void generateCommons(String root) throws IOException {
		GenTool genTool = new GenTool("gen/tree/commons.gen", "tmp");
		genTool.setParameter("root", root);
		genTool.process();
	}

	public static void generateClasses(String root, String tag) throws IOException {
		GenTool genTool = new GenTool("gen/tree/classes.gen", "tmp");
		genTool.setParameter("root", root);
		genTool.setParameter("tag", tag);
		genTool.process();
	}

	public static void genertePom(String root, String tag, String packaging, String[] modules) throws IOException {
		GenTool genTool = new GenTool(modules == null ? "gen/tree/pom-xml-leaf.gen" : "gen/tree/pom-xml-node.gen", "tmp");
		genTool.setParameter("root", root);
		genTool.setParameter("tag", tag);
		genTool.setParameter("packaging", packaging);

		if (modules != null) {
			String moduleList = "";
			for (String module : modules) {
				moduleList += "<module>" + module + "</module>";
			}
			genTool.setParameter("modules", moduleList);
		}

		genTool.process();
	}

}
