package com.github.lihongjie.treemodel;

import com.github.lihongjie.jpmmlevaluatorexamples.DynamicPmmlModelSelectionExample;
import org.dmg.pmml.FieldName;
import org.dmg.pmml.PMML;
import org.jpmml.evaluator.FieldValue;
import org.jpmml.evaluator.ModelEvaluator;
import org.jpmml.evaluator.ModelEvaluatorFactory;
import org.jpmml.manager.PMMLManager;
import org.jpmml.model.ImportFilter;
import org.jpmml.model.JAXBUtil;
import org.xml.sax.InputSource;

import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TreeModelDemo {

    public static void main(String[] args) throws Exception {

        ModelEvaluator evaluator= buildEvaluator();
        Map<String, Object> data = new HashMap<>();
        data.put("x1", 1);
        data.put("x2", 8);
        data.put("x3", 99);
        data.put("x4", 1);
        Map<FieldName, ?> map = score(evaluator, data);

        List<FieldName> targetFields = evaluator.getTargetFields();


//        Object targetFieldValue = map.get(targetFieldName);
        System.out.println(map);

    }

    private static ModelEvaluator buildEvaluator() throws Exception {
        String modelFile = "tree_model_demo.pmml.xml";
        InputStream inputStream = DynamicPmmlModelSelectionExample.class.getClassLoader().getResourceAsStream(modelFile);

        PMML pmml = JAXBUtil.unmarshalPMML(ImportFilter.apply(new InputSource(inputStream)));

        PMMLManager pmmlManager = new PMMLManager(pmml);

        ModelEvaluator evaluator = (ModelEvaluator) pmmlManager.getModelManager(ModelEvaluatorFactory.getInstance());
        return evaluator;
    }

    private static Map<FieldName, ?> score(ModelEvaluator<?> evaluator, Map<String, Object> input) {

        Map<FieldName, FieldValue> arguments = new LinkedHashMap<>();
        List<FieldName> activeFields = evaluator.getActiveFields();
        for (FieldName activeField : activeFields) {
            Object rawValue = input.get(activeField.getValue());
            FieldValue activeValue = evaluator.prepare(activeField, rawValue);
            arguments.put(activeField, activeValue);
        }
        return evaluator.evaluate(arguments);
    }
}
