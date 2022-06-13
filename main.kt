import java.util.Scanner
import java.util.LinkedList

var programas : LinkedList<Pair<String, String>> = LinkedList()
var interpretes : LinkedList<Pair<String, String>> = LinkedList()
var traductores : LinkedList<Triple<String, String, String>> = LinkedList()
var lenguajes : LinkedList<String> = LinkedList()
var nombres : LinkedList<String> = LinkedList()

/**
 * Función que dados los lenguajes de entrada y salida de un traductor o itérprete,
 * determina si se pueden agregar uno o más lenguajes al conjunto de lenguajes 
 * que la máquina puede entender (a partir del uso de otros traductores o intérpretes
 * previamente definidos), y si se puede, los agrega.
 * Argumentos:
 * lan1 (String): Lenguaje de entrada del intérprete o traductor.
 * lan2 (String): Lenguaje de salida del intérprete o traductor.
 * lan3 (String): En caso de ser un traductor, es el lenguaje en donde está escrito el mismo.
 * Autor: Gabriela Panqueva 06/2022.
 */
fun agregaLenguaje(lan1: String, lan2: String, lan3: String = "") {

    if (lenguajes.contains(lan2)) {
        if (lan3 == "" || ((lan3 != "") && lenguajes.contains(lan3))) {
            lenguajes.add(lan1)
        }
    } else { return }
    for (i in 0 until maxOf(interpretes.size, traductores.size)) {
        if (i < interpretes.size) {
            if (interpretes[i].second == lan1 && !(lenguajes.contains(interpretes[i].first)) ) {
                agregaLenguaje(interpretes[i].first, interpretes[i].second)
            }
        }
        if (i < traductores.size) {
            if ((lenguajes.contains(traductores[i].second) && traductores[i].third == lan1) || (lenguajes.contains(traductores[i].third) && traductores[i].second == lan1)) {
                if (!(lenguajes.contains(traductores[i].first))) {
                    agregaLenguaje(traductores[i].first, traductores[i].second, traductores[i].third)
                }
                
            }
        }
    }

}

/**
 * Función que define un nuevo programa en la máquina y lo almacena dependiendo
 * de su categoría, y si es intérprete o traductor, determina si es posible 
 * añadir lenguajes al conjunto de lenguajes que la máquina puede ejecutar.
 * Argumentos: 
 * instrucción (Array<String>): Es un arreglo que contiene las palabras que
 * conforman la instrucción o acción, de la cual se sacarán los datos de los
 * programas. 
 * Autor: Gabriela Panqueva 06/2022.
 */
fun definir(instruccion: List<String>){

    when (instruccion[1]) {
        "PROGRAMA" -> {
            if (nombres.contains(instruccion[2])) {
                println("Error al definir ${instruccion[2]}, ya existe el nombre asociado a un programa.")
            } else {
                programas.add(Pair(instruccion[2], instruccion[3]))
                nombres.add(instruccion[2])
                println("Definición exitosa de ${instruccion[2]}, ejecutable en ${instruccion[3]}.")
            }
        }
        "INTERPRETE" -> {
            interpretes.add(Pair(instruccion[3], instruccion[2]))
            agregaLenguaje(instruccion[3], instruccion[2])
            println("Definición exitosa del intérprete para ${instruccion[3]}, escrito en ${instruccion[2]}.")
        }
        "INTÉRPRETE" -> {
            interpretes.add(Pair(instruccion[3], instruccion[2]))
            agregaLenguaje(instruccion[3], instruccion[2])
            println("Definición exitosa del intérprete para ${instruccion[3]}, escrito en ${instruccion[2]}.")
        }
        "TRADUCTOR" -> {
            traductores.add(Triple(instruccion[3], instruccion[2], instruccion[4]))
            agregaLenguaje(instruccion[3], instruccion[2], instruccion[4])
            println("Definición exitosa del traductor de ${instruccion[3]} a ${instruccion[4]}, escrito en ${instruccion[2]}.")
        }
    }

}

/**
 * Función principal, le pide repetidamente al usuario una acción para ejecutar.
 */
fun main() {
    lenguajes.add("LOCAL")
    val lector = Scanner(System.`in`)
    var linea : String
    var palabras : List<String> 
    
    println("Bienvenido al simulador de Diagramas de T :). Recuerde las  acciones: DEFINIR, EJECUTABLE y SALIR.")
    while (true) {
        print("$>")
        linea = lector.nextLine()
        palabras = linea.split(" ")
        when (palabras[0]) {
            "DEFINIR" -> definir(palabras)
            "EJECUTABLE" -> {
                var c = false
                var programa : Pair<String, String> = Pair("", "")
                for (i in programas) {
                    if (i.first == palabras[1]) {
                        c = true
                        programa = i
                        break
                    }
                }
                if (c) {
                    if (lenguajes.contains(programa.second)) {
                        println("El programa asociado al nombre ${palabras[1]} se puede ejecutar.")
                    } else { println("El programa asociado al nombre ${palabras[1]} no se puede ejecutar.") }
                } else {
                    println("Error, el nombre ${palabras[1]} no tiene un programa asociado.")
                }
            }
            "SALIR" -> break
            else -> { println("Error, la acción intorucida es equivocada, por favor intente nuevamente.") }
        }
    }
}