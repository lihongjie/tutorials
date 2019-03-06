package com.github.lihongjie.treemodel;

import com.github.lihongjie.utils.FileUtils;
import org.dmg.pmml.FieldName;
import org.jpmml.evaluator.Evaluator;
import org.jpmml.evaluator.FieldValue;
import org.jpmml.evaluator.InputField;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IrisTreeModel {

        public static void main(String args[]) throws Exception {
            IrisTreeModel iris = new IrisTreeModel();
            File file = new File(IrisTreeModel.class.getClassLoader().getResource("iris_treemodel.pmml.xml").getPath());
            Evaluator modelEvaluator = FileUtils.createPMMLfromFile(file);
            printArgumentsOfModel(modelEvaluator);
            List<String> dataLines = Files.readAllLines(Paths.get(IrisTreeModel.class.getClassLoader().getResource("dataset\\Iris_150.csv").toURI()));
            System.out.println(dataLines.size());
            for(String dataLine : dataLines) {
                // System.out.println(dataLine); // (sepal_length,sepal_width,petal_length,petal_width,class)
                if (dataLine.startsWith("sepal_length")) continue;
                Map<FieldName, ?> arguments = iris.readArgumentsFromLine(dataLine, modelEvaluator);
                System.out.println();
            }
    }

    private  Map<FieldName,?> readArgumentsFromLine(String dataLine, Evaluator modelEvaluator) {
            Map<FieldName, FieldValue> arguments = new LinkedHashMap<>();
        String[] lineArgs = dataLine.split(",");

        if( lineArgs.length != 5) return arguments;
        List<InputField> inputFields = modelEvaluator.getInputFields();
        for (InputField inputField : inputFields) {
              FieldName inputFieldName = inputField.getName();
  FieldValue inputFieldValue = inputField.prepare(arguments.get(inputFieldName));
   arguments.put(inputFieldName, inputFieldValue);
        }
        return arguments;
//        FieldValue sepalLength = modelEvaluator.(new FieldName("Sepal.Length"), lineArgs[0].isEmpty() ? 0 : lineArgs[0]);
//        FieldValue sepalWidth = modelEvaluator.prepare(new FieldName("Sepal.Width"), lineArgs[1].isEmpty() ? 0 : lineArgs[1]);
//        FieldValue petalLength = modelEvaluator.prepare(new FieldName("Petal.Length"), lineArgs[2].isEmpty() ? 0 : lineArgs[2]);
//        FieldValue petalWidth = modelEvaluator.prepare(new FieldName("Petal.Width"), lineArgs[3].isEmpty() ? 0 : lineArgs[3]);
    }

    public void score() {


    }

    public static void printArgumentsOfModel(Evaluator evaluator){
        System.out.println("### Active Fields of Model ####");
        for(InputField fieldName : evaluator.getActiveFields()){
            System.out.println("Field Name: "+ fieldName);
        }
    }
}
