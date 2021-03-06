package com.example.analytics

case class RegionData(region: Option[String], totalInfected: Option[String], recovered: Option[String], deceased: Option[String])

case class Data(activeCases: String, recovered: String, deaths: String, totalCases: String, sourceUrl: String, lastUpdatedAtApify: String, readMe: String, var regionData: Option[List[RegionData]])

case class SparkConfig(host: String, appName: String)

case class APIInfo(url: String, sessionClose: Int)

case class ApplicationConfiguration(sparkConfig: SparkConfig, apiInfo: APIInfo)

case class Configuration(applicationConfiguration: ApplicationConfiguration)
