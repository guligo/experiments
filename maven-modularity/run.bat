@echo off

rem Remove possible left-overs

del results
rd /S /Q generated

rem Generate Maven projects

cd generator
call mvn clean package

rem 1 project with 3 * 9 = 27 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="flat ../generated stage-1-flat 3 9"
rem 1 project with 5 * 15 = 75 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="flat ../generated stage-2-flat 5 15"
rem 1 project with 10 * 25 = 250 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="flat ../generated stage-3-flat 10 25"
rem 1 project with 10 * 250 = 2500 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="flat ../generated stage-4-flat 10 250"
rem 1 project with 10 * 2500 = 25000 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="flat ../generated stage-5-flat 10 2500"
rem 1 project, 2 levels - 3 modules per level with 9 classes in each leaf module - 1 * 3 * 9 = 27 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="tree ../generated stage-1-tree 2 3 9"
rem 1 project, 2 levels - 5 modules per level with 15 classes in each leaf module - 1 * 5 * 15 = 75 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="tree ../generated stage-2-tree 2 5 15"
rem 1 project, 3 levels - 5 modules per level with 10 classes in each leaf module - 1 * 5 * 5 * 10 = 250 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="tree ../generated stage-3-tree 3 5 10"
rem 1 project, 3 levels - 5 modules per level with 100 classes in each leaf module - 1 * 5 * 5 * 100 = 2500 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="tree ../generated stage-4-tree 3 5 100"
rem 1 project, 3 levels - 5 modules per level with 1000 classes in each leaf module - 1 * 5 * 5 * 1000 = 25000 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="tree ../generated stage-5-tree 3 5 1000"

cd ..
cd generated

rem Build all generated projects one by one

call:buildAndMeasureGeneratedProject stage-1-flat
call:buildAndMeasureGeneratedProject stage-1-tree
call:buildAndMeasureGeneratedProject stage-2-flat
call:buildAndMeasureGeneratedProject stage-2-tree
call:buildAndMeasureGeneratedProject stage-3-flat
call:buildAndMeasureGeneratedProject stage-3-tree
call:buildAndMeasureGeneratedProject stage-4-flat
call:buildAndMeasureGeneratedProject stage-4-tree

rem Return to starting point

cd ..
echo ##########
type results
echo ##########
goto:eof

rem Define some helper functions

:buildAndMeasureGeneratedProject
	echo Building and measuring generated project %~1
	
	cd %~1
	call mvn clean package > result
	echo %~1 >> ..\..\results
	type result | findstr "Total time: .*" >> ..\..\results
	del result
	cd ..
	
	echo Done with project %~1!
goto:eof
