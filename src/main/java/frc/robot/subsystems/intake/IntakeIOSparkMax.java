package frc.robot.subsystems.intake;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkMax;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.RelativeEncoder;

public class IntakeIOSparkMax implements IntakeIO {
  TalonSRX algaeMotor1;
  TalonSRX algaeMotor2;
  TalonSRX coralIntake;
  SparkMax coralWrist;
  RelativeEncoder wristEncoder;

  public IntakeIOSparkMax() {
    // find actual motor IDs
    algaeMotor1 = new TalonSRX(21);
    algaeMotor2 = new TalonSRX(22);
    coralIntake = new TalonSRX(23);
    coralWrist = new SparkMax(16, MotorType.kBrushless); // dont have yet

    // ask about gear ratios for all motors
    wristEncoder = coralWrist.getEncoder();

    SparkMaxConfig configCoralWrist = new SparkMaxConfig();

    configCoralWrist.inverted(false).idleMode(IdleMode.kBrake).smartCurrentLimit(40);
    configCoralWrist.closedLoop.feedbackSensor(FeedbackSensor.kPrimaryEncoder).pid(0.55, 0.0, 0.0);
    coralWrist.configure(configCoralWrist, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    coralWrist.setCANTimeout(250);

    //coralWrist.setSmartCurrentLimit(40);
    //coralWrist.getPIDController().setP(0.55);
    //coralWrist.getPIDController().setI(0);
    //coralWrist.getPIDController().setD(0.0);
    //coralWrist.getPIDController().setFF(0.00375);
    //coralWrist.setIdleMode(IdleMode.kBrake);
    //coralWrist.burnFlash();
  }

  @Override
  public void updateInputs(IntakeIOInputs inputs) {
    inputs.coralWristCurrent = coralWrist.getOutputCurrent();
    inputs.coralWristVelocity = coralWrist.getEncoder().getVelocity();
    inputs.coralWristPosition = coralWrist.getEncoder().getPosition();
  }

  @Override
  public void setAlgaeVoltage(double voltage) {
    algaeMotor1.set(ControlMode.PercentOutput, voltage);;
    algaeMotor2.set(ControlMode.PercentOutput, -voltage);
  }

  @Override
  public void setCoralIntakeVoltage(double voltage) {
    coralIntake.set(ControlMode.PercentOutput, voltage);
  }

  @Override
  public void adjustAngle(double angleRadians) {
    coralWrist.getEncoder().setPosition(coralWrist.getEncoder().getPosition() + angleRadians);
  }

  @Override
  public void wristAngle(double position) {
    // System.out.println("Wrist position: " + getWristPosition());
    coralWrist.getClosedLoopController().setReference(position, SparkMax.ControlType.kPosition);
  }

  @Override
  public double getWristPosition() {
    return wristEncoder.getPosition();
  }

  @Override
  public void setWristVoltage(double voltage) {
    // System.out.println("Wrist position: " + getWristPosition());
    coralWrist.set(voltage);
  }
}
