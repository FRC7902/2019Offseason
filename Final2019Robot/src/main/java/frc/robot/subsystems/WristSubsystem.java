/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


//Imports
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;



public class WristSubsystem extends Subsystem {
  //Set up 2 motors
  WPI_TalonSRX myTalon = new WPI_TalonSRX(RobotMap.wristMotor);
  WPI_TalonSRX myTalon2 = new WPI_TalonSRX(RobotMap.wristMotor2);

  public WristSubsystem() {
    myTalon2.setInverted(false);
    myTalon.setInverted(false);
    
  }
  
  int startPos = 0;
  int top = -500;

  //Satellite
  public double counterGrav = 0;

  public void moveWristJoystick(Joystick joystick, double speed, double gravMult){//the method on how to move the wrist
    //Move the motors based on joystick input, speed and gravity
    myTalon.set(ControlMode.PercentOutput, (joystick.getRawAxis(3)-joystick.getRawAxis(2))*speed+ counterGrav(gravMult));//the second joystick's Y-axis is the motor
    myTalon2.set(ControlMode.PercentOutput, (joystick.getRawAxis(3)-joystick.getRawAxis(2))*speed+counterGrav(gravMult));
    SmartDashboard.putNumber("Joystick Power" , (joystick.getRawAxis(3)-joystick.getRawAxis(2))*speed+ counterGrav(gravMult));
  }

  public void moveWrist(double power){
    myTalon.set(power);
    myTalon2.set(power);
  }

  public void stopWrist(){//disable the wrist
    myTalon.disable();
  }

  public int getWristPosition(){//get the position
    return (myTalon.getSelectedSensorPosition() % 4096)-startPos;
  }

  public void resetPos(){//Reset wristPos to 0
    startPos += getWristPosition();

  }

  //An attempt to calculate gravity
  public double counterGrav(double mult){
    return (top - getWristPosition())*mult;
  }

  public void displayInfo(){

    SmartDashboard.putNumber("Wrist Position", getWristPosition());
    SmartDashboard.putBoolean("Preset 1", Robot.m_oi.getDriverStick().getRawButton(4));
    SmartDashboard.putNumber("Error", error);
    SmartDashboard.putNumber("Pout", Pout);
    SmartDashboard.putNumber("Output", output);
    SmartDashboard.putNumber("Joystick Response:", Robot.m_oi.getDriverStick().getRawAxis(1));


  }
  

  public void setWristPosition(int desPosition, double speed, double grav){//to move the desired position

    //FOR A BACKUP
    int lim = 256; 
    if(getWristPosition() > desPosition){//if the arm is too forward, move it back
          
      int diff = desPosition - getWristPosition();//calculate the difference
      if(diff>lim){//if difference is outside the limit
        myTalon.set(ControlMode.PercentOutput, -1*speed+grav);
        myTalon2.set(ControlMode.PercentOutput, -1*speed+grav);
      }else{ //if difference is inside the limit
        myTalon.set(ControlMode.PercentOutput, (diff/lim)*speed+grav);
        myTalon2.set(ControlMode.PercentOutput, (diff/lim)*speed+grav);
      }
    }else if(getWristPosition() < desPosition){//if the arm is too far back, move it forward
      int diff = desPosition - getWristPosition(); //calculate the difference
      if(diff>lim){//if difference is outside the limit
        myTalon.set(ControlMode.PercentOutput, 1*speed+grav);
        myTalon2.set(ControlMode.PercentOutput, 1*speed+grav);
      }else{//if difference is inside the limit
        myTalon.set(ControlMode.PercentOutput, (diff/lim)*speed+grav);//otherwise move it forward
        myTalon2.set(ControlMode.PercentOutput, (diff/lim)*speed+grav);
      }
    }
  }
  
  double sum = 0;
  int error=0;
  double Pout;
  double output;
  public void setWristPositionPID(int desPosition){
    
    error = getWristPosition() - desPosition;
    System.out.println(error);
    //Present
    Pout = RobotMap.Pmult * error;

    //Integral
    sum = RobotMap.Imult * error;

    output = Pout*RobotMap.Pweight + sum*RobotMap.Iweight;

    myTalon.set(ControlMode.PercentOutput, output);
    myTalon2.set(ControlMode.PercentOutput, output);
    
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
