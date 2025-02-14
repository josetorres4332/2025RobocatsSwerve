package frc.robot;

//import classes
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;

public class RobotContainer
{
  //Driver Xbox Controller
  final CommandXboxController driverXbox = new CommandXboxController(Constants.DriverControllerAssignments.driverControllerPort);

  //Operator Generic Controller
  final CommandXboxController operatorXbox = new CommandXboxController(Constants.OperatorControllerAssignments.operatorControllerPort);

  // The robot's subsystems and commands are defined here...
  //Swerve Subsystem
  private final SwerveSubsystem drivebase  = new SwerveSubsystem();

 
  //The container for the robot. Contains subsystems, OI devices, and commands.
  public RobotContainer()
  {
    // Configure the trigger bindings
    configureBindings();

    drivebase.setDefaultCommand(driveFieldOrientedAngularVelocity); //makes Field Oriented drive the default command

  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary predicate, or via the
   * named factories in {@link edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller PS4}
   * controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight joysticks}.
   */
  private void configureBindings()
  {

  }

  //Applies deadbands to driver joystick inputs before sending them to the robot movement
  Command driveFieldOrientedAngularVelocity = drivebase.driveCommand(
                          () -> -(MathUtil.applyDeadband(driverXbox.getRawAxis(Constants.DriverControllerAssignments.strafeLeftRight), Constants.RIGHT_X_DEADBAND)),
                          () -> -(MathUtil.applyDeadband(driverXbox.getRawAxis(Constants.DriverControllerAssignments.forwardReverseAxis), Constants.RIGHT_Y_DEADBAND)), 
                          () -> -(driverXbox.getRawAxis(Constants.DriverControllerAssignments.rotationLeftRight)) * Constants.TURN_CONSTANT);   

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand()
  {

    return null;

  }

}
