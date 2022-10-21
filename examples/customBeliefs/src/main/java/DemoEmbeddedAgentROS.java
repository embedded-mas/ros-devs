import embedded.mas.bridges.jacamo.EmbeddedAgent;
import embedded.mas.bridges.jacamo.JSONDevice;
import embedded.mas.bridges.jacamo.DefaultDevice;
import embedded.mas.bridges.ros.DefaultRos4EmbeddedMas;

import jason.asSyntax.Atom;

import java.util.ArrayList;

public class DemoEmbeddedAgentROS extends EmbeddedAgent {
	
	private ArrayList<String> nodes = new ArrayList<String>();
	private ArrayList<String> topics = new ArrayList<String>();
	private ArrayList<String> beliefNames = new ArrayList<String>();

	@Override
	public void initAg() {
		super.initAg();
	}

	@Override
	protected void setupDevices() {
	
		/** adding topics to be translated to beliefs.
		 *  The first parameter is the topic name; the second is the topic type; the third is the corresponding belief nam
		 */
        addTopic("value1", "std_msgs/Int32","value_one");
        addTopic("value2", "std_msgs/Int32","value_two");
        addTopic("current_time", "std_msgs/String","current_hour");
               
        /**
		 *  roscore1 is a connection with a ros master. 
		 * 	Instantiate new DefaultRos4EmbeddedMas connect the agent with more ros masters
		*/
		
		DefaultRos4EmbeddedMas roscore1 = new DefaultRos4EmbeddedMas("ws://localhost:9090",nodes, topics,beliefNames);	
   	    MyRosMaster rosMaster = new MyRosMaster(new Atom("roscore1"), roscore1);
		this.addSensor(rosMaster);
		
	}



	private void addTopic(String topicName, String topicType){
	   addTopic(topicName, topicType,topicName);
	}

	private void addTopic(String topicName, String topicType, String beliefName){
	  nodes.add(topicName); 
	  topics.add(topicType);
	  beliefNames.add(beliefName);
	}
}	
