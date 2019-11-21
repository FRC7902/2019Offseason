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

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SolenoidCommand extends Command {
  public SolenoidCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires (Robot.solenoidSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    startChecker();
    Robot.solenoidSubsystem.closeValve();
  }

  protected void startChecker() {
    Thread checker = new Thread(() -> {
      // Get pass state
      boolean oldState = Robot.solenoidSubsystem.getState();
      while(!isFinished()) {
        if(oldState != Robot.solenoidSubsystem.getState())
          SmartDashboard.putString("Solenoid State", (Robot.solenoidSubsystem.getState()? "Open" : "Close"));
      }
    });
    checker.run();
  }

  // Called repeatedly when this Command is scheduled to run
  // Find new button to control Solenoid
  @Override
  protected void execute() {
    if(Robot.m_oi.getDriverStick().getRawButton(RobotMap.B)){
      //Robot.solenoidSubsystem.closeValve();
      Robot.solenoidSubsystem.openFrontValve();
    }
    if(Robot.m_oi.getDriverStick().getRawButton(RobotMap.X)){
      //Robot.solenoidSubsystem.closeValve();
      Robot.solenoidSubsystem.openBackValve();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.solenoidSubsystem.closeValve();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
