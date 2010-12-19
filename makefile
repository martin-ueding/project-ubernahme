# puts the binaries and the sources into the jar
pu.jar: sources/projectubernahme/ProjectUbernahme.class sources/projectubernahme/*.java
	jar -cfm pu.jar manifest.txt -C sources projectubernahme

# compiles the game
sources/projectubernahme/ProjectUbernahme.class: sources/projectubernahme/*.java
	javac -sourcepath sources/ sources/projectubernahme/ProjectUbernahme.java

# generates javadoc for everything
javadoc:
	javadoc sources/projectubernahme/*.java -d documentation/javadoc -private -subpackages projectubernahme

# deletes all the compiled or otherwise generated content
.PHONY: clean
clean:
	rm -rf sources/projectubernahme/*.class sources/projectubernahme/*/*.class *.jar documentation/javadoc

