pu.jar: ProjectUbernahme.class
	jar -cfm pu.jar manifest.txt *.class gfx sfx

ProjectUbernahme.class: ProjectUbernahme.java
	javac ProjectUbernahme.java

.PHONY: clean
clean:
	rm -rf *.class *.jar
