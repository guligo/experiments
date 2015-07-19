@echo off
set workdir=%cd%

rem Remove possible left-overs

call clean.bat

rem Generate Maven projects

cd generator
call mvn clean package
rem set MAVEN_OPTS=-Xmx4096m -XX:MaxPermSize=1024m

rem 1 project with 3 * 9 = 27 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="flat ../generated stage-1-flat 3 9"
rem 1 project with 5 * 15 = 75 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="flat ../generated stage-2-flat 5 15"
rem 1 project with 10 * 25 = 250 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="flat ../generated stage-3-flat 10 25"
rem 1 project with 10 * 250 = 2500 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="flat ../generated stage-4-flat 10 250"
rem 1 project with 10 * 500 = 5000 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="flat ../generated stage-5-flat 10 500"
rem 1 project, 3 levels - 3 modules per level with 3 classes in each leaf module - 1 * 3 * 3 * 3 = 27 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="tree ../generated stage-1-tree 3 3 3"
rem 1 project, 3 levels - 5 modules per level with 3 classes in each leaf module - 1 * 5 * 5 * 3 = 75 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="tree ../generated stage-2-tree 3 5 3"
rem 1 project, 3 levels - 5 modules per level with 10 classes in each leaf module - 1 * 5 * 5 * 10 = 250 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="tree ../generated stage-3-tree 3 5 10"
rem 1 project, 3 levels - 5 modules per level with 100 classes in each leaf module - 1 * 5 * 5 * 100 = 2500 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="tree ../generated stage-4-tree 3 5 100"
rem 1 project, 3 levels - 5 modules per level with 200 classes in each leaf module - 1 * 5 * 5 * 200 = 5000 classes
call mvn exec:java -Dexec.mainClass=me.guligo.experiments.mavenmodularity.generator.Main -Dexec.args="tree ../generated stage-5-tree 3 5 200"

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
call:buildAndMeasureGeneratedProject stage-5-flat
call:buildAndMeasureGeneratedProject stage-5-tree

rem Return to starting point

cd %workdir%
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
