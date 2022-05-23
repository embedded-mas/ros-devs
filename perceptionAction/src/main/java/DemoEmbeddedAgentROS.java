import embedded.mas.bridges.jacamo.EmbeddedAgent;
import embedded.mas.bridges.jacamo.JSONDevice;
import embedded.mas.bridges.jacamo.DefaultDevice;
import embedded.mas.bridges.ros.DefaultRos4EmbeddedMas;

import jason.asSyntax.Atom;

import java.util.ArrayList;

public class DemoEmbeddedAgentROS extends EmbeddedAgent {
	
	private ArrayList<String> nodes = new ArrayList<String>();
	private ArrayList<String> topics = new ArrayList<String>();

	@Override
	public void initAg() {
		super.initAg();
	}

	@Override
	protected void setupSensors() {
	
		

               //nodes.add("topic1"); topics.add("std_msgs/String");
               //nodes.add("topic2"); topics.add("std_msgs/String");

               
               addTopic("value1", "std_msgs/Int32");
               addTopic("value2", "std_msgs/Int32");
               addTopic("current_time", "std_msgs/String");
               
               //addTopic("/value1", null);
               //addTopic("/value2", null);
               
               /* roscore1 is a connection with a ros master. Instantiate new DefaultRos4EmbeddedMas connect the agent with more ros masters*/
		DefaultRos4EmbeddedMas roscore1 = new DefaultRos4EmbeddedMas("ws://localhost:9090",nodes, topics);
		
		/* a "device" represents a physical device. Instantiate more devices to connect to additional (even non ros) ones   */
		MyDemoDevice device = new MyDemoDevice(new Atom("roscore1"), roscore1);
		this.addSensor(device);
		
	}



	private void addTopic(String topicName, String topicType){
	   nodes.add(topicName); 
	   topics.add(topicType);
	}
}	
