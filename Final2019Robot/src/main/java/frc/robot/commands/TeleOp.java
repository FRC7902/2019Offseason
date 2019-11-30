/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TeleOp extends CommandGroup {
  
  public TeleOp() {
    //these will all run at the same time
    addParallel(new DriveCommand());
    addParallel(new WristCommand());
    addParallel(new IntakeCommand());
   // addParallel(new SolenoidCommand());
  }
}
