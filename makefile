# puts the binaries and the sources into the jar
pu.jar: projectubernahme/ProjectUbernahme.class projectubernahme/*.java
	jar -cfm pu.jar manifest.txt projectubernahme

# compiles the game
projectubernahme/ProjectUbernahme.class: projectubernahme/*.java
	javac projectubernahme/ProjectUbernahme.java

# generates javadoc for everything
javadoc:
	javadoc projectubernahme/*.java -d documentation/javadoc -private -subpackages projectubernahme

# deletes all the compiled or otherwise generated content
.PHONY: clean
clean:
	rm -rf projectubernahme/*.class projectubernahme/*/*.class *.jar documentation/javadoc

