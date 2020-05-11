package com.example.analytics

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.{DataFrame, SparkSession}

object CovidAnalytics {
  val objectMapper: ObjectMapper = AppUtil.objectMapper
  val configuration: Configuration = AppUtil.configuration
  val sparkSession: SparkSession = AppUtil.sparkSession
  val sparkContext: SparkContext = sparkSession.sparkContext
  val covidData: String = AppUtil.covidData

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    Logger.getLogger("akka").setLevel(Level.ERROR)

    val data: List[Data] = objectMapper.readValue(covidData, classOf[Array[Data]]).toList

    val filteredDataWithRegion = data.filter(_.regionData.isDefined)
    val filteredDataWithoutRegion = data.filterNot(_.regionData.isDefined)
    val regionData = filteredDataWithRegion.flatMap(_.regionData.get)

    import sparkSession.implicits._
    val regionDF: DataFrame = sparkContext.parallelize[RegionData](regionData).toDF()
    val newDF = regionDF.na.drop().na.fill(0)
      .withColumn("totalInfected", regionDF("totalInfected").cast(IntegerType))
      .withColumn("recovered", regionDF("recovered").cast(IntegerType))
      .withColumn("deceased", regionDF("deceased").cast(IntegerType))
      .groupBy("region").sum("totalInfected", "recovered", "deceased")
      .sort(asc("region"))

    newDF.printSchema()
    newDF.show(1000)

    val withRegionDF: DataFrame = sparkContext.parallelize[Data](filteredDataWithRegion).toDF().na.drop()
    val withoutRegionDF: DataFrame = sparkContext.parallelize[Data](filteredDataWithoutRegion).toDF().na.drop()
    val wholeDF = withRegionDF.drop("regionData", "sourceUrl", "readMe")
      .union(withoutRegionDF.drop("regionData", "sourceUrl", "readMe"))
      .orderBy(asc("lastUpdatedAtApify"))
    wholeDF.show()
    regionDF.show()
    println(regionDF.count())

    //Highest number of deaths top 10
    wholeDF.sort(desc("deaths")).show(10)

  }
}
