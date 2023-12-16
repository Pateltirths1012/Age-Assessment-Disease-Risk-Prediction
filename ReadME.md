# DNA Methylation Aging Clock

## Project Overview

This project leverages Apache Spark with Scala to analyze DNA methylation data for building a biological clock that can evaluate the biological age of a given sample. DNA methylation is a common epigenetic phenomenon influencing gene expression and cellular function. The project aims to understand the correlation between changes in DNA methylation patterns and the aging process.

## Background Knowledge

DNA methylation involves adding a methyl group to DNA molecules, particularly at CpG sites (Cytosine-phosphate-Guanine). This process, catalyzed by DNA methyltransferase, impacts gene expression without altering the DNA sequence. As individuals age, DNA methylation patterns change, reflecting the aging process of cells and tissues. This phenomenon serves as a personalized biological clock, predicting aging, disease susceptibility, and mortality.

## Competition Task

The primary objective is to build a Age prediction model capable of evaluating the biological age of a sample. For healthy samples, the biological age should closely match the true age. In the case of diseased samples, the biological age tends to be older than the true age. Additionally, the project involves predicting which samples in the test cluster have Alzheimer's disease.

## Dataset Introduction

The dataset consists of 1000 samples, with 400 being healthy. Each sample provides methylation data for 18,000 sites, along with age and disease status. 

### Training Set Details:

- Total Samples: 1000
- Healthy Samples: 400
- Diseased Samples: Alzheimer's disease, schizophrenia, Parkinson's disease, rheumatoid arthritis, stroke, Huntington's disease, Graves' disease, type 2 diabetes, Sjogren's syndrome, and others.

### Dataset Formats:

- `trainmap.csv`: Each row represents a sample with columns for sample_id, age, gender, sample_type, and disease.
  
  Example:
  ```csv
  sample_id, age, gender, sample_type, disease
  1, train10001, 86, M, disease tissue, Alzheimer's disease
  2, train10002, 89, M, disease tissue, Alzheimer's disease
  3, train10003, 80, F, disease tissue, Alzheimer's disease
  ```

- `traindata.csv`: A matrix of size (1000, 18,000), where each column represents a sample, and each row represents a methylation site.

- `testdata.csv`: Format similar to `traindata.csv`. `testmap.csv` provides only `sample_id` and `gender` for the test set.

## Project Execution

1. **Data Preprocessing:** Utilize Apache Spark to preprocess and clean the DNA methylation data, handling missing values and outliers.

2. **Feature Engineering:** Extract relevant features from the dataset to build the biological aging clock.

3. **Model Training:** Apply machine learning algorithms available in Spark MLlib to train a model on the training dataset.

4. **Age Predication:** Evaluate the biological age of samples in the test set using the trained model.

5. **Disease Prediction:** Utilize the model to predict samples in the test set that may have Alzheimer's disease.

## Running the Project

1. Ensure you have Apache Spark and Scala installed on your system with IntelliJ IDE.

2. Clone the repository:
   ```bash
   git clone https://github.com/Pateltirths1012/Age-Assessment-Disease-Risk-Prediction
   ```

3. Navigate to the project directory:
   ```bash
   cd Age-Assessment-Disease-Risk-Prediction
   ```

4. Import the project file in IntelliJ IDE and run the files in the following order,
	Move to the following directory- Age-Assessment-Disease-Risk-Prediction\ML_Prediction_Spark\src
	First run the test file to see if the input file we got is correct.
	TestSpec.scala
	To find the age,
	1- AgeCalculator.sc
	2- AccessAgeCalculator
	To find the Disease risk,
	1- DiseasePred
	2- AccessDiseasePred
	
	
   ```

## Contributors

- Tirth Patel
- Shreemoy Nandha
- Adwaith Korapati

## License

This project is licensed under the [MIT License](LICENSE).

Feel free to contribute and make the biological clock more accurate and robust!