import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class ColorTheory extends PApplet {

public void setup(){
  
  background(255,255,255);
  line(400,270,700,500);
  line(400,270,100,500);
  int orange = color(244, 142, 0);
  fill(orange);
  beginShape();
  vertex(0,0);
  vertex(150,0);
  vertex(400,270);
  vertex(100,500);
  vertex(0,400);
  endShape(CLOSE);
   noStroke();
   
  int purple= color(200,0,100);
  fill(purple);
 beginShape();
 vertex(100,500);
 vertex(400,270);
 vertex(700,500);
 vertex(600,600);
 vertex(200,600);
 endShape(CLOSE);
 
 int darkGreen= color(0,200,0);
 fill(darkGreen);
 beginShape();
 vertex(800,0);
 vertex(650,0);
 vertex(400,270);
 vertex(700,500);
 vertex(800,400);
 endShape(CLOSE);
}
public void draw(){
   noStroke();
  for(int g= 10; g<255; g +=20){
    ellipse(g,g,100,100);
     fill(0,g,0);
  }
  for(int r=10; r<255; r+=20){
    ellipse(800-r,r,100,100);
     fill(r,0,0);
  }
  for(int b= 10; b<350; b+=20){
    ellipse(400,750-b,100,100);
     fill(0,0,b);
  }
  fill(255,204,0);
  triangle(150,0,650,0,400,270);
  
  fill(0,102,204);
  triangle(800,600,800,400,600,600);
  
  fill(255,0,0);
  triangle(0,600,0,400,200,600);
}
  
  public void settings() {  size(800,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ColorTheory" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
