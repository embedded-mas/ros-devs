## Put the Ros node in your Ros package

1. Go to "your_ROS_package/src".

Don't forget to change 'your_ROS_package' for your actual package name.

2. Create a folder named "scripts" (if it doesn't exist yet).

3. Copy time_listener.py into it.

4. Under your Ros workspace directory, use the command
```
 catkin_make
```

5. Under the same directory, don't forget to use
```
 source ./devel/setup.bash
```

Following these steps, you should to able to add the time_listener node to your ROS package.

## Running the example

1. Start the roscore:
```
roscore
```

2. Launch the bridge between ROS and Java
```
roslaunch rosbridge_server rosbridge_websocket.launch
```


3. Initiate the time_listener node

```
rosrun your_package_name time_listener.py
```
Don't forget to change 'your_package_name' for your actual package name.

4. Write an initial value in the ROS topic

```
rostopic pub /value1 std_msgs/Int32 4
```
Avoid using the values 0 or 1 in this step, as it triggers the agent's actions.

5. Launch the JaCaMo application:

Linux:
```
./gradlew run
```
Windows:
```
gradlew run 
```
6. Initiate the test by writing in the ROS topic.
```
rostopic pub /value1 std_msgs/Int32 0
```
