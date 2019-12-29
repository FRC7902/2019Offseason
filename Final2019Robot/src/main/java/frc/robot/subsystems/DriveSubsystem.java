/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


//Imports
package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveSubsystem extends Subsystem {

  // make a new Victor for each of the motors
  public WPI_VictorSPX frontRight = new WPI_VictorSPX(RobotMap.frontRight);
  public WPI_VictorSPX frontLeft = new WPI_VictorSPX(RobotMap.frontLeft);
  public WPI_VictorSPX backRight = new WPI_VictorSPX(RobotMap.backRight);
  public WPI_VictorSPX backLeft = new WPI_VictorSPX(RobotMap.backLeft);

  // group these motors as speedControllers
  SpeedController leftSide = new SpeedControllerGroup(frontLeft, backLeft);
  SpeedController rightSide = new SpeedControllerGroup(frontRight, backRight);
  
  //Satellites
  // public boolean microDriveFBButtonPressed = false;
  // public boolean microDriveTurnButtonPressed = false;

  public DifferentialDrive drive;

  // the contructor class
  public DriveSubsystem() {
    // if a motor is inverted, switch the boolean
    frontRight.setInverted(false);
    frontLeft.setInverted(true);
    backRight.setInverted(false);
    backLeft.setInverted(true);
    // drive is a new DifferentialDrive
    drive = new DifferentialDrive(leftSide, rightSide);
  }

  // this method is for Joystick driving
  public void driveJoystick(Joystick joystick, double fSpeed, double tSpeed) {
    //set defaults
    double ySpeed = fSpeed;
    double turnSpeed = tSpeed;
    double speedLimiter = RobotMap.driveSpeedLimiter; //A value in between 0 and 1 for max speed limit
    
    
    leftSide.set((-joystick.getRawAxis(1)*ySpeed - joystick.getRawAxis(4)*turnSpeed)*speedLimiter);
    rightSide.set((-joystick.getRawAxis(1)*ySpeed + joystick.getRawAxis(4)*turnSpeed)*speedLimiter);
  }

  public void drive(double speedLeft, double speedRight){
    leftSide.set(speedLeft);
    rightSide.set(speedRight);
  }

  public void displayInfo(){
    SmartDashboard.putNumber("Joystick Acceleration: ", Robot.m_oi.getDriverStick().getRawAxis(1));
    SmartDashboard.putNumber("Joystick Turn: ", Robot.m_oi.getDriverStick().getRawAxis(4));
    SmartDashboard.putNumber("Left Drive Speed", leftSide.get());
    SmartDashboard.putNumber("Right Drive Speed", rightSide.get());
  }


  // this will end the motor
  public void stop() {
    drive.stopMotor();
  }

  @Override
  protected void initDefaultCommand() {}
}
