package ageAssessment

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col
import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer}
import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.evaluation.RegressionEvaluator

object AgeCalulator extends App {
  val spark = SparkSession.builder
    .appName("age")
    .config("spark.executor.memory", "4g")
    .config("spark.driver.memory", "2g")
    .master("local") // Specify the master URL
    .getOrCreate()
  val trainmapPath = "C:/Users/patel/Downloads/ai4bio_trainset/trainmap.csv"
  val transpose_traindataPath = "C:/Users/patel/Desktop/transposed_data_with_header_and_index.csv"
  val transpose_traindata = spark.read.option("header", "true").option("inferSchema", "true").csv(transpose_traindataPath)
  val trainmap = spark.read.option("header", "true").option("inferSchema", "true").csv(trainmapPath)
  val trainmapWithoutC0 = trainmap.drop("_c0")

  val joinedDF = transpose_traindata.join(trainmapWithoutC0, Seq("sample_id"), "inner")

  // Select columns to keep
  val columnsToKeep = Seq("age", "gender") ++ joinedDF.columns.filter(_.startsWith("cg"))
  // Select the first 5000 columns
  val joinedDFWithoutSampleTypeAndDisease = joinedDF.select(columnsToKeep.take(15000).map(col): _*)
  val joinedDFWithoutNulls = joinedDFWithoutSampleTypeAndDisease.na.fill(0)
  // Index gender column
  val genderIndexer = new StringIndexer().setInputCol("gender").setOutputCol("genderIndex")
  // Apply the StringIndexer transformation
  val ndexedDF = genderIndexer.fit(joinedDFWithoutNulls).transform(joinedDFWithoutNulls)
  val indexedDF = ndexedDF.drop("gender")
  indexedDF.printSchema()
  // Convert numeric columns to Double
  val numericCols = indexedDF.columns.filterNot(col => col == "age").map(_.toString)
  // Assemble features into a vector
  val assembler = new VectorAssembler().setInputCols(numericCols).setOutputCol("features")
  // Create a Linear Regression model
  val lr = new LinearRegression().setLabelCol("age").setFeaturesCol("features")
  // Create a pipeline
  val pipeline = new Pipeline().setStages(Array(assembler, lr))
  // Fit the pipeline on the data
  val model = pipeline.fit(indexedDF)
  // Save the model
  val modelPath = "C:/Users/patel/Desktop/Model_files" // Replace with your desired path
  model.write.overwrite().save(modelPath)
  // Make predictions on the data
  val predictions = model.transform(indexedDF)
  // Evaluate the model
  val evaluator = new RegressionEvaluator().setLabelCol("age").setPredictionCol("prediction").setMetricName("rmse")
  val rmse = evaluator.evaluate(predictions)
  println(s"Root Mean Squared Error (RMSE) on data = $rmse")
}
