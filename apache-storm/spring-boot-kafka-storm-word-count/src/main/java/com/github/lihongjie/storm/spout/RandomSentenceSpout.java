package com.github.lihongjie.storm.spout;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;

import java.util.Map;
import java.util.Random;

/**
 * 数据源,随机生成字符串
 */
public class RandomSentenceSpout extends BaseRichSpout {

    private SpoutOutputCollector collector;

    private Random random;

    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        collector = spoutOutputCollector;
        random = new Random();
    }

    @Override
    public void nextTuple() {
        //sleep 100ms 再产生数据
        Utils.sleep(100);
        String[] sentences = new String[]{
                "the cow jumped over the moon", "an apple a day keeps the doctor away four score and seven years ago", "snow white and the seven dwarfs", "i am at two with nature"
        };
        String sentence = sentences[random.nextInt(sentences.length)];
        collector.emit(new Values(sentence));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("word"));
    }
}
