pu.jar: ProjectUbernahme.class *.java
	jar -cfm pu.jar manifest.txt *.class gfx sfx

ProjectUbernahme.class: *.java
	javac ProjectUbernahme.java

javadoc:
	javadoc *.java -d javadoc -private

.PHONY: clean
clean:
	rm -rf *.class *.jar javadoc
