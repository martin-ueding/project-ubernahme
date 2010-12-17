@echo off
echo deleting all the old stuff ...
del *.class /S
echo compile the java files ...
javac projectubernahme/ProjectUbernahme.java
echo.
echo packing everything into a jar ...
jar -cfm pu.jar manifest.txt projectubernahme
pause

