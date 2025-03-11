// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.climber;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {

  private static final TalonSRX climbMotor = new TalonSRX(Constants.climberMotorID);

    public ClimberSubsystem(){

        climbMotor.setNeutralMode(NeutralMode.Brake);

    }

    @Override
    public void periodic(){
        
    }

    public void motorStop(){
        climbMotor.set(ControlMode.PercentOutput, 0);
    }
    
    public void motorForward(){
        climbMotor.set(ControlMode.PercentOutput, 0.25);
    }

}
