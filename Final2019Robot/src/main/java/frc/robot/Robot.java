/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/





//Imports
package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//Commands
import frc.robot.commands.TeleOp;
import frc.robot.subsystems.*;
import frc.robot.commands.Autonomous;
import frc.robot.commands.DisplayInfo;

public class Robot extends TimedRobot {

  public static DriveSubsystem driveSubsystem = new DriveSubsystem();
  public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public static WristSubsystem wristSubsystem = new WristSubsystem();
  public static SolenoidSubsystem solenoidSubsystem = new SolenoidSubsystem();
  public static RegulatorSubsystem regulatorSubsystem = new RegulatorSubsystem();
  public static OI m_oi;

  Command m_autonomousCommand;
  
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  public static TeleOp teleOp = new TeleOp();
  public static Autonomous autonomous = new Autonomous();
  public static DisplayInfo displayInfo = new DisplayInfo();
  @Override
  public void robotInit() {
    m_oi = new OI();
    
    m_chooser.setDefaultOption("Auto1", new Autonomous());
    SmartDashboard.putData("Auto mode Selector", m_chooser);
    //CameraServer.getInstance().startAutomaticCapture();

    
  }

  @Override
  public void robotPeriodic() {
    //displayInfo.start();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }


  @Override
  public void autonomousInit() {
    //m_autonomousCommand = m_chooser.getSelected();

    //in autonomous, we need to run autonomous
    //autonomous.start();
    
    // schedule the autonomous command (example)
    // if (m_autonomousCommand != null) {
    //   m_autonomousCommand.start();
    // }

    //schedule the autonomous command (example)
    // if (autonomous != null) {
    //   autonomous.start();
    // }
  }

  @Override
  public void autonomousPeriodic() {
    //run the scheduler which goes through all the commands in the autonomous command group
    //Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    //cancel autonomous command group 
    //autonomous.cancel();
    teleOp.start();//run the main teleOp command group
    // if (m_autonomousCommand != null) {
    //   m_autonomousCommand.cancel();
    // }
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}
