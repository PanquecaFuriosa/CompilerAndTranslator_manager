KC=	kotlinc
KFLAGS= -include-runtime
PROG= DiagramasT.jar
SRC= main.kt

all :
	$(KC) $(SRC) $(KFLAGS) -d $(PROG)

. PHONY : clean

clean:
	rm -rf DiagramasT.jar