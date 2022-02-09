package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.driveSubsystem;

public class LimelightAim extends Command {
  private final driveSubsystem drivesubsystem;
  private final double yspeed;
  private final double xspeed;
  private final double zrotation;
  private final boolean v;
  private final double x;
  private final double y;
  public LimelightAim(driveSubsystem drivesubsystem , double yspeed , double xspeed , double zrotation) {
    this.drivesubsystem = drivesubsystem;
    this.yspeed = yspeed;
    this.xspeed = xspeed;
    this.zrotation = zrotation;
    x = drivesubsystem.xvalue();
    y = drivesubsystem.yvalue();
    v = drivesubsystem.vvalue();
    requires(drivesubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    if(v==false){
      drivesubsystem.MecanumDriveaa(yspeed, xspeed, zrotation);
      if(x<0){
        drivesubsystem.MecanumDriveaa(yspeed, xspeed, zrotation);
      }
      if(x>0){
        drivesubsystem.MecanumDriveaa(yspeed * 0, - xspeed, zrotation * 0);
      }
      if(y<0){
        drivesubsystem.MecanumDriveaa(yspeed, xspeed * 0 , zrotation * 0);
      }
      if(y>0){
        drivesubsystem.MecanumDriveaa(- yspeed , xspeed * 0 , zrotation * 0);
      }
      if( x==0 && y==0){
        drivesubsystem.MecanumDriveaa(yspeed * 0, xspeed * 0, zrotation * 0);
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
