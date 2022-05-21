import embedded.mas.bridges.jacamo.EmbeddedAgent;
import embedded.mas.bridges.jacamo.JSONDevice;
import embedded.mas.bridges.jacamo.DefaultDevice;
import embedded.mas.bridges.ros.DefaultRos4EmbeddedMas;

import jason.asSyntax.Atom;

import java.util.ArrayList;

public class DemoEmbeddedAgentROS extends EmbeddedAgent {
	

	@Override
	public void initAg() {
		super.initAg();
	}

	@Override
	protected void setupSensors() {
	
		ArrayList<String> nodes = new ArrayList<String>();
		ArrayList<String> topics = new ArrayList<String>();

               nodes.add("topic1");
               nodes.add("topic2");

               topics.add("std_msgs/String");
               topics.add("std_msgs/String");
               
		DefaultRos4EmbeddedMas arduino = new DefaultRos4EmbeddedMas("ws://localhost:9090",nodes, topics);
		
		MyDemoDevice device = new MyDemoDevice(new Atom("arduino1"), arduino);
		this.addSensor(device);
		
	}

}
