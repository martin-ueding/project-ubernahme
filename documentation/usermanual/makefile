# Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

markdowns = $(wildcard */*.markdown)
htmls = $(markdowns:.markdown=.html)

all: $(htmls)

%.html: %.markdown
	markdown $< > $@

.PHONY: clean
clean:
	$(RM) *.class *.jar
	$(RM) *.o *.out
	$(RM) *.pyc
	$(RM) *.orig

