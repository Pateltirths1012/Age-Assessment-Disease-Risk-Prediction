package DiseasePrediction

import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.feature.{StringIndexer, VectorAssembler}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col

object DiseasePred extends App{
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
  val columnsToKeep = Seq("disease", "gender") ++ joinedDF.columns.filter(_.startsWith("cg"))

  // Select the first 5000 columns
  val joinedDFWithoutSampleTypeAndDisease = joinedDF.select(columnsToKeep.take(500).map(col): _*)
  val joinedDFWithoutNulls = joinedDFWithoutSampleTypeAndDisease.na.fill(0)

  // Index disease column
  val diseaseIndexer = new StringIndexer().setInputCol("disease").setOutputCol("diseaseIndex")

  // Apply the StringIndexer transformation
  val ndexedDF = diseaseIndexer.fit(joinedDFWithoutNulls).transform(joinedDFWithoutNulls)

  val genderIndexer = new StringIndexer().setInputCol("gender").setOutputCol("genderIndex")

  val dexedDF = genderIndexer.fit(ndexedDF).transform(ndexedDF)

  // Columns to be removed
  val columnsToRemove = Seq("gender", "disease")

  // Remove the specified columns
  val indexedDF = dexedDF.drop(columnsToRemove: _*)

  indexedDF.printSchema()
  // Convert numeric columns to Double
  val numericCols = indexedDF.columns.filterNot(col => col == "diseaseIndex").map(_.toString)

  // Assemble features into a vector
  val assembler = new VectorAssembler().setInputCols(numericCols).setOutputCol("features")

  // Create a Binary Classification model (Logistic Regression for example)
  val classifier = new LogisticRegression().setLabelCol("diseaseIndex").setFeaturesCol("features")
  // Or use another classifier, e.g., RandomForestClassifier
  // val classifier = new RandomForestClassifier().setLabelCol("label").setFeaturesCol("features")

  // Create a pipeline
  val pipeline = new Pipeline().setStages(Array(assembler, classifier))

  // Fit the pipeline on the data
  val model = pipeline.fit(indexedDF)

  val modelPath = "C:/Users/patel/Desktop/Model_disease_files" // Replace with your desired path
  model.write.overwrite().save(modelPath)
  // Make predictions on the data
}
