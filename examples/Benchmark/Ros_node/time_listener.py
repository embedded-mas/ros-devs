#!/usr/bin/python3

import rospy
from std_msgs.msg import Int32
import time

def topic_callback(data):
    current_time = int(time.time() * 1000)  # Convert current time to milliseconds
    rospy.loginfo("Current time (ms): %d", current_time)

def time_listener():
    rospy.init_node('time_listener_node', anonymous=True)
    rospy.Subscriber('value1', Int32, topic_callback)
    rospy.spin()

if __name__ == '__main__':
    try:
        time_listener()
    except rospy.ROSInterruptException:
        pass

