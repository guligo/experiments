package me.guligo.experiments.mavenprojgen;

import java.io.IOException;

import me.guligo.tools.gentool.format.GenTool;

public class Main {

	private final static int LEVELS = 4;
	private final static int MODULES_PER_LEVEL = 4;

	public static void main(String[] args) throws IOException {
		// Files.createDirectory(ROOT);
		doMagic(LEVELS, MODULES_PER_LEVEL);
	}

	public static void doMagic(int level, int modulesPerLevel) throws IOException {
		doMagic(level, "dummy", "", modulesPerLevel);
	}

	public static void doMagic(int level, String path, String name, int modulesPerLevel) throws IOException {
		if (level > 0) {
			if (level == 1) {
				generateClasses(path, name);
			}

			String[] newNames = new String[modulesPerLevel];
			for (int i = 0; i < modulesPerLevel; i++) {
				newNames[i] = name + (char) ('A' + i);
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
				doMagic(level - 1, path + "/" + newName, newName, modulesPerLevel);
			}
		}
	}

	public static void generateClasses(String root, String tag) throws IOException {
		GenTool genTool = new GenTool("classes.gen", "tmp");
		genTool.setParameter("root", root);
		genTool.setParameter("tag", tag);
		genTool.process();
	}

	public static void genertePom(String root, String tag, String packaging, String[] modules) throws IOException {
		GenTool genTool = new GenTool(modules == null ? "pom-xml-flat.gen" : "pom-xml-tree.gen", "tmp");
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
