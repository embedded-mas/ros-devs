# ros-devs
Ros developments with embedded-mas library

 Incia o ROS: roscore
 
 Inicia a comunicação entre arduino e ROS: rosrun rosserial_python serial_node.py /dev/ttyUSB0
 
 Inicia a comunicação entre ROS e Java: roslaunch rosbridge_server rosbridge_websocket.launch
 
 Verifica se o ROS está recebendo msgs do arduino: rostopic echo "chatter"
