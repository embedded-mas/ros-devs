+!pintar_quadrado_l1
	<-
	.print("I will draw the square's side nº1!");
	!move(7.544445, 7.544445);
	!paint(0, 255, 0);
	!clear;
	!move(3.544445, 7.544445).
	 
+!pintar_quadrado_l2
	<-
	.print("I will draw the square's side nº2!");
	!move(3.544445, 7.544445);
	!paint(0, 255, 0);
	.wait(1000);
	!move(3.544445, 3.544445).

+!pintar_quadrado_l3
	<-
	.print("I will draw the square's side nº3!");
	!move(3.544445, 3.544445);
	!paint(0, 255, 0);
	.wait(1000);
	!move(7.544445, 3.544445).

+!pintar_quadrado_l4
	<-
	.print("I will draw the square's side nº4!");
	!move(7.544445, 3.544445);
	!paint(0, 255, 0);
	.wait(1000);
	!move(7.544445, 7.544445).

+!pintar_triangulo_l1
	<-
	.print("I will draw the triangle's side nº1")
	!move(3.794445, 8.087809);
	!paint(128, 0, 128);
	!clear;
	!move(7.294445, 8.087809).

+!pintar_triangulo_l2
	<-
	.print("I will draw the triangle's side nº2")
	!move(7.294445, 8.087809);
	!paint(128, 0, 128);
	.wait(1000);
	!move(5.544445, 2.001081).

+!pintar_triangulo_l3
	<-
	.print("I will draw the triangle's side nº3")
	!move(5.544445, 2.001081);
	!paint(128, 0, 128);
	.wait(1000);
	!move(3.794445, 8.087809).		


+!clear
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","clear", []);
      .wait(1000).
      
+!move(X, Y)
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle4", [X,Y,0]);
      .wait(1000).
    
+!paint(X, Y, Z)
      <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","pintar4", [X,Y,Z,2,off]);
      .wait(1000).    

+!fulfill_obligation(Scheme,Goal,ArtId,Mission)
   : (
           obligation(Ag,Norm2,What2,Deadline2)[artifact_id(ArtId),norm(_,Un2)]
		   & (satisfied(Scheme,Goal2)=What2 | done(Scheme,Goal2,Ag)=What2)  &
		   Goal2<Goal
		  
	  )
	  & .my_name(Ag)
  <- //.wait(1000);
     .print("waiting.....")
     .wait(not(
           obligation(Ag,Norm2,What2,Deadline2)[artifact_id(ArtId),norm(_,Un2)]
		   & (satisfied(Scheme,Goal2)=What2 | done(Scheme,Goal2,Ag)=What2)  &
		   Goal2<Goal
		  
	  ));
     !fulfill_obligation(Scheme,Goal,ArtId,Mission).

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
{ include("$moiseJar/asl/org-obedient.asl") }
