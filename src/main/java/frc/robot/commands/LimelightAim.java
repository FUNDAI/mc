package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.ShootSubsystem;
import frc.robot.subsystems.driveSubsystem;

public class LimelightAim extends Command {
  private final driveSubsystem drivesubsystem;
  private final ShootSubsystem shootSubsystem;
  private final double yspeed;
  private final double xspeed;
  private final double zrotation;
  private final double shootSpeed;
  private final boolean v;
  private final double x;
  private final double y;
  private final double a;
  private final double xError; 
  private final double yError;
  private final double aError;
  
  public LimelightAim(driveSubsystem drivesubsystem , ShootSubsystem shootSubsystem ,double yspeed , double xspeed , double zrotation , double shootSpeed) {
    this.drivesubsystem = drivesubsystem;
    this.yspeed = yspeed;
    this.xspeed = xspeed;
    this.zrotation = zrotation;
    this.shootSpeed=shootSpeed;
    this.shootSubsystem = shootSubsystem;
    x = drivesubsystem.xvalue();
    y = drivesubsystem.yvalue();
    v = drivesubsystem.vvalue();
    a = drivesubsystem.avalue();
    xError = Math.abs(x);
    yError = Math.abs(y);
    aError = a / 5;
    requires(drivesubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    //這裡是我用自己的想法寫的，很爛，別鞭
    if(v==false){
      drivesubsystem.MecanumDriveaa(yspeed * 0, xspeed * 0, zrotation);
      if(x < -0.5){
        drivesubsystem.MecanumDriveaa(yspeed * 0, xspeed * xError, zrotation * 0);
      }
      if(x > 0.5){
        drivesubsystem.MecanumDriveaa(yspeed * 0, - xspeed * xError, zrotation * 0);
      }
      if(y < -0.5){
        drivesubsystem.MecanumDriveaa(yspeed * yError, xspeed * 0 , zrotation * 0);
      }
      if( y> 0.5){
        drivesubsystem.MecanumDriveaa(- yspeed * yError, xspeed * 0 , zrotation * 0);
      }
      if(x >-0.5 && x < 0.5 && y > 0.5 && y < 0.5){
        drivesubsystem.MecanumDriveaa(yspeed * 0, xspeed * 0, zrotation * 0);
        shootSubsystem.shooting(shootSpeed * aError);

      }
    } 
    
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end() {}

  @Override
  public void interrupted() {}
}
