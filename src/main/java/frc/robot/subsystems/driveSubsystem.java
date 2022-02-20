package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class driveSubsystem extends Subsystem {
  WPI_TalonFX leftFront;
  WPI_TalonFX leftBack;
  WPI_TalonFX rightFront;
  WPI_TalonFX rightBack;


  MotorControllerGroup leftGroup ;
  MotorControllerGroup rightGroup ;

  MecanumDrive m_Drive ;


  double xspeed;
  double yspeed;
  double zrotation;

  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");
  NetworkTableEntry tv = table.getEntry("tv");

  double x;
  double y;
  double a;
  boolean v;
  


  @Override
  public void initDefaultCommand() {
    leftFront = new WPI_TalonFX(Constants.leftFront);
    leftFront.setInverted(false);
    leftBack = new WPI_TalonFX(Constants.leftBack);
    leftBack.setInverted(false);
    rightFront = new WPI_TalonFX(Constants.rightFront);
    rightFront.setInverted(true);
    rightBack = new WPI_TalonFX(Constants.rightBack);
    rightBack.setInverted(true);
  
    m_Drive = new MecanumDrive(leftFront,leftBack,rightFront,rightBack);   
  }
  
  public double xvalue(){
    return tx.getDouble(0.0);
  }
  public double yvalue(){
    return ty.getDouble(0.0);
  }
  public boolean vvalue(){
    return tv.getBoolean(false);
  }
  public double avalue(){
    return ta.getDouble(0.0);
  }

  public void periodic(){
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", a);
    SmartDashboard.putBoolean("LimelightV", v);
  }
  public void MecanumDriveaa(double yspeed,double xspeed,double zrotation){
    m_Drive.driveCartesian(yspeed, xspeed, zrotation);
    /*leftFront.set(yspeed + xspeed + zrotation);
    rightFront.set(yspeed - xspeed - zrotation);
    leftBack.set(yspeed - xspeed + zrotation);
    rightBack.set(yspeed + xspeed - zrotation);*/
  }
}
