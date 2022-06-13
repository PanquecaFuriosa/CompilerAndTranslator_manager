import kotlin.test.Test
import kotlin.test.assertEquals

class TestDiagramasT {

        @Test
    fun test() {
        definir(listOf("DEFINIR", "PROGRAMA", "fibonacci", "LOCAL"))
        assertEquals(true, nombres.contains("fibonacci") && lenguajes.contains("LOCAL"))

        definir(listOf("DEFINIR", "PROGRAMA", "factorial", "Java"))
        assertEquals(true, nombres.contains("factorial") && !(lenguajes.contains("Java")))

        definir(listOf("DEFINIR", "INTERPRETE", "C", "Java"))
        assertEquals(true, !(lenguajes.contains("C")) && !(lenguajes.contains("Java")))

        definir(listOf("DEFINIR", "TRADUCTOR", "C", "Java", "C"))
        assertEquals(true, !(lenguajes.contains("C")) && !(lenguajes.contains("Java")))

        definir(listOf("DEFINIR", "INTÉRPRETE", "LOCAL", "C"))
        assertEquals(true, lenguajes.contains("C") && lenguajes.contains("Java"))

            definir(listOf("DEFINIR", "PROGRAMA", "factorial", "Java"))
            assertEquals(true, nombres.contains("factorial"))

            definir(listOf("DEFINIR", "TRADUCTOR", "Pascal", "C++", "Pascal"))
            assertEquals(true, !(lenguajes.contains("C++")) && !(lenguajes.contains("Pascal")))

            definir(listOf("DEFINIR", "TRADUCTOR", "C", "Pascal", "C"))
            assertEquals(true, lenguajes.contains("C++") && lenguajes.contains("Pascal"))

    }
}