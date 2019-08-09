package com.github.lihongjie.storm.bolt;

import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Tuple;

import java.util.*;

public class ReportBolt extends BaseBasicBolt {

    private Map<String, Integer> counts = null;

    @Override
    public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        String word = tuple.getStringByField("word");
        Integer count = tuple.getIntegerByField("count");
        counts.put(word, count);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        // this bolt does not emit anything
    }

    @Override
    public void prepare(Map stormConf, TopologyContext context) {
        this.counts = new HashMap<>();
    }

    @Override
    public void cleanup() {
        System.out.println("===========start============");
        List<String> keys = new ArrayList<>();
        keys.addAll(counts.keySet());
        Collections.sort(keys);
        for (String key : keys) {
            System.out.println(key + " : " + counts.get(key));
        }
        System.out.println("===========end===========");
    }
}
