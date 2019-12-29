/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Autonomous() {
    addSequential(new DriveTimed(1, 0.5, 0.5));
    addSequential(new SetWristPositionCon());
    addSequential(new IntakeTimed(1, -1));



    // addParallel(new WristAutoCommand(2.0, -0.5)); //move wrist down
    // addParallel(new IntakeAutoCommand(2.0, -0.5)); //intake ball
    // addSequential(new DriveAutoCommand(2.0, 0.5, 0.5)); //drive forward

    
    // addSequential(new DriveAutoCommand(1.0, -0.5, 0.5)); //turn left

    // addParallel(new WristAutoCommand(2.0, 0.5)); //move wrist up
    // addParallel(new IntakeAutoCommand(2.0, 0.5)); //eject ball out
    // addSequential(new DriveAutoCommand(2.0, 0.5, 0.5)); //drive forward


    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}
