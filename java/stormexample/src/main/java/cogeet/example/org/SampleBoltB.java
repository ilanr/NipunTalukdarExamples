package cogeet.example.org;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;



public class SampleBoltB extends BaseRichBolt {
	
	private OutputCollector collector = null;
	@Override
	public void prepare(Map stormConf, TopologyContext context,
			OutputCollector collector) {
		System.out.println("SampleBoltB is prepared");
		this.collector = collector;
	}

	@Override
	public void execute(Tuple input) {
		Sample a = (Sample)input.getValueByField(Consts.BOLTA_FIELD_1);
		//System.out.println("Sample bolt B received a packet " + a);
		collector.ack(input);
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields(Consts.BOLTB_FIELD_1, Consts.BOLTB_FIELD_2));
	}

}
