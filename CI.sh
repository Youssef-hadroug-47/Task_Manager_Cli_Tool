#!/bin/bash
./gradlew build
./gradlew fatJar
sudo cp ./taskm /usr/bin/
