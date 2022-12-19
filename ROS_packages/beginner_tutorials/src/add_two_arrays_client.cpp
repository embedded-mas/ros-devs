#include "ros/ros.h"
#include "beginner_tutorials/AddTwoArrays.h"
#include <cstdlib>

int main(int argc, char **argv) {
  ros::init(argc, argv, "add_two_array_client");

  ros::NodeHandle n;
  ros::ServiceClient client =
      n.serviceClient<beginner_tutorials::AddTwoArrays>("add_two_array");
  beginner_tutorials::AddTwoArrays srv;

  std::vector<double> a(3);
  std::vector<double> b(3);

  a[0] = 1.0;
  a[1] = 2.0;
  a[2] = 3.0;

  b[0] = 4.0;
  b[1] = 5.0;
  b[2] = 6.0;

  srv.request.a = a;
  srv.request.b = b;
  if (client.call(srv)) {

    for (int i = 0; i < 3; i++) {
      ROS_INFO("Sum: %f", (float)srv.response.sum[i]);
    }
  } else {
    ROS_ERROR("Failed to call service add_two_array");
    return 1;
  }

  return 0;
}