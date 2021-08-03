int i;
int ang;
boolean moveball;
int circx;
int circy;
class Cannon {


  void drawcannon() {
    int circx=100;
    int circy=height+(i*-10)-50;
    fill(0);
    strokeWeight(0);
    pushMatrix();
    translate(100, height+(i*-10)-70);
    rectMode(CENTER);
    rotate(radians(-ang));
    rect(90, 0, 175, 40);
    popMatrix();
    fill(100);
    ellipse(circx, circy, 100, 100);
  }
  void drawangle() {
    int circx=100;
    int circy=height+(i*-10)-50;
    strokeWeight(0.5);
    line(circx, circy, circx+195, circy);
    fill(0);
    textSize(32);
    text(ang+"°", circx+100, circy+30);
  }
  void drawStand() {
    strokeWeight(2);
    fill(0, 255, 0);
    rectMode(CORNER);
    rect(0, height, 200, -10*i);
  }
  
  void help(){
    fill(255, 255, 0);
    rectMode(CORNER);
    rect(0, 0, width, height);
    fill(0);
    textSize(25);
    text("--To raise/lower cannon press UP ARROW/DOWN ARROW--", 50, 200);
    text("--To increase/decrease angle of cannon press 'w'/'s'--", 50, 250);
    text("--To input initial velocity press 'v'--", 50, 300);
    text("--To launch ball press SPACE BAR--", 50, 350);
    text("--To reset press 'r'--", 50, 400);
    text("**Press 'h' again to resume**", 200, 550);
  }
}
