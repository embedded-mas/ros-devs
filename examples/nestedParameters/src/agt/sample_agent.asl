//initial beliefs
seq(0).
secs(0).
nsecs(0).
frame_id("uav1/local_origin").
x(8.0).
y(8.0).
z(2.0).
heading(0.0).

input_id(0).
use_heading(false).
fly_now(false).
stop_at_waypoints(false).
loop(false).
override_constraints(false).
override_max_velocity_horizontal(0.0).
override_max_acceleration_horizontal(0.0).
override_max_jerk_horizontal(0.0).
override_max_velocity_vertical(0.0).
override_max_acceleration_vertical(0.0).
override_max_jerk_vertical(0.0).
relax_heading(false).
position([[2,2,2],[10,10,2]]).	


//initial goals
!test. 
!test2.

+!test: seq(Seq) & secs(Secs) & nsecs(NSecs) & frame_id(Frame_id) & x(X) & y(Y) & z(Z) & heading(Heading)
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("roscore1","teste", [Seq,Secs,NSecs,Frame_id,X,Y,Z,Heading]).
      
      
+!test2: seq(Seq) & secs(Secs) & nsecs(NSecs) & frame_id(Frame_id) & 
         input_id(II) & use_heading(UH) & fly_now(FN) &  stop_at_waypoints(SAW) &
         loop(Loop) & override_constraints(OC) & override_max_velocity_horizontal(OMVH) &
         override_max_acceleration_horizontal(OMAH) & override_max_jerk_horizontal(OMJH)&
         override_max_velocity_vertical(OMVV) & override_max_acceleration_vertical(OMAV) & 
         override_max_jerk_vertical(OMJV) & relax_heading(RH) & position(Position) & heading(Heading)
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("roscore1","teste2", [Seq,Secs,NSecs,Frame_id,II,UH,FN,SAW,Loop,OC,OMVH,OMAH,OMJH,OMVV,OMAV,OMJV,RH,Position,Heading]).      
      
      
      
 

      
      
