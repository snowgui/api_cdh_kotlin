package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`

import com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.controller.StringController
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks

class StringControllerTest {

    @InjectMocks
    lateinit var stringController: StringController

    @Test
    fun `should completeWithValue 9 chars`() = {

        val expected = "123000000"

        val actual = stringController.completeWithValue(9, "123")

        assertThat


    }
}