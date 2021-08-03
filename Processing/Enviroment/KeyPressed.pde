void keyPressed() {

  if (key==CODED) {
    if (keyCode==UP) { //raise stand 
      if (i<50) {
        ball.adjustPos();
        i=i+1;
      }
    }
    if (keyCode==DOWN) { //lower stand
      if (i>0) {
        ball.adjustPos();
        i=i-1;
      }
    }
  }
  if (key=='w') {  //angle increase by 1 degree
    if (ang<90) {
      ball.adjustPos();
      ball.adjustVel();
      ang+=1;
    }
  }
  if (key=='s') {  //angle decrease by 1 degree
    if (ang>0) {
      ball.adjustPos();
      ball.adjustVel();
      ang-=1;
    }
  }

  if (key==' ') {  //launch ball
    t1=t2;
    moveball=true;
  }

  if (key=='r') {  //reset game
    ball.reset();
  }
  
  if (key=='h') {  //help menu
    if (help==false)
      help=true;
    else
      help=false;
  }
  if (key=='v') {
    ball.getInput();
  }
}
