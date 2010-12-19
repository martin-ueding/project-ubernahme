@echo off
echo deleting all the old stuff ...
del *.class /S
echo compile the java files ...
javac -sourcepath sources/ sources/projectubernahme/ProjectUbernahme.java
echo.
echo packing everything into a jar ...
jar -cfm pu.jar manifest.txt -C sources projectubernahme
pause

