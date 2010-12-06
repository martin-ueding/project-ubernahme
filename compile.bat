@echo off
echo compile the java files ...
javac ProjectUbernahme.java
echo.
echo packing everything into a jar ...
jar -cfm pu.jar manifest.txt *.class gfx sfx
pause

