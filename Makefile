all: run

SOURCES=$(shell ls *.java)
CLASSES=$(SOURCES:.java=.class)

run: $(CLASSES)
	java FirefoxTest

%.class: %.java
	javac $<

clean:
	rm *.class
