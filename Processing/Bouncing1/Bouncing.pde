PVector g;
float xpos,ypos;

float a=.00001; //acceleration
int radius=40; //radius

int xdirection=1;//direction
int ydirection=1;//direction

float xspeed= 1; //speeds
float yspeed= 1;

void setup(){
  size(1000,700);
  frameRate(100);
  ellipseMode(RADIUS);
  xpos=width/2;
  ypos=height/2;
  g = new PVector(0,-9.8,0);
}
void draw(){
  a=a+.00001;//change in acceleration
  xspeed=xspeed+a;
  yspeed=yspeed+a;
  xpos=xpos+(xspeed*xdirection);
  ypos=ypos+(yspeed*ydirection);
  background(ypos,xpos,40);
  if ((ypos>height-radius) || (ypos < radius)){
    ydirection= -ydirection;
  }
  if ((xpos>width-radius) || (xpos<radius)){
    xdirection= -xdirection;
  }
  ellipse(xpos,ypos,radius,radius);
  fill(xpos,60,ypos);
  text(xspeed,100,100);
  text(yspeed,100,200);
  if (mousePressed == true){
    xspeed=0;
    yspeed=0;
    xpos=width/2;
    ypos=height/2;
    a=0;
  }
}