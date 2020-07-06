#!/bin/bash

javac -d ./class-files ./source-files/*.java
cd class-files
date
java -cp .:mysql-connector-java-8.0.19.jar HomePage
