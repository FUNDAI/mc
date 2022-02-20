package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.LimelightAim;
import frc.robot.commands.Mdrive;
import frc.robot.subsystems.ShootSubsystem;
import frc.robot.subsystems.driveSubsystem;

public class RobotContainer {
  private final driveSubsystem drivesubsystem = new driveSubsystem();
  private final ShootSubsystem shootSubsystem = new ShootSubsystem();
  public static Joystick js1 = new Joystick(Constants.js1);

  public RobotContainer() {
    configureButtonBindings();
    drivesubsystem.setDefaultCommand(new Mdrive(drivesubsystem, 
    () -> js1.getRawAxis(Constants.leftStick_Y), 
    () -> js1.getRawAxis(Constants.leftStick_X), 
    () -> js1.getRawAxis(Constants.rightStick_X)));
    drivesubsystem.setDefaultCommand(new LimelightAim(drivesubsystem,shootSubsystem,0,0,0,0));
  }

  private void configureButtonBindings() {
    new JoystickButton(js1, Constants.Btn_A)
    .whileHeld((Command) new LimelightAim(drivesubsystem,shootSubsystem,0.4,0.4,0.4,0.4));
    
  }
}
