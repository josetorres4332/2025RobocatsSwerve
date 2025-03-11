// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.command;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.climber.ClimberSubsystem;

public class ClimberCMD extends Command {

  private ClimberSubsystem climber = new ClimberSubsystem();
  DigitalInput bottomLimitSwitch = new DigitalInput(0);

  public ClimberCMD(ClimberSubsystem climber) {
    this.climber = climber;
    addRequirements(climber);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute(){
    if(bottomLimitSwitch.get())
    {
      climber.motorStop();
    }
    else
    {
      climber.motorForward();
    }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
