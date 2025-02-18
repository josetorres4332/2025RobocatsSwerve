// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.climber;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;

/** Add your docs here. */
public class ClimberIOSparkMax implements ClimberIO {
  private final int MOTOR_GEAR_RATIO = 405;

  private SparkMax motorClimbLead;
  private SparkMax motorClimbFollow;
  private RelativeEncoder motorRelativeEncoder;

  public ClimberIOSparkMax() {
    motorClimbLead = new SparkMax(13, MotorType.kBrushless);
    motorClimbFollow = new SparkMax(23, MotorType.kBrushless);
    SparkMaxConfig config = new SparkMaxConfig();
    SparkMaxConfig config2 = new SparkMaxConfig();

    config.inverted(true).idleMode(IdleMode.kBrake).smartCurrentLimit(40).voltageCompensation(12);
    config.encoder.positionConversionFactor(1/MOTOR_GEAR_RATIO).velocityConversionFactor(1000);
    config.closedLoop.feedbackSensor(FeedbackSensor.kPrimaryEncoder).pid(1.0, 0.0, 0.0);
    motorClimbLead.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    motorClimbLead.setCANTimeout(250);
    
    config2.follow(13, true);
    motorClimbFollow.configure(config2, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    //motor1.restoreFactoryDefaults();    
    //motor1.setSmartCurrentLimit(40);
    //motor1.enableVoltageCompensation(12);
    //motor1.setIdleMode(IdleMode.kBrake); 
    //motorRelativeEncoder = motor1.getEncoder();   
    //motorRelativeEncoder.setPositionConversionFactor(1. / MOTOR_GEAR_RATIO);
    //motor2.follow(motor1, true);
    //motor1.burnFlash();
    //motor2.burnFlash();
  }

  @Override
  public void updateInputs(ClimberIOInputs inputs) {
    inputs.motorAngle = motorRelativeEncoder.getPosition();
    inputs.motorVoltage = motorClimbLead.getBusVoltage();
    inputs.motorCurrent = motorClimbLead.getOutputCurrent();
  }

  @Override
  public void setMotorVoltage(double volts) {
    motorClimbLead.setVoltage(volts);
  }

  public void stopMotor() {
    motorClimbLead.stopMotor();
  }
}