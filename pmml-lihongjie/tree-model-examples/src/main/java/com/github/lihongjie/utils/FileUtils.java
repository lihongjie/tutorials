package com.github.lihongjie.utils;

import org.dmg.pmml.PMML;
import org.jpmml.evaluator.Evaluator;
import org.jpmml.evaluator.ModelEvaluatorFactory;
import org.jpmml.model.JAXBUtil;
import org.jpmml.model.filters.ImportFilter;
import org.xml.sax.InputSource;

import javax.xml.transform.sax.SAXSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class FileUtils {

    private FileUtils() {

    }

    public static Evaluator createPMMLfromFile(File pmmlFile) throws Exception {

        String pmmlString = new Scanner(pmmlFile).useDelimiter("\\Z").next();
        InputStream is = new ByteArrayInputStream(pmmlString.getBytes());
        InputSource source = new InputSource(is);
//        SAXSource transformedSource = ImportFilter.apply(source); // 低版本使用apply方法
        SAXSource transformedSource = ImportFilter.apply(source);
        PMML pmml = JAXBUtil.unmarshalPMML(transformedSource);
        ModelEvaluatorFactory modelEvaluatorFactory = ModelEvaluatorFactory.newInstance();
        Evaluator evaluator = modelEvaluatorFactory.newModelEvaluator(pmml);
        return evaluator;
    }
}
