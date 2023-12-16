package TestPackage

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.types.StringType

class TestSpec extends App{
  val spark = SparkSession.builder.master("local").appName("CSVFileValidation").getOrCreate()
  val filePath = "/Users/shreemoynanda/Desktop/NEU/CYSE7200_Scala/Assignment/Final Project/transposed_test_data.csv"
  val df: DataFrame = spark.read.option("header", "true").csv(filePath)

  // Check if the file is a CSV file
  if (!filePath.endsWith(".csv")) {
    throw new AssertionError("The input file is not a CSV file")
  }

  // Check if the DataFrame has a "sample_id" column of string datatype
  if (!df.columns.contains("_c0")) {
    throw new AssertionError("The input file does not contain the sample_id column")
  }

  val sampleIdDataType = df.schema("_c0").dataType
  if (sampleIdDataType != StringType) {
    throw new AssertionError("The sample_id column is not of string datatype")
  }
}
