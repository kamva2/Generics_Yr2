BIN=bin
SRC=src
DOC=doc
JAVAC = javac --release 17
JAVA = java
MAIN_BST = GenericsKbBSTApp
MAIN_ARRAY = GenericsKbArrayApp

.PHONY: all run_bst run_array clean

all:
	$(JAVAC) *.java

run_bst: all
	$(JAVA) $(MAIN_BST)

run_array: all
	$(JAVA) $(MAIN_ARRAY)

clean:
	rm -f *.class

javadoc:
	javadoc -d $(DOC) -cp $(BIN) -sourcepath $(SRC)/*.java
