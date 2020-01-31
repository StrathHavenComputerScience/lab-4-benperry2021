public class Lab4
{
  public static void turnRight()
  {
    Robot.turnLeft();
    Robot.turnLeft();
    Robot.turnLeft();
  }
  
  public static void turnAround()
  {
    Robot.turnLeft();
    Robot.turnLeft();
  }

  public static void backUp()
  {
    turnAround();
    Robot.move();
    turnAround();
  }
  
  public static void completeBars()
  {
    //insert instructions below
    while (Robot.frontIsClear())
    {
      completeBar();
      Robot.move();
    }
    completeBar();
    
  }
  
  public static boolean onLight()
  {
    //checking if robot it on light
    if (Robot.onDark())
    {
      return false;
    }
    return true;
    //If robot is on dark it is false, otherwise true
  }
  
  public static void completeBar()
  {
    Robot.turnLeft();
    while (onLight())
    {
      Robot.makeDark();
      Robot.move();
    }
    turnAround();
    while (Robot.frontIsClear())
    {
      Robot.move();
    }
    Robot.turnLeft();
  }
  
  public static void testCompleteBars1()
  {
    Robot.load("bars1.txt");
    Robot.setDelay(0.025);
    completeBars();
  }
  
  public static void testCompleteBars2()
  {
    Robot.load("bars2.txt");
    Robot.setDelay(0.025);
    completeBars();
  }
  
  public static void combinePiles()
  {
    //insert instructions below
    while (Robot.onDark())
    {
      moveTile();
    }
    
    
  }
  
  public static void moveTile()
  {
    while (Robot.frontIsClear())
    {
      Robot.move();
    }
    turnAround();
    while (onLight())
    {
      Robot.move();
    }
    Robot.makeLight();
    while (Robot.frontIsClear())
    {
      Robot.move();
    }
    Robot.turnLeft();
    Robot.move();
    Robot.turnLeft();
    placeTile();
  }
  
  public static void placeTile()
  {
    while (Robot.onDark())
    {
      Robot.move();
    }
    turnAround();
    Robot.makeDark();
    while (Robot.frontIsClear())
    {
      Robot.move();
    }
    turnRight();
    Robot.move();
    turnRight();
  }

  public static void testCombinePiles1()
  {
    Robot.load("piles1.txt");
    Robot.setDelay(0.025);
    combinePiles();
  }
  
  public static void testCombinePiles2()
  {
    Robot.load("piles2.txt");
    Robot.setDelay(0.025);
    combinePiles();
  }
  
  public static void connectDots()
  {
    //insert instructions below
    while (checkForSpot())
    {
      completeDot();
    }
    
    
  }
  
  public static boolean checkForSpot()
  {
    //Robot is unaware is any possible spots are dark
    if (checkLeft())
    {
      return true;
    }
    if(checkMiddle())
    {
      return true;
    }
    if(checkRight())
    {
      return true;
    }
    return false;
    //Robot knows that a spot is available, or if he is done
  }
  
  public static boolean checkLeft()
  {
    //Robot does not know if left side is clear
    Robot.turnLeft();
    Robot.move();
    Robot.move();
    turnAround();
    if(Robot.onDark())
    {
      Robot.move();
      Robot.move();
      Robot.turnLeft();
      return true;
    }
    Robot.move();
    Robot.move();
    Robot.turnLeft();
    return false;
    //Robot knows if left side is clear
  }
  
  public static boolean checkMiddle()
  {
    //Robot does not know if middle is clear
    Robot.move();
    Robot.move();
    turnAround();
    if(Robot.onDark())
    {
      Robot.move();
      Robot.move();
      turnAround();
      return true;
    }
    Robot.move();
    Robot.move();
    turnAround();
    return false;
    //Robot knows if middle is clear
  }
  
  public static boolean checkRight()
  {
    //Robot does not know if right is clear
    turnRight();
    Robot.move();
    Robot.move();
    turnAround();
    if(Robot.onDark())
    {
      Robot.move();
      Robot.move();
      turnRight();
      return true;
    }
    Robot.move();
    Robot.move();
    turnRight();
    return false;
    //Robot knows if right is clear
  }
  
  public static void completeDot()
  {
    if(checkLeft())
    {
      Robot.turnLeft();
      Robot.move();
      Robot.makeDark();
      Robot.move();
    }else{
      if(checkMiddle())
      {
        Robot.move();
        Robot.makeDark();
        Robot.move();
      }else{
        if(checkRight())
        {
          turnRight();
          Robot.move();
          Robot.makeDark();
          Robot.move();
        }
      }
    }
    
  }
  
  public static void testConnectDots1()
  {
    Robot.load("connect1.txt");
    Robot.setDelay(0.025);
    connectDots();
  }
  
  public static void testConnectDots2()
  {
    Robot.load("connect2.txt");
    Robot.setDelay(0.025);
    connectDots();
  }
}
