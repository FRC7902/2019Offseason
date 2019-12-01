/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class WristCommand extends Command {
  public WristCommand() {
    requires(Robot.wristSubsystem);
    requires(Robot.driveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {//at the start...
    Robot.wristSubsystem.stopWrist();//stop the Wrist
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {//when the command is running
    //Robot.wristSubsystem.displayInfo();//2, 3, 4, 5, 6

    if(Robot.m_oi.getDriverStick().getRawButton(RobotMap.S)){// Start Button
      Robot.wristSubsystem.resetPos();
    }
    if(Robot.m_oi.getDriverStick().getRawButton(RobotMap.A)){//b button
      //Robot.wristSubsystem.detectPresetButton();//constantly detect if button is pressed
      Robot.wristSubsystem.setWristPositionPID(RobotMap.wristCargoPos);//for cargo
    }else{
      Robot.wristSubsystem.moveWristJoystick(Robot.m_oi.getDriverStick(), RobotMap.wristSpeed, RobotMap.wristGrav);//take the operator's stick and a speed of 1
    } 
    
    
  }
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {//when is it finished?
    return false;//never!
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {}

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {}
}
