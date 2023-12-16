package ageAssessment

import org.apache.spark.ml.PipelineModel
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.{DataFrame, SparkSession}


object AccessAgeCalculator extends App {
  val spark = SparkSession.builder
    .appName("age")
    .config("spark.executor.memory", "4g")
    .config("spark.driver.memory", "2g")
    .master("local") // Specify the master URL
    .getOrCreate()

  // Load the saved model
  val modelPath = "C:/Users/patel/Desktop/Model_files" // Replace with the path where your model is saved
  val loadedModel = PipelineModel.load(modelPath)

  // Load your test data or any data you want to predict on
  val testPath = "C:/Users/patel/Downloads/transposed_data.csv" // Replace with your test data path
  val testData = spark.read.option("header", "true").option("inferSchema", "true").csv(testPath)
  val testMapPath = "C:/Users/patel/Downloads/testmap.csv"
  val testMap = spark.read.option("header", "true").option("inferSchema", "true").csv(testMapPath)
  // Perform the same preprocessing steps as done for training data
  val testMapWithoutC0 = testMap.drop("_c0")
  val dfRenamed = testData.withColumnRenamed("_c0", "sample_id")

  val testjoinedDF = dfRenamed.join(testMapWithoutC0, Seq("sample_id"), "inner")

  val testcolumnsToKeep = Seq("gender") ++ testjoinedDF.columns.filter(_.startsWith("cg"))
  // Select the first 5000 columns
  val testjoinedDFWithoutSampleTypeAndDisease = testjoinedDF.select(testcolumnsToKeep.take(15000).map(col): _*)
  val testjoinedDFWithoutNulls = testjoinedDFWithoutSampleTypeAndDisease.na.fill(0)
  // Index gender column
  val testgenderIndexer = new StringIndexer().setInputCol("gender").setOutputCol("genderIndex")
  // Apply the StringIndexer transformation
  val testIndexedDF = testgenderIndexer.fit(testjoinedDFWithoutNulls).transform(testjoinedDFWithoutNulls)

  // Transform the test data using the loaded model for prediction
  val testPredictions = loadedModel.transform(testIndexedDF)

  // Show predictions
  testPredictions.select("prediction").show()
}
