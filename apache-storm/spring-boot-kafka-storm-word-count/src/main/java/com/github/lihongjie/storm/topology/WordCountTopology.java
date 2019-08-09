package com.github.lihongjie.storm.topology;

import com.github.lihongjie.storm.bolt.WordCountBolt;
import com.github.lihongjie.storm.bolt.WordSplitBolt;
import com.github.lihongjie.storm.spout.RandomSentenceSpout;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

/**
 * Topology
 */
public class WordCountTopology  {

    public static void main(String[] args) throws Exception {

        System.out.println("111111111");

        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("spout", new RandomSentenceSpout(), 5);

        builder.setBolt("split", new WordSplitBolt(), 8).shuffleGrouping("spout");
        builder.setBolt("count", new WordCountBolt(), 12).fieldsGrouping("split", new Fields("word"));

        Config config = new Config();
        config.setDebug(true);

        if (args != null && args.length > 0) {
            //提交到storm集群中运行
            config.setNumWorkers(3);
            System.out.println("222222");

        } else {
            // 本地运行
            System.out.println("333333");
            config.setMaxTaskParallelism(3);
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology("word-count", config, builder.createTopology());
            Thread.sleep(10000);
            cluster.shutdown();
        }

    }

}
