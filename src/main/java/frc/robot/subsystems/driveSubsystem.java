// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class driveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX leftFront;
  WPI_TalonSRX leftBack;
  WPI_TalonSRX rightFront;
  WPI_TalonSRX rightBack;


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
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    leftFront = new WPI_TalonSRX(Constants.leftFront);
    leftFront.setInverted(false);
    leftBack = new WPI_TalonSRX(Constants.leftBack);
    leftBack.setInverted(false);
    rightFront = new WPI_TalonSRX(Constants.rightFront);
    rightFront.setInverted(true);
    rightBack = new WPI_TalonSRX(Constants.rightBack);
    rightBack.setInverted(true);

    x = tx.getDouble(0.0);
    y = ty.getDouble(0.0);
    a = ta.getDouble(0.0);
    v = tv.getBoolean(false);

    //m_Drive = new MecanumDrive(leftFront,leftBack,rightFront,rightBack);
    
  }
  public void periodic(){
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", a);
    SmartDashboard.putBoolean("LimelightV", v);
  }
  public void MecanumDriveaa(double yspeed,double xspeed,double zrotation){
   // m_Drive.driveCartesian(yspeed, xspeed, zrotation);
    leftFront.set(yspeed + xspeed + zrotation);
    rightFront.set(yspeed - xspeed - zrotation);
    leftBack.set(yspeed - xspeed + zrotation);
    rightBack.set(yspeed + xspeed - zrotation);
  }
  public void LimelightAim(double yspeed , double xspeed , double zrotation){
    if(v==false){
      m_Drive.driveCartesian(yspeed * 0, xspeed * 0, zrotation);
      if(x<0){
        m_Drive.driveCartesian(yspeed * 0,xspeed,zrotation * 0);
      }
      if(x>0){
        m_Drive.driveCartesian(yspeed * 0, - xspeed, zrotation * 0);
      }
      if(y<0){
        m_Drive.driveCartesian(yspeed, xspeed * 0 , zrotation * 0);
      }
      if(y>0){
        m_Drive.driveCartesian(- yspeed , xspeed * 0 , zrotation * 0);
      }
      if( x==0 && y==0){
        m_Drive.driveCartesian(yspeed * 0, xspeed * 0, zrotation * 0);
      }
    } 
    else{
      m_Drive.driveCartesian(yspeed * 0, xspeed * 0, zrotation * 0);
    }
  }
}
