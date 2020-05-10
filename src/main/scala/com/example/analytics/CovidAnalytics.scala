package com.example.analytics

import com.fasterxml.jackson.databind.ObjectMapper

import scala.io.Source

object CovidAnalytics {

  val objectMapper: ObjectMapper = AppUtil.objectMapper
  val configuration: Configuration = AppUtil.configuration
  val covidData: String = AppUtil.covidData

  def main(args: Array[String]): Unit = {

    val data: List[Data] = objectMapper.readValue(covidData, classOf[Array[Data]]).toList

    val filter = data.filter(e => e.regionData.isDefined)
    //This is not working (Confused!!!)
    println(filter.size)
  }
}
