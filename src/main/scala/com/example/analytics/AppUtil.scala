package com.example.analytics

import java.util.{Timer, TimerTask}

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import pureconfig._
import pureconfig.generic.auto._

import scala.io.Source

object AppUtil {

  def configuration: Configuration = {
    val configReader = ConfigSource.default.loadOrThrow[Configuration]
    configReader
  }

  def sparkSession: SparkSession = {
    val sparkConfig = configuration.applicationConfiguration.sparkConfig
    SparkSession.builder().appName(sparkConfig.appName).master(sparkConfig.host).getOrCreate()
  }

  def covidData: String = {
    val source = Source.fromURL(configuration.applicationConfiguration.apiInfo.url)
    new Timer().schedule(new TimerTask {
      override def run(): Unit = source.close()
    }, configuration.applicationConfiguration.apiInfo.sessionClose)
    source.mkString
  }

  def objectMapper: ObjectMapper = {
    val objectMapper: ObjectMapper = new ObjectMapper()
    objectMapper.registerModule(DefaultScalaModule)
    import com.fasterxml.jackson.databind.DeserializationFeature
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    import com.fasterxml.jackson.databind.DeserializationFeature
    objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
    objectMapper
  }
}
