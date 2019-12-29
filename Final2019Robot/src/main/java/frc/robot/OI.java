/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 OI.java is here to connect your Joystick.
 */
public class OI {
  Joystick driverStick = new Joystick(0);
  Button buttonA = new JoystickButton(driverStick, 1),
			buttonB = new JoystickButton(driverStick, 2),
			buttonX = new JoystickButton(driverStick, 3),
			buttonY = new JoystickButton(driverStick, 4),
			buttonLeftBumper = new JoystickButton(driverStick, 5),
			buttonRightBumper = new JoystickButton(driverStick, 6),
			buttonMenu = new JoystickButton(driverStick, 7),
      buttonStart = new JoystickButton(driverStick, 8),
      buttonLeftAxis = new JoystickButton(driverStick, 9),
      buttonRightAxis = new JoystickButton(driverStick, 10);

  public OI(){
    buttonA.whileHeld(new SetWristPosition());
    buttonLeftBumper.whileHeld(new Spit());
    buttonRightBumper.whileHeld(new Suck());
  }
  public Joystick getDriverStick() {
    return driverStick;
  }

}
