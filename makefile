pu.jar: ProjectUbernahme.class *.java
	jar -cfm pu.jar manifest.txt *.class gfx sfx

ProjectUbernahme.class: *.java
	echo "public class Revno { public static int revno() { return " > Revno.java
	bzr revno >> Revno.java
	echo "; } } " >> Revno.java
	javac ProjectUbernahme.java

javadoc:
	javadoc *.java -d javadoc -private

.PHONY: clean
clean:
	rm -rf *.class *.jar javadoc Revno.java
