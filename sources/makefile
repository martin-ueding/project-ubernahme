# path to the main source, relative to the makefile
p = projectubernahme

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
	@cat $(sourceFiles) | wc
