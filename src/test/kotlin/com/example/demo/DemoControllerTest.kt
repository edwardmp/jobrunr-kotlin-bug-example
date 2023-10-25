package com.example.demo

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DemoControllerTest(@Autowired private val demoController: DemoController) {

    @Test
    fun enqueueJob() {
        demoController.enqueueJob()
    }
}
