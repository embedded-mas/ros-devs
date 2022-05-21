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
               
               /* roscore1 is a connection with a ros core. Instantiate new DefaultRos4EmbeddedMas connect the agent with more ros cores*/
		DefaultRos4EmbeddedMas roscore1 = new DefaultRos4EmbeddedMas("ws://localhost:9090",nodes, topics);
		
		/* a "device" represents a physical device. Instantiate more devices to connect to additional (even non ros) ones   */
		MyDemoDevice device = new MyDemoDevice(new Atom("roscore1"), roscore1);
		this.addSensor(device);
		
	}

}
