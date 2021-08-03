void setup(){
  size(400,600);
  ellipseMode(RADIUS);
}
 float posx,posy;
 float a =.0001;
 float xspeed= 1;
 float yspeed= 1;
 int radius= 20;
 int direction=1;
void draw(){
  background(200,100,200);
  a=a+.000001;
 posx=width/2;
 posy=height/2;
 xspeed+=a;
 yspeed+=a;
 posx=posx+xspeed*direction;
 posy=posy+yspeed*direction;
 if ((posx>radius-width) || posx<radius){
   direction=-direction;
 }
  if ((posy>radius-height) || posy<radius){
   direction=-direction;
 }
 ellipse(posx,posy,radius,radius);
 fill(posx,100,posy);
}
