pu.jar: ProjectUbernahme.class
	jar -cfm pu.jar manifest.txt *.class gfx sfx

ProjectUbernahme.class: ProjectUbernahme.java
	javac ProjectUbernahme.java

javadoc:
	javadoc *.java -d javadoc

.PHONY: clean
clean:
	rm -rf *.class *.jar javadoc
