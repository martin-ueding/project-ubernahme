# path to the main source, relative to the makefile
p = projectubernahme
version = 0.4

sourceFiles = $(shell find . | egrep "\.java$$")
classesFiles = $(shell find . | egrep "\.class$$")
propertiesFiles = $(shell find . | egrep "\.properties$$")
textFiles = $(shell find . | egrep "\.txt$$")

standard: projectubernahme.jar

all: ../localisation/messages.pot $(p)/strings_de.properties $(p)/strings_tr.properties projectubernahme.jar linecount

# puts the binaries into the jar
projectubernahme.jar: $(p)/ProjectUbernahme.class $(sourceFiles)
	jar -cfm projectubernahme.jar manifest.txt $(classesFiles) $(propertiesFiles) $(textFiles)

# compiles the game
$(p)/ProjectUbernahme.class: $(sourceFiles)
	javac $(p)/ProjectUbernahme.java $(p)/*/*.java

# generates javadoc for everything
javadoc: $(sourceFiles)
	javadoc $(p)/*.java -d ../documentation/javadoc -private -subpackages projectubernahme

# deletes all the compiled or otherwise generated content
.PHONY: clean
clean:
	rm -rf $(p)/*.class $(p)/*/*.class *.jar ../documentation/javadoc

# generates the main .pot file
../localisation/messages.pot: $(sourceFiles)
	xgettext -kLocalizer.get -o ../localisation/messages.pot --from-code=UTF-8 $(sourceFiles)

# converts the translated .po files to .properties files that Java can use then
$(p)/strings_de.properties: ../localisation/de.po
	msgcat --properties-output -o $(p)/strings_de.properties ../localisation/de.po

$(p)/strings_tr.properties: ../localisation/tr.po
	msgcat --properties-output -o $(p)/strings_tr.properties ../localisation/tr.po

.PHONY: linecount
linecount:
	@cat $(sourceFiles) $(propertiesFiles) $(textFiles) | wc

tarball: projectubernahme-$(version).tar.gz

projectName = projectubernahme-$(version)
projectubernahme-$(version).tar.gz: $(sourceFiles) $(propertiesFiles) $(textFiles)
	rm -rf $(projectName)
	mkdir $(projectName)
	bzr export $(projectName) .
	tar -czf $(projectName).tar.gz $(projectName)
	rm -rf $(projectName)

debianPackagingFolder = ../packaging/debian/project-version
deb-src:
	rm -rf $(debianPackagingFolder)/projectubernahme/
	mkdir $(debianPackagingFolder)/projectubernahme/
	bzr export $(debianPackagingFolder)/projectubernahme/ ./projectubernahme
	cp ./makefile $(debianPackagingFolder)/
	cp ./manifest.txt $(debianPackagingFolder)/
	@echo You can now edit the changelog with dch and then run debuild
