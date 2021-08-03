void setup(){
  size(1000,700);
  frameRate(100);
  ellipseMode(RADIUS);
}
float s=280;
float sd=.1;
float a=.4;
int direction=1;
int radius=40;

void draw(){
  background(200,240,60);
  sd=sd+a*direction;
  s=s+sd*direction;
  if ((s>height-radius) || (s < radius)){
    direction= -direction;
  }
  for(int i=40; i<1000; i+=90){
    ellipse(i,s,radius,radius);
    fill(s,100,s);
  }
  for(int i=40; i<1000; i+=90){
    fill(s,100,s);
   ellipse(s,i,radius,radius);
   
  }
  text(s,100,100);
  //for(int y=0; y<=height;y+= 90){
    //for(int x=0;x<=width;x+=90){
      //ellipse(s,x,radius,radius);
      //ellipse(y,s,radius,radius);
  //  }
  print(s);
}