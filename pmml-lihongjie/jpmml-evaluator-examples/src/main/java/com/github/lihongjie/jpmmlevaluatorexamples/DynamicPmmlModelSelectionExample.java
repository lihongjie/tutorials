package com.github.lihongjie.jpmmlevaluatorexamples;

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

public class DynamicPmmlModelSelectionExample {

    public static void main(String[] args) throws Exception {

        String modelFile = "dynamic-model-selection-example.pmml.xml";
        InputStream inputStream = DynamicPmmlModelSelectionExample.class.getClassLoader().getResourceAsStream(modelFile);

        PMML pmml = JAXBUtil.unmarshalPMML(ImportFilter.apply(new InputSource(inputStream)));

        PMMLManager pmmlManager = new PMMLManager(pmml);

        ModelEvaluator evaluator = (ModelEvaluator) pmmlManager.getModelManager(ModelEvaluatorFactory.getInstance());

        Map<String, Object> map1 = new HashMap<>();
        map1.put("year", 2014);
        map1.put("attribute1", "1330");

        System.out.println(score(evaluator, map1));

        Map<String, Object> map2 = new HashMap<>();
        map2.put("year", 2014);
        map2.put("attribute1", "1315");

        System.out.println(score(evaluator, map2));

        Map<String, Object> map3 = new HashMap<>();
        map3.put("year", 2014);
        map3.put("attribute1", "1330");

        System.out.println(score(evaluator, map3));
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
