package com.examples

import org.apache.spark.sql.SparkSession

object SparkJar {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().getOrCreate()

    // Prints the arguments to the class, which
    // are job parameters when run as a job:
    println(args.mkString(", "))

    // Shows using spark:
    println(spark.version)
    println(spark.range(10).limit(3).collect().mkString(" "))
  }
}