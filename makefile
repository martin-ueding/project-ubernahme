# puts the binaries and the sources into the jar
pu.jar: sources/projectubernahme/ProjectUbernahme.class sources/projectubernahme/*.java sources/projectubernahme/*/*.java localisation/messages.pot
	jar -cfm pu.jar manifest.txt -C sources projectubernahme

# compiles the game
sources/projectubernahme/ProjectUbernahme.class: sources/projectubernahme/*.java sources/projectubernahme/*/*.java
	javac -sourcepath sources/ sources/projectubernahme/ProjectUbernahme.java sources/projectubernahme/*/*.java

# generates javadoc for everything
javadoc:
	javadoc -sourcepath sources/ sources/projectubernahme/*.java -d documentation/javadoc -private -subpackages projectubernahme

# deletes all the compiled or otherwise generated content
.PHONY: clean
clean:
	rm -rf sources/projectubernahme/*.class sources/projectubernahme/*/*.class *.jar documentation/javadoc

# generates the main .pot file
localisation/messages.pot: sources/projectubernahme/*.java
	xgettext -kLocalizer.get -o localisation/messages.pot sources/projectubernahme/*.java sources/projectubernahme/*/*.java

