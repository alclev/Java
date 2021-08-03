float x= -40;
float speed= 1.2;

void setup(){
  size(400,400);
  frameRate(100);
}
void draw(){
  background(20,10,100);
  println(frameRate);
  println(mouseX,mouseY);
  x += speed;
ellipse(x,200,40,40);  
}