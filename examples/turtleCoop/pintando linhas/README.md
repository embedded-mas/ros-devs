
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
4. Launch the JaCaMo application:

Linux:
```
./gradlew run
```
Windows:
```
gradlew run 
```

What's not working:

	The agent 'toruga1' tries to call a service called '/turtle1/set_pen' through it's internal action 'pintar', but it fails. The service service has 5 parameters: 'r', 'g', 'b', 'widht', 'off'. They are, respectively, the values of red, green and blue pixels, the width of the line that will be drawn and the option to not draw the line.



