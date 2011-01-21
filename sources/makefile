# path to the main source, relative to the makefile
p = projectubernahme

sourceFiles = $(p)/environments/TileEnvironment.java $(p)/simulator/SimulatorThread.java $(p)/simulator/MainSimulator.java $(p)/interface2D/JPanelRepaintTimerTask.java $(p)/interface2D/LifeformSelectionMouseListener.java $(p)/interface2D/LifeformControlKeyListener.java $(p)/interface2D/MapPanListener.java $(p)/interface2D/View2D.java $(p)/interface2D/Interface2D.java $(p)/Localizer.java $(p)/gfx/ConvertedGraphics.java $(p)/gfx/TileDefault.java $(p)/gfx/TileSidewalk.java $(p)/gfx/LifeformZombieGraphics.java $(p)/gfx/LifeformFlyGraphics.java $(p)/gfx/TileCrosswalkHorizontal.java $(p)/gfx/TileCrosswalkVertical.java $(p)/gfx/TileLawn.java $(p)/gfx/LifeformHumanGraphics.java $(p)/gfx/LifeformTreeGraphics.java $(p)/gfx/TileStreet.java $(p)/TakeoverThread.java $(p)/lifeforms/Human.java $(p)/lifeforms/Fly.java $(p)/lifeforms/Zombie.java $(p)/lifeforms/Tree.java $(p)/lifeforms/Lifeform.java $(p)/Player.java $(p)/Vector2D.java $(p)/ProjectUbernahme.java $(p)/IngestionThread.java

standard: projectubernahme.jar

all: ../localisation/messages.pot $(p)/strings_de.properties $(p)/strings_tr.properties projectubernahme.jar

# puts the binaries and the sources into the jar
projectubernahme.jar: $(p)/ProjectUbernahme.class $(sourceFiles)
	jar -cfm projectubernahme.jar manifest.txt projectubernahme

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
	xgettext -kLocalizer.get -o ../localisation/messages.pot $(p)/*.java $(p)/*/*.java

# converts the translated .po files to .properties files that Java can use then
$(p)/strings_de.properties: ../localisation/de.po
	msgcat --properties-output -o $(p)/strings_de.properties ../localisation/de.po

$(p)/strings_tr.properties: ../localisation/tr.po
	msgcat --properties-output -o $(p)/strings_tr.properties ../localisation/tr.po

