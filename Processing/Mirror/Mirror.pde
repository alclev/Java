void setup(){
  frameRate(300);
  size(500,500);
  background(255);
  line(250,0,250,500);
}
  int size=7;

void draw(){
   if(mousePressed){
  ellipse(mouseX,mouseY,size,size);
  ellipse(500-mouseX,mouseY,size,size);

  fill(mouseX,mouseY,100);
   }

  if(keyPressed) {
    if (key == 'e'){
      background(255);
      line(250,0,250,500);
      
    }
}
}