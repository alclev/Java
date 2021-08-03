void setup(){
  background(200,200,20);
  size(700,400);
  ellipse(40,40,10,10);
  ellipse(40,80,30,30);
  ellipse(40,130,50,50);
  ellipse(40,200,70,70);
}


void draw(){
  int ping= +1;
  print("ping");
  print(frameCount);
  float weight= dist(mouseX,mouseY,pmouseX,pmouseY);
  strokeWeight(weight);
  line(mouseX,mouseY,pmouseX,pmouseY);
  
  //Erase using the mouse
  if (mouseButton== LEFT) {
    float x= random(0,0);
    background(x);
  size(700,400);
  ellipse(40,40,10,10);
  ellipse(40,80,30,30);
  ellipse(40,130,50,50);
  ellipse(40,200,70,70);
  }
  
  //Graphical User Interface
  
  
}