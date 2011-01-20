# path to the main source
p = projectubernahme

standard: projectubernahme.jar

full: projectubernahme.jar ../localisation/messages.pot $(p)/strings*.properties

# puts the binaries and the sources into the jar
projectubernahme.jar: $(p)/ProjectUbernahme.class $(p)/*.java $(p)/*/*.java
	jar -cfm projectubernahme.jar manifest.txt projectubernahme

# compiles the game
$(p)/ProjectUbernahme.class: $(p)/*.java $(p)/*/*.java
	javac $(p)/ProjectUbernahme.java $(p)/*/*.java

# generates javadoc for everything
javadoc:
	javadoc $(p)/*.java -d ../documentation/javadoc -private -subpackages projectubernahme

# deletes all the compiled or otherwise generated content
.PHONY: clean
clean:
	rm -rf $(p)/*.class $(p)/*/*.class *.jar ../documentation/javadoc

# generates the main .pot file
../localisation/messages.pot: $(p)/*.java
	xgettext -kLocalizer.get -o ../localisation/messages.pot $(p)/*.java $(p)/*/*.java

# converts the translated .po files to .properties files that Java can use then
$(p)/strings*.properties: ../localisation/*.po
	msgcat --properties-output -o $(p)/strings_de.properties ../localisation/de.po
	msgcat --properties-output -o $(p)/strings_tr.properties ../localisation/tr.po

