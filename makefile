# Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

# path to the main source, relative to the makefile
p = projectubernahme
version = 0.4.1

sourceFiles = $(shell find . | egrep "\.java$$")
classesFiles = $(shell find . | egrep "\.class$$")
propertiesFiles = $(shell find . | egrep "\.properties$$")
textFiles = $(shell find . | egrep "\.txt$$")

standard: projectubernahme.jar

all: localisation/projectubernahme.pot $(p)/strings_de.properties $(p)/strings_tr.properties projectubernahme.jar linecount

# puts the binaries into the jar
projectubernahme.jar: $(p)/ProjectUbernahme.class $(sourceFiles)
	jar -cfm $@ manifest.txt $(classesFiles) $(propertiesFiles) $(textFiles)

# compiles the game
$(p)/ProjectUbernahme.class: $(sourceFiles)
	javac $(p)/ProjectUbernahme.java

# generates javadoc for everything
documentation/javadoc: $(sourceFiles)
	javadoc $(p)/*.java -d $@ -private -subpackages projectubernahme

# deletes all the compiled or otherwise generated content
.PHONY: clean
clean:
	rm -rf $(p)/*.class $(p)/*/*.class *.jar documentation/javadoc

# generates the main .pot file
localisation/projectubernahme.pot: $(sourceFiles)
	xgettext -kLocalizer.get -o $@ --from-code=UTF-8 $^

# converts the translated .po files to .properties files that Java can use then
$(p)/strings_de.properties: localisation/de.po
	msgcat --properties-output -o $@ $^

$(p)/strings_tr.properties: localisation/tr.po
	msgcat --properties-output -o $@ $^

tarball: projectubernahme-$(version).tar.gz

projectName = projectubernahme-$(version)
projectubernahme-$(version).tar.gz: $(sourceFiles) $(propertiesFiles) $(textFiles)
	rm -rf $(projectName)
	mkdir $(projectName)
	bzr export $(projectName) .
	tar -czf $@ $(projectName)
	rm -rf $(projectName)
