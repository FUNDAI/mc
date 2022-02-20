// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.command.Subsystem;


public class ShootSubsystem extends Subsystem {
  WPI_TalonFX shooter;

  @Override
  public void initDefaultCommand() {
    shooter = new WPI_TalonFX(10);
    shooter.setInverted(true);
  }
  public void shooting(double shootspeed){
    shooter.set(shootspeed);
  }
}
