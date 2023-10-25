package com.example.demo

import org.jobrunr.scheduling.JobScheduler
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import java.util.*

@Controller
class DemoController(
    private val jobScheduler: JobScheduler,
    private val demoClass: DemoClass,
) {
    fun enqueueJob() {
        val obj = DemoObject(firstUuid = UUID.randomUUID(), secondUuid = UUID.randomUUID(), someLong = 0L, someOtherLong = 0L)
        val firstVar = obj.someLong
        val secondVar = obj.someOtherLong
        jobScheduler.enqueue {
            demoClass.myFunc(first = obj.firstUuid, second = obj.secondUuid, third = firstVar, fourth = secondVar)
        }
    }

    @GetMapping("/demo")
    fun getDemo(): String {
        return "Test"
    }
}

@Component
class DemoClass {
    fun myFunc(first: UUID, second: UUID, third: Long, fourth: Long) {
        println("Hello")
    }
}

data class DemoObject(
    val firstUuid: UUID,
    val secondUuid: UUID,
    val someLong: Long,
    val someOtherLong: Long,
)
