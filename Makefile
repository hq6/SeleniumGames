all: run

run: FirefoxTest.class
	java FirefoxTest

%.class: %.java
	javac $<
