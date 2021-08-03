//piping or text dump

PVector acc;
PVector vel;
PVector bpos;  //comments
int bounce=0;
int score=0; //record


class BBall {
  float d= 25;  //0.25 m
  float vi=10; 
  

  BBall() {
    bpos= new PVector(260, 530);
    vel= new PVector(vi,0,0);
  }

  void getInput() {
    String result = javax.swing.JOptionPane.showInputDialog ("Initial Velocity (m/s)");
    float rev = float(result);
    vel.set(cos(radians(ang))*rev, sin(radians(ang))*-rev);
  }
  void display() {
    fill(230, 153, 0);
    strokeWeight(2);
    ellipse(bpos.x, bpos.y, d, d);
    arc(bpos.x-d/2+2, bpos.y, d-15, d, radians(-45), radians(45));
    arc(bpos.x+d/2-2, bpos.y, d-15, d, radians(130), radians(230));
    line(bpos.x, bpos.y+d/2-2, bpos.x, bpos.y-d/2+2);
    line(bpos.x-d/2+2, bpos.y, bpos.x+d/2-2, bpos.y);
  }

  void changePos(float dt) {
    bpos.add(PVector.mult(vel, dt));
    vel.add(PVector.mult(acc, dt));
  }

  void adjustPos() {
    bpos.set(cos(radians(-ang))*160+100, sin(radians(-ang))*160+height+(i*-10)-70);
  }

  void adjustVel() {
    vel.set(vi*cos(radians(ang)), -vi*sin(radians(ang)), 0);
  }

  void bounce(PVector vel, char xy) {
    if (xy=='x') {
      vel.x*=-0.95;
    }
    if (xy== 'y') {
      adjY();
      vel.y*=-0.95;
    }
  }

  void score() {
    text(score, 700, 400);
    output.flush();  // Writes the remaining data to the file
    output.close();
    
  }

  void reset() {
    moveball=false;
    vel.set(vi, 0, 0);
    bpos.set(260, 530-10*i, 0);
    ang=0;
    bounce=0;
  }

  void adjY() {
    if (bpos.y > height-d/2) {
      bpos.set(bpos.x, bpos.y-1);
    }
  }
}
