package com.guicgon.api_cdh_kotlin.api_cdh_kotlin.adapter.`in`.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@RestController
@RequestMapping("date")
class DateController {

    @GetMapping("get-date")
    fun getDate(): ResponseEntity<Any> {

        val res = LocalDate.now()
        return ResponseEntity.ok().body(res)

    }

    @GetMapping("get-datetime")
    fun getDatetime(): ResponseEntity<Any> {

        val res = LocalDateTime.now()
        return ResponseEntity.ok().body(res)

    }

    @GetMapping("get-date-format")
    fun getDateFormat() : ResponseEntity<Any>{

        val date = LocalDate.now()
        val formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val dt = date.format(formatters)
      //  val parsedDate = LocalDate.parse(dt, formatters)


        return ResponseEntity.ok().body(dt)
    }
    @GetMapping("get-date-plus-days/{days}")
    fun getDateAPlusDays(@PathVariable days: Long): ResponseEntity<Any> {

        val res = LocalDate.now().plusDays(days)
        return ResponseEntity.ok().body(res)

    }

    @GetMapping("get-date-plus")
    fun getDateAPlus(): ResponseEntity<Unit> {

        // Add one year
        println(LocalDateTime.now().plusYears(1))

        // Add one mounth
        println(LocalDateTime.now().plusMonths(1))

        // Add one week
        println(LocalDateTime.now().plusWeeks(1))

        // Add one day
        println(LocalDateTime.now().plusDays(1))

        // Add one hour
        println(LocalDateTime.now().plusHours(1))

        // Add one minute
        println(LocalDateTime.now().plusMinutes(1))

        return ResponseEntity.ok().body(null)

    }



}