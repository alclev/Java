
float x=300;
float y=200;

int radius=20;
int xspeed=4;
int yspeed=4;

void setup(){
  size(600,400);
  frameRate(100);
  ellipseMode(RADIUS);
}
void draw(){
  background(x,200,y);
  if (keyPressed && (key==CODED)){
    if (keyCode==LEFT){
    x=x-xspeed;
  } else if (keyCode ==RIGHT){
    x=x+xspeed;
  }
  }
  if (keyPressed && (key==CODED)){
    if (keyCode==UP){
    y=y-yspeed;
  } else if (keyCode ==DOWN){
    y=y+yspeed;
  }
  }
 
  if (x>width-radius){
    x=x-xspeed;
  }
  if (x<radius){
    x=x+xspeed;
  }
  if (y>height-radius){
    y=y-yspeed;
  }
  if (y<radius){
    y=y+yspeed;
  }
  ellipse(x,y,radius,radius);
}