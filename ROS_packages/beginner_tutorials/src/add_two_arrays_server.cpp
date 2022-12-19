#include "ros/ros.h"
#include "beginner_tutorials/AddTwoArrays.h"

bool add(beginner_tutorials::AddTwoArrays::Request &req,
         beginner_tutorials::AddTwoArrays::Response &res) {
  res.sum.resize(3);
  for (int i = 0; i < 3; i++) {
    res.sum[i] = req.a[i] + req.b[i];
    ROS_INFO("request: x=%f, y=%f", req.a.at(i), req.b[i]);
    ROS_INFO("sending back response: [%f]", res.sum[i]);
  }
  return true;
}

int main(int argc, char **argv) {
  ros::init(argc, argv, "add_two_array_server");
  ros::NodeHandle n;

  ros::ServiceServer service = n.advertiseService("add_two_array", add);
  ROS_INFO("Ready to add two ints.");
  ros::spin();

  return 0;
}