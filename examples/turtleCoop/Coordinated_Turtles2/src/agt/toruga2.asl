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



+!pintar_hexagono_l1
	<-
	.print("I will draw the hexagon's side nº1!");
	!move(5.544445, 8.928932);
	!paint(255, 0, 0);
	!clear;
	!move(4.288248, 7.672735).

+!pintar_hexagono_l2
	<-
	.print("I will draw the hexagon's side nº2!");
	!move(4.288248, 7.672735);
	!paint(255, 0, 0);
	.wait(1000);
	!move(4.288248, 4.589442).

+!pintar_hexagono_l3
	<-
	.print("I will draw the hexagon's side nº3!");
	!move(4.288248, 4.589442);
	!paint(255, 0, 0);
	.wait(1000);
	!move(5.544445, 3.333245).

+!pintar_hexagono_l4
	<-
	.print("I will draw the hexagon's side nº4!");
	!move(5.544445, 3.333245);
	!paint(255, 0, 0);
	.wait(1000);
	!move(6.8000642, 4.589442).

+!pintar_hexagono_l5
	<-
	.print("I will draw the hexagon's side nº5!");
	!move(6.8000642, 4.589442);
	!paint(255, 0, 0);
	.wait(1000);
	!move(6.8000642, 7.672735).

+!pintar_hexagono_l6
	<-
	.print("I will draw the hexagon's side nº6!");
	!move(6.8000642, 7.672735);
	!paint(255, 0, 0);
	.wait(1000);
	!move(5.544445, 8.928932).

+!pintar_estrela_l1
	<-
	.print("I will draw the star's side nº1");
	!move(6.461259, 4.821240);
	!paint(255, 165, 0);
	!clear;
	!move(5.519163, 3.015276).

+!pintar_estrela_l2
	<-
	.print("I will draw the star's side nº2");
	!move(5.519163, 3.015276);
	!paint(255, 165, 0);
	.wait(1000);
	!move(4.577067, 4.821240).

+!pintar_estrela_l3
	<-
	.print("I will draw the star's side nº3");
	!move(4.577067, 4.821240);
	!paint(255, 165, 0);
	.wait(1000);
	!move(2.531694, 5.029211).	

+!pintar_estrela_l4
	<-
	.print("I will draw the star's side nº4");
	!move(2.531694, 5.029211);
	!paint(255, 165, 0);
	.wait(1000);
	!move(4.000041, 6.448679).

+!pintar_estrela_l5
	<-
	.print("I will draw the star's side nº5");
	!move(4.000041, 6.448679);
	!paint(255, 165, 0);
	.wait(1000);
	!move(3.544445, 8.994211).

+!pintar_estrela_l6
	<-
	.print("I will draw the star's side nº6");
	!move(3.544445, 8.994211);
	!paint(255, 165, 0);
	.wait(1000);
	!move(5.519163, 7.505605).	

+!pintar_estrela_l7
	<-
	.print("I will draw the star's side nº7");
	!move(5.519163, 7.505605);
	!paint(255, 165, 0);
	.wait(1000);
	!move(7.494381, 8.994211).	

+!pintar_estrela_l8
	<-
	.print("I will draw the star's side nº8");
	!move(7.494381, 8.994211);
	!paint(255, 165, 0);
	.wait(1000);
	!move(7.038311, 6.448679).	

+!pintar_estrela_l9
	<-
	.print("I will draw the star's side nº9");
	!move(7.038311, 6.448679);
	!paint(255, 165, 0);
	.wait(1000);
	!move(8.506631, 5.029211).	

+!pintar_estrela_l10
	<-
	.print("I will draw the star's side nº10");
	!move(8.506631, 5.029211);
	!paint(255, 165, 0);
	.wait(1000);
	!move(6.461259, 4.821240).	


+!clear
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","clear", []);
      .wait(1000).
      
+!move(X, Y)
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle2", [X,Y,0]);
      .wait(1000).
    
+!paint(X, Y, Z)
      <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","pintar2", [X,Y,Z,2,off]);
      .wait(1000).    


{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
{ include("$moiseJar/asl/org-obedient.asl") }
