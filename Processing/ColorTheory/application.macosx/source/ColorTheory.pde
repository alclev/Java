void setup(){
  size(800,600);
  background(255,255,255);
  line(400,270,700,500);
  line(400,270,100,500);
  color orange = color(244, 142, 0);
  fill(orange);
  beginShape();
  vertex(0,0);
  vertex(150,0);
  vertex(400,270);
  vertex(100,500);
  vertex(0,400);
  endShape(CLOSE);
   noStroke();
   
  color purple= color(200,0,100);
  fill(purple);
 beginShape();
 vertex(100,500);
 vertex(400,270);
 vertex(700,500);
 vertex(600,600);
 vertex(200,600);
 endShape(CLOSE);
 
 color darkGreen= color(0,200,0);
 fill(darkGreen);
 beginShape();
 vertex(800,0);
 vertex(650,0);
 vertex(400,270);
 vertex(700,500);
 vertex(800,400);
 endShape(CLOSE);
}
void draw(){
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
  