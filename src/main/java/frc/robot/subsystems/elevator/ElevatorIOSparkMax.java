package frc.robot.subsystems.elevator;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;

public class ElevatorIOSparkMax implements ElevatorIO {
  private final SparkMax leadMotor;
  private final SparkMax followerMotor;
  private final RelativeEncoder encoder;

  // Constructor
  public ElevatorIOSparkMax() {
    // Initialize the CANSparkMax motors for main and follower
    leadMotor = new SparkMax(14, MotorType.kBrushless);
    followerMotor = new SparkMax(24, MotorType.kBrushless);

    SparkMaxConfig configLead = new SparkMaxConfig();
    SparkMaxConfig configFollow = new SparkMaxConfig();

    configLead.inverted(true).idleMode(IdleMode.kBrake).smartCurrentLimit(40).voltageCompensation(12);
    encoder = leadMotor.getEncoder();
    configLead.closedLoop.feedbackSensor(FeedbackSensor.kPrimaryEncoder).pid(0.027, 0.0, 0.0085);
    leadMotor.configure(configLead, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    leadMotor.setCANTimeout(250);
    
    configFollow.follow(14, true);
    configFollow.inverted(true).idleMode(IdleMode.kBrake).smartCurrentLimit(40).voltageCompensation(12);
    followerMotor.configure(configFollow, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    //followerMotor.setInverted(true);
    //followerMotor.follow(leadMotor, true);
    //leadMotor.getPIDController().setP(0.027);
    //leadMotor.getPIDController().setI(0);
    //leadMotor.getPIDController().setD(0);
    //leadMotor.getPIDController().setFF(0.0085);
    //leadMotor.setIdleMode(IdleMode.kBrake);
    //followerMotor.setIdleMode(IdleMode.kBrake);
    //leadMotor.burnFlash();
    //followerMotor.burnFlash();
  }

  @Override
  public void set(double voltage) {
    // Set the power to the main motor
    leadMotor.set(voltage);
  }

  @Override
  public double getPosition() {
    // Get the position from the encoder
    return encoder.getPosition();
  }

  @Override
  public double getVelocity() {
    // Get the velocity from the encoder
    return encoder.getVelocity();
  }

  @Override
  public void resetPosition() {
    // Reset the encoder to the specified position
    encoder.setPosition(0);
  }

  @Override
  public void setPosition(double position) {
    leadMotor.getClosedLoopController().setReference(position, ControlType.kPosition);
  }

  @Override
  public void stop() {
    leadMotor.setVoltage(0);
  }
}
