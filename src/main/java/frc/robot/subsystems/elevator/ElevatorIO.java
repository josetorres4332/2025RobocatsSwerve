package frc.robot.subsystems.elevator;

public interface ElevatorIO {

  // Sets the power to the elevator motor
  public default void set(double voltage) {}

  // Gets the current position of the elevator (in encoder units)
  public default double getPosition() {
    return 0;
  }

  public default void setPosition(double position) {}

  // Gets the current velocity of the elevator
  public default double getVelocity() {
    return 0;
  }

  // Resets the encoder position to a specific value
  public default void resetPosition() {}

  public default void stop() {}
}
