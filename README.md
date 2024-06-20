# Program to manage compilers and traductors

## Problem:

It is desired that you model and implement, in the language of your choice, a program that simulates programs, interpreters and translators like those seen when studying T diagrams. 
This program must meet the following characteristics:
a. Must be able to handle programs, interpreters and translators. These might be:
  - PROGRAMA <name> <language>
    Represents a program identified by <name> written in <language>.
  - INTERPRETE <base_language> <language>
    Represents an interpreter for <language> written in <base_language>.
  - TRADUCTOR <base_language> <source_language> <target_language>
    Represents a translator, from <source_language> to <target_language>, written in <base_language>.
b. All languages ​​must be alphanumeric strings and do not have to correspond to any existing language.
c. There will be a special name LOCAL that refers to the language that the local machine can interpret.
d. Once the program is started, it will repeatedly ask the user for an action to proceed. Such action can be:
  - DEFINIR <type> [<args>]
    Represents a class definition <type> with <args> (see above for types and arguments that must be supported).
    The program should report an error and ignore the action if <name> already has a program associated with it, in the case of programs.
  - EJECUTABLE <name>
    Represents a query for the possibility of executing the program named <name>.
    Your program should print if it is possible to construct what is requested, using only the definitions made so far.
    The program should report an error and ignore the action if <name> does not have an associated program.
  - SALIR
    Debe salir del simulador.
At the end of each action, the program must ask the user for the next action.
