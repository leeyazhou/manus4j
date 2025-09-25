# manus4j Makefile

.PHONY: all build test clean format publish

all: build

build:
	./mvnw clean package

test:
	./mvnw test

clean:
	./mvnw clean

format:
	./mvnw spotless:apply

publish:
	./mvnw deploy -Prelease -DskipTests
