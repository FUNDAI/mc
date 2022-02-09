package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.LimelightAim;
//import frc.robot.commands.LimelightAim;
import frc.robot.commands.Mdrive;
import frc.robot.subsystems.driveSubsystem;

public class RobotContainer {
  private final driveSubsystem drivesubsystem = new driveSubsystem();
  public static Joystick js1 = new Joystick(Constants.js1);

  public RobotContainer() {
    drivesubsystem.setDefaultCommand(new Mdrive(drivesubsystem, 
    () -> js1.getRawAxis(Constants.leftStick_Y), 
    () -> js1.getRawAxis(Constants.leftStick_X), 
    () -> js1.getRawAxis(Constants.rightStick_X)));
    drivesubsystem.setDefaultCommand(new LimelightAim(drivesubsystem,0,0,0));
    
    configureButtonBindings();
    
  }

  private void configureButtonBindings() {
    new JoystickButton(js1, Constants.Btn_A)
    .whenHeld( (Command) new LimelightAim(drivesubsystem, 0.4, 0.4, 0.4));
    //這裡我不知道怎弄，按照官方用法會有錯誤，用Quick fixed 的add argunment 就好了，他加了前面的(Command)
  }
}
