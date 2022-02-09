package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.driveSubsystem;

public class Mdrive extends Command {
  private final driveSubsystem drivesubsystem;
  private Supplier<Double> ySpeedSupplier;
  private Supplier<Double> xSpeedSupplier;
  private Supplier<Double> zRotationSupplier; 
  
  public Mdrive(driveSubsystem drivesubsystem,Supplier<Double> ySpeedSupplier, Supplier<Double> xSpeedSupplier, Supplier<Double> zRotationSupplier) {
    this.drivesubsystem = drivesubsystem;
    this.xSpeedSupplier = xSpeedSupplier;
    this.ySpeedSupplier = ySpeedSupplier;
    this.zRotationSupplier = zRotationSupplier;
    requires(drivesubsystem);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    double ySpeed = ySpeedSupplier.get() * 0.5;
    double xSpeed = xSpeedSupplier.get() * 0.5;
    double zRotation = zRotationSupplier.get() * 0.5;

    drivesubsystem.MecanumDriveaa(ySpeed,xSpeed,zRotation);
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
