/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;

/**
 * Pressure Subsystem 
 */
public class PressureSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private Compressor comp;

  public PressureSubsystem() {
    comp = new Compressor();
    // Turns on the limiter at 125psi
    comp.setClosedLoopControl(true);
  }

  // Turn on compressor
  public void start() {
    comp.start();
  }

  // Turn off compressor
  public void stop() {
    comp.stop();
  }

  /**
   * Toggle the state of the limiter (Please keep this on)
   * 
   * @param state
   * the state of the limiter
   */
  @Deprecated
  public void setLimiter(boolean state) {
    if(!state)
      stop();
    comp.setClosedLoopControl(state);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
