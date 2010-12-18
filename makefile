pu.jar: projectubernahme/ProjectUbernahme.class projectubernahme/*.java
	jar -cfm pu.jar manifest.txt projectubernahme

projectubernahme/ProjectUbernahme.class: projectubernahme/*.java
	javac projectubernahme/ProjectUbernahme.java

javadoc:
	javadoc projectubernahme/*.java -d documentation/javadoc -private -subpackages projectubernahme

.PHONY: clean
clean:
	rm -rf projectubernahme/*.class projectubernahme/*/*.class *.jar documentation/javadoc
