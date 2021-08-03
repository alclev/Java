BBall ball;
Cannon can;
PImage img1;
boolean help=false;
long t1;
long t2;
boolean sc=false;
PrintWriter output;
void settings() {
  //called 100 pixels= 1 meter
  size(800, 600); //8 meters by 6 meters
}
void setup() {
  ball= new BBall(); 
  can= new Cannon();
  img1= loadImage("net.png");
  t1=millis();
  acc= new PVector(0, 0.098, 0);
  output = createWriter("bridge.txt");
}

void draw() {

  t2=millis();
  float dt=(t2-t1)/1000.0;
  output.print(dt+", ");

  background(227, 245, 255); 
  image(img1, 650, 100, 150, 150);
  fill(0);
  textSize(16);
  text("Press 'h' for help", 400, height-50);

  can.drawangle();
  can.drawStand();
  ball.display();
  can.drawcannon();


  if (moveball) {
    ball.changePos(dt);
  }

  if (help) {
    can.help();
  }


  if (bpos.x < 15 || bpos.x > width-12.5) {
    bounce++;
    ball.bounce(vel, 'x');
  }
  if (bpos.y < 15 || bpos.y > height-12.5) {
    bounce++;
    ball.bounce(vel, 'y');
  }
  if (bpos.x>749.5 && bpos.y>99.5 && bpos.y <189.5) {
    ball.bounce(vel, 'x');
  }

  if (bounce==3) {
    ball.reset();
  }

  if (bpos.y>180 && bpos.y<210 && bpos.x>670 && bpos.x<750) {
    ball.reset();
    score++;
    sc=true;
  }

  if (sc) {
    ball.score();
  }

}
