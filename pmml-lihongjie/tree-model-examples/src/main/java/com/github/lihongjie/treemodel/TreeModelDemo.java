package com.github.lihongjie.treemodel;

import com.github.lihongjie.utils.FileUtils;
import org.dmg.pmml.FieldName;
import org.jpmml.evaluator.*;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TreeModelDemo {

    private int predict(Evaluator evaluator,int a, int b, int c, int d) {
        Map<String, Integer> data = new HashMap<>();
        data.put("x1", a);
        data.put("x2", b);
        data.put("x3", c);
        data.put("x4", d);
        List<InputField> inputFields = evaluator.getInputFields();
        //过模型的原始特征，从画像中获取数据，作为模型输入
        Map<FieldName, FieldValue> arguments = new LinkedHashMap<>();
        for (InputField inputField : inputFields) {
            FieldName inputFieldName = inputField.getName();
            Object rawValue = data.get(inputFieldName.getValue());
            FieldValue inputFieldValue = inputField.prepare(rawValue);
            arguments.put(inputFieldName, inputFieldValue);
        }

        Map<FieldName, ?> results = evaluator.evaluate(arguments);
        List<TargetField> targetFields = evaluator.getTargetFields();

        TargetField targetField = targetFields.get(0);
        FieldName targetFieldName = targetField.getName();

        Object targetFieldValue = results.get(targetFieldName);
        System.out.println("target: " + targetFieldName.getValue() + " value: " + targetFieldValue);
        int primitiveValue = -1;
        if (targetFieldValue instanceof Computable) {
            Computable computable = (Computable) targetFieldValue;
            primitiveValue = (Integer)computable.getResult();
        }
        System.out.println(a + " " + b + " " + c + " " + d + ":" + primitiveValue);
        return primitiveValue;
    }
    public static void main(String args[]) throws Exception {
        TreeModelDemo demo = new TreeModelDemo();
        File file = new File(TreeModelDemo.class.getClassLoader().getResource("tree_model_demo.pmml.xml").getPath());
        Evaluator model = FileUtils.createPMMLfromFile(file);
        demo.predict(model,1,8,99,1);
        demo.predict(model,111,89,9,11);

    }

}