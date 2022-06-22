package by.mbicycle.coroutineexample

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import org.junit.Test

class KotlinFlowExampleUnitTest {

    /**
     * Пример создания флоу на основе некоторых исходных данных
     */
    @Test
    fun testFlow() = runBlocking {
        //Пример создания флоу из известной заранее последовательности элементов
        val flow: Flow<Int> = flowOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        //Пример создания флоу преобразованием последовательности элементов
        val mappedFlow = (1..10).asFlow()

        println("Printing only even numbers multiplied by 10:")
        flow
            .filter { it % 2 == 0 }
            .map { it * 10 }
            .collect {
                println(it)
            }
            /*
                Вызов терминального метода collect заставляет холодный Flow в данном примере
                испускать данные
             */

        println("Printing only odd numbers:")
        flow
            .filter { it % 2 == 1 }
            .collect {
                println(it)
            }
    }
}
