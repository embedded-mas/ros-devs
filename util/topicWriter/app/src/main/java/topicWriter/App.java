
package topicReader;

import java.util.ArrayList;
import embedded.mas.bridges.ros.DefaultRos4EmbeddedMas;

public class App {
    
    public static void main(String[] args) {

        String topicName = "/turtle1/cmd_vel";
        String topicType = "geometry_msgs/Twist";
		String valueToPublish = "{\"linear\": {\"x\": 1.0, \"y\": 0.0, \"z\": 0.0}, \"angular\": {\"x\": 0.0, \"y\": 0.0, \"z\": 1.0}}";
    
		DefaultRos4EmbeddedMas ros = new DefaultRos4EmbeddedMas("ws://localhost:9090", new  ArrayList<String>() ,  new  ArrayList<String>() ,  new  ArrayList<String>());
		ros.rosWrite(topicName, topicType, valueToPublish);
	
    }
    
}
