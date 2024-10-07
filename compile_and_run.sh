#!/bin/bash

javac -d bin src/NodeType.java
javac -d bin -cp bin src/DoublyLinkedList.java
javac -d bin -cp bin src/DoublyLinkedListDriver.java
java -cp bin DoublyLinkedListDriver int-input.txt
