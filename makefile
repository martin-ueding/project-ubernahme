# path to the main sourced
p = sources/projectubernahme

# puts the binaries and the sources into the jar
pu.jar: $(p)/ProjectUbernahme.class $(p)/*.java $(p)/*/*.java localisation/messages.pot
	jar -cfm pu.jar manifest.txt -C sources projectubernahme

# compiles the game
$(p)/ProjectUbernahme.class: $(p)/*.java $(p)/*/*.java $(p)/*.properties
	javac -sourcepath sources/ $(p)/ProjectUbernahme.java $(p)/*/*.java

# generates javadoc for everything
javadoc:
	javadoc -sourcepath sources/ $(p)/*.java -d documentation/javadoc -private -subpackages projectubernahme

# deletes all the compiled or otherwise generated content
.PHONY: clean
clean:
	rm -rf $(p)/*.class $(p)/*/*.class *.jar documentation/javadoc

# generates the main .pot file
localisation/messages.pot: $(p)/*.java
	xgettext -kLocalizer.get -o localisation/messages.pot $(p)/*.java $(p)/*/*.java
	msgcat --properties-output -o $(p)/strings_de.properties de.po
	msgcat --properties-output -o $(p)/strings_tr.properties tr.po


