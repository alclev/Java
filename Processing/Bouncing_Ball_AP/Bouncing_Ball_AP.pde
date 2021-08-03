float xPos;
float yPos;
float xVel;
float yVel;
float diam;
float acc;
void settings(){
  size(800,600);
  
}
void setup(){
  xPos=width/2; //meters
  yPos=height/2; //meters
  xVel=300 * (1/60F); //m/s
  yVel=200 * (1/60F); // m/s
  acc=9.8 *(1/60F);
  diam=40;
  
}
void draw(){
  background(0);
  fill(235, 255,0);
  ellipse(xPos,yPos,diam,diam);
  fill(255);
  line(0,height/2,width,height/2);
  fill(255);
  xPos+=xVel;
  yPos+=yVel;
  yVel+=acc;
  
  if (yPos>height-diam/2 || yPos<diam/2){
    yVel=-yVel+acc;
        }
  if (xPos>width-diam/2 || xPos<diam/2){
    xVel=-xVel;
    //acc*=-1;
  }
}
