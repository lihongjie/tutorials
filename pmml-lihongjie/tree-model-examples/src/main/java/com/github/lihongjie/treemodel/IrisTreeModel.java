package com.github.lihongjie.treemodel;

import com.github.lihongjie.utils.FileUtils;
import org.dmg.pmml.FieldName;
import org.dmg.pmml.SimplePredicate;
import org.dmg.pmml.tree.Node;
import org.jpmml.evaluator.Evaluator;
import org.jpmml.evaluator.FieldValue;
import org.jpmml.evaluator.InputField;
import org.jpmml.evaluator.tree.NodeScoreDistribution;
import org.jpmml.evaluator.tree.TreeModelEvaluator;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
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
        modelEvaluator.verify();
        //读取每行数据
        for (String dataLine : dataLines) {
            // System.out.println(dataLine); // (sepal_length,sepal_width,petal_length,petal_width,class)
            //第一行表头不读取
            if (dataLine.startsWith("sepal_length"))
                continue;
            Map<FieldName, ?> arguments = iris.readArgumentsFromLine(dataLine, modelEvaluator);
            Map<FieldName, ?> results = modelEvaluator.evaluate(arguments);
            TreeModelEvaluator tree = (TreeModelEvaluator) modelEvaluator;
            FieldName targetName = tree.getTargetName();
            Object targetValue = results.get(targetName);
//            TreeModelEvaluator activeTree = (TreeModelEvaluator) targetValue;
            Node activeNode = ((NodeScoreDistribution) targetValue).getNode();

            TreeModelEvaluator treeModelEvaluator = (TreeModelEvaluator) modelEvaluator;
            Node rootNode = treeModelEvaluator.getModel().getNode();
            loopNode(rootNode, activeNode.getId().toString());

            System.out.println(results);
        }
    }

    private Map<FieldName, ?> readArgumentsFromLine(String dataLine, Evaluator modelEvaluator) {
        Map<FieldName, FieldValue> arguments = new LinkedHashMap<>();
        String[] lineArgs = dataLine.split(",");
        // 5列: sepal_width,sepal_length,petal_length,petal_width,class
        if (lineArgs.length != 5)
            return arguments;
        Map<String, Object> data = new HashMap<>();
        data.put("sepal_length", lineArgs[0]);
        data.put("sepal_width", lineArgs[1]);
        data.put("petal_length", lineArgs[2]);
        data.put("petal_width", lineArgs[3]);
        List<InputField> inputFields = modelEvaluator.getInputFields();
        for (InputField inputField : inputFields) {

            FieldName inputFieldName = inputField.getName();
            FieldValue inputFieldValue = inputField.prepare(data.get(inputFieldName.getValue()));
            arguments.put(inputFieldName, inputFieldValue);
        }
        return arguments;
    }


    private static void printArgumentsOfModel(Evaluator evaluator) {
        System.out.println("### Active Fields of Model ####");
        for (InputField fieldName : evaluator.getActiveFields()) {
            System.out.println("Field Name: " + fieldName);
        }
    }

    //递归找到命中节点
    private static void loopNode(Node node, String activeNodeId) {
            List<Node> nodes = node.getNodes();
            for (Node child : nodes) {
                if (child.getId().equals(activeNodeId)) {
                    SimplePredicate predicate = (SimplePredicate) child.getPredicate();
                    String str = "node id is : " + child.getId() + " " + predicate.getField().getValue() + " " + predicate.getOperator().value() + " " +  predicate.getValue();
                    System.out.println(str);
                    break;
                } else {
                    if (child.hasNodes()) {
                        loopNode(child, activeNodeId);
                    }
                }
            }
    }
}
