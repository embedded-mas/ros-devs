 // Incia o ROS: roscore
 // Inicia a comunicação entre arduino e ROS: rosrun rosserial_python serial_node.py /dev/ttyUSB0
 // Inicia a comunicação entre ROS e Java: roslaunch rosbridge_server rosbridge_websocket.launch
 // Verifica se o ROS está recebendo msgs do arduino: rostopic echo "chatter"

#include<Embedded_Protocol_2.h>
#include<ArduinoJson.h>
#include <ros.h>
#include <std_msgs/String.h>

ros::NodeHandle  nh;

std_msgs::String str_msg;
ros::Publisher chatter("chatter", &str_msg);

Communication communication;
const int capacity = JSON_OBJECT_SIZE(6);
StaticJsonDocument<capacity> doc;
int num = 1500;

void setup() {
  Serial.begin(9600);
  nh.initNode();
  nh.advertise(chatter);
}

void loop() {

   /*doc["value"] = num;
   doc["lat"] = 48.748010;
   doc["lon"] = 2.293491;
   doc["teste"] = "ola";
   doc["vetor"] = serialized("[1,2,\"ola\",\"teste\"]");
   */

   communication.startBelief("value");
   communication.beliefAdd(num);
   communication.endBelief();

   communication.startBelief("lat");
   communication.beliefAdd(48.748010);
   communication.endBelief();

   communication.startBelief("lon");
   communication.beliefAdd(2.293491);
   communication.endBelief();

   communication.startBelief("teste");
   communication.beliefAdd("ola");
   communication.endBelief();
   
   //communication.sendMessage();
   communication.publishROSMessage(chatter, str_msg);
   nh.spinOnce();
   delay(1000);
   num++;
}
