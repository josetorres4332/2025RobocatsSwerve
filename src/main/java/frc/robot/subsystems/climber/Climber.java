// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.climber;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {

  private final ClimberIO io;

  /** Creates a new Climber. */
  public Climber(ClimberIO io) {
    this.io = io;
  }

  public void setMotorVoltage(double volts) {
    io.setMotorVoltage(volts);
  }

  public void stopMotor() {
    io.stopMotor();
  }
}