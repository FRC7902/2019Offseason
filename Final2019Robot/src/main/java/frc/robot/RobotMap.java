/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {
 
  //CAN IDs for motor controller outputs
  //Drive motors
  public static final int frontRight = 1;
  public static final int backRight = 2;
  public static final int frontLeft = 3;
  public static final int backLeft = 4;

  //wrist motors
  public static final int wristMotor = 5;
  public static final int wristMotor2 = 6;

  //intake motors
  public static final int intakeTop = 7;
  public static final int intakeBottom = 8;

  //Solenoid Valves (PCM Port Values)
  public static final int frontValve = 0;
  public static final int backValve = 1;

  
  //COMMAND CENTER

  //Drive

  public static final double driveSpeedLimiter = 0.6;

  public static final double driveFBSpeed = 1;
  public static final double driveTurnSpeed = 0.75;

  public static final int driveMicroFBButton = 9;
  public static final int driveMicroTurnButton = 10;

  


  //Wrist

  public static final int wristCargoPos = -650;
  public static final double wristCargoMult = 0.3;
  public static final double wristCargoGrav = 0.041;

  public static final int wristHatchPos = -100;
  public static final double wristHatchMult = 0.3;
  public static final double wristHatchGrav = 0.041;

  public static final double wristSpeed = 0.5;
  public static final double wristGrav = 0.0002;

  //PID Wrist
  public static final double Pmult = 0.001;
  public static final double Imult = 0.001;

  public static final double Pweight = 0;
  public static final double Iweight = 1;

  //Intake
  public static final double intakeSpeed = 0.75;
  public static final double outtakeSpeed = -1;


  //a method for removing an element from an array
  public static float[] removeTheElement(float[] arr, int index){
    if (arr == null || index < 0 || index >= arr.length){
      return arr;
    }

    float[] anotherArray = new float[arr.length -1];

    for (int i = 0, k = 0; i < arr.length; i++) {
      if (i == index){
        continue;
      }

      anotherArray[k++] = arr[i];
    }

    return anotherArray;

  }

  

}

