package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.driveSubsystem;

public class LimelightAim extends Command {
  private final driveSubsystem drivesubsystem;
  private final double yspeed;
  private final double xspeed;
  private final double zrotation;

  public LimelightAim(driveSubsystem drivesubsystem , double yspeed , double xspeed , double zrotation) {
    this.drivesubsystem = drivesubsystem;
    this.yspeed = yspeed;
    this.xspeed = xspeed;
    this.zrotation = zrotation;
    requires(drivesubsystem);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    drivesubsystem.LimelightAim(yspeed, xspeed, zrotation);
    
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {}

  @Override
  protected void interrupted() {}
}
