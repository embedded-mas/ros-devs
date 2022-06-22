# Example of service request with nested parameters

## Scenario

This example illustrates service request with nested parameters, i.e. parameters that are sets of parameters.

The parameters are {"header":{"seq":0,"stamp":{"secs":0,"nsecs":0},"frame_id":"uav1/local_origin"},"reference":{"position":{"x":8.0,"y":8.0,"z":2.0},"heading":0.0}}


## Requirements
1. ROS (recommended [ROS Noetic](http://wiki.ros.org/noetic))
2. [Rosbridge](http://wiki.ros.org/rosbridge_suite/Tutorials/RunningRosbridge)


## Running the example

1. Start the roscore
```
roscore
```

2. Launch the bridge between ROS and Java
```
roslaunch rosbridge_server rosbridge_websocket.launch
```

4. Launch the JaCaMo application:

Linux:
```
./gradlew run
```
Windows:
```
gradlew run 
```

