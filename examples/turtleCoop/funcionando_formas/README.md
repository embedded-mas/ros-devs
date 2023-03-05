
1. Start the roscore
```
roscore
```

2. Launch the bridge between ROS and Java
```
roslaunch rosbridge_server rosbridge_websocket.launch
```

3. Launch the turtlesim simulator
```
rosrun turtlesim turtlesim_node
```
4. Spawn a second turtle
```
rosservice call /spawn 5.544445 5.544445 3.141592 turtle2
```

5. Launch the JaCaMo application:

Linux:
```
./gradlew run
```
Windows:
```
gradlew run 
```

