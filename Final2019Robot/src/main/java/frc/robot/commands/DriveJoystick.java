/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


//Imports
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveJoystick extends Command {
  public DriveJoystick() {
    //requires the subsystem it is depended on
    requires (Robot.driveSubsystem);
  }
  
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.driveSubsystem.stop();//stops the motors (resets them)
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Robot.driveSubsystem.driveJoystick(Robot.m_oi.getDriverStick(), RobotMap.driveFBSpeed, RobotMap.driveTurnSpeed);//drive from the joystick at 0.5 speed
    //Robot.driveSubsystem.displayInfo();
    Robot.driveSubsystem.drive((-Robot.m_oi.getDriverStick().getRawAxis(1)*RobotMap.driveFBSpeed - Robot.m_oi.getDriverStick().getRawAxis(4)*RobotMap.driveTurnSpeed)*RobotMap.driveSpeedLimiter,  
    (-Robot.m_oi.getDriverStick().getRawAxis(1)*RobotMap.driveFBSpeed + Robot.m_oi.getDriverStick().getRawAxis(4)*RobotMap.driveTurnSpeed)*RobotMap.driveSpeedLimiter);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false; //never finished
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveSubsystem.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
