package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`

import com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.out.Construction
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ConstructionTest {

    @Test
    fun `deve instanciar com valor nulo por padrao`() {
        // Testa o construtor e o valor padrão
        val construction = Construction()
        assertNull(construction.bussinesCode)
    }

    @Test
    fun `deve instanciar com valor fornecido`() {
        // Testa o construtor com um valor e o getter da propriedade
        val construction = Construction(bussinesCode = 12345L)
        assertEquals(12345L, construction.bussinesCode)
    }

    @Test
    fun `deve ter representacao de string correta`() {
        // Testa o método toString()
        val construction = Construction(bussinesCode = 987L)
        val expectedString = "Construction(bussinesCode=987)"
        assertEquals(expectedString, construction.toString())
    }

    @Test
    fun `deve ser igual e ter o mesmo hashCode para instancias com mesmos valores`() {
        // Testa os métodos equals() e hashCode() para instâncias iguais
        val construction1 = Construction(bussinesCode = 123L)
        val construction2 = Construction(bussinesCode = 123L)

        assertEquals(construction1, construction2)
        assertEquals(construction1.hashCode(), construction2.hashCode())
    }

    @Test
    fun `deve ser diferente e ter hashCode diferente para instancias com valores diferentes`() {
        // Testa os métodos equals() e hashCode() para instâncias diferentes
        val construction1 = Construction(bussinesCode = 123L)
        val construction2 = Construction(bussinesCode = 456L)
        val construction3 = Construction(bussinesCode = null)

        assertNotEquals(construction1, construction2)
        assertNotEquals(construction1.hashCode(), construction2.hashCode())
        assertNotEquals(construction1, construction3)
    }

    @Test
    fun `deve copiar a instancia alterando o valor`() {
        // Testa o método copy()
        val original = Construction(bussinesCode = 100L)
        val copia = original.copy(bussinesCode = 200L)

        assertEquals(100L, original.bussinesCode) // Garante que o original não foi modificado
        assertEquals(200L, copia.bussinesCode)
        assertNotEquals(original, copia)
    }

    @Test
    fun `deve desestruturar a classe corretamente`() {
        // Testa o método component1()
        val construction = Construction(bussinesCode = 777L)
        val (code) = construction // Esta linha chama o método component1()

        assertEquals(777L, code)
    }
}