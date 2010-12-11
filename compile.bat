@echo off
echo compile the java files ...
javac projectubernahme/ProjectUbernahme.java
echo.
echo packing everything into a jar ...
jar -cfm pu.jar manifest.txt projectubernahme
pause

