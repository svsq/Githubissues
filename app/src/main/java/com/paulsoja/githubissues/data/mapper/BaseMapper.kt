package com.paulsoja.githubissues.data.mapper

import java.util.*

abstract class BaseMapper<From, To> {

  abstract fun map(from: From): To

  fun map(froms: List<From>): List<To> {
    return ArrayList<To>(froms.size).apply {
      froms.forEach {
        add(map(it))
      }
    }
  }
}