import DiseasePrediction.AccessDiseasePred
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession
import ageAssessment.AccessAgeCalculator._
import DiseasePrediction.AccessDiseasePred._
import ageAssessment.AccessAgeCalculator

object SparkOrchestrationScript extends App {
  val sparkConf = new SparkConf().setAppName("SparkOrchestrationScript").setMaster("local[*]")

  val sparkContext = new SparkContext(sparkConf)
  
  try {
    println("Executing AccessAgePrediction.scala")
    AccessAgeCalculator.main(Array())

    println("Executing AccessDiseasePrediction.scala")
    AccessDiseasePred.main(Array())

    println("Spark jobs completed")
  } finally {
    sparkContext.stop()
  }

}
