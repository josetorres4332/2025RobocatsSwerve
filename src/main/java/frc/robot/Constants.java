// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean constants. This
 * class should not be used for any other purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{ 

  // Joystick Deadband
  public static final double DEADBAND         = 0.1;
  public static final double RIGHT_Y_DEADBAND = 0.1;
  public static final double RIGHT_X_DEADBAND = 0.1;
  public static final double TURN_CONSTANT    = 6;
  public static final double Scalar = 1;

  //robot information 
  public static final double ROBOT_MASS = (148 - 20.3) * 0.453592; // 32lbs * kg per pound
  public static final Matter CHASSIS    = new Matter(new Translation3d(0, 0, Units.inchesToMeters(8)), ROBOT_MASS);
  public static final double LOOP_TIME  = 0.13; //s, 20ms + 110ms sprk max velocity lag
  public static final double MAX_SPEED  = Units.feetToMeters(14.5); // Maximum speed of the robot in meters per second, used to limit acceleration.

  public static final class DrivebaseConstants
  {

    // Hold time on motor brakes when disabled
    public static final double WHEEL_LOCK_TIME = 10; // seconds
  } 

  public static class OperatorConstants
  {

    
  }

  /************************************** JOYSTICK CONFIGURATION **************************************/
  /*                                                                                                  */
  /*                                           AXIS                                                   */
  /*__________________________________________________________________________________________________*/
  /*                                                                                                  */
  /*         Left X Stick LEFT/RIGHT = 0                     Left Y Stick UP/DOWN = 1                 */
  /*         Left Trigger = 2                                Right Trigger = 3                        */
  /*         Right X Stick LEFT/RIGHT = 4                    Right Y Stick LEFT/RIGHT = 5             */
  /*                                                                                                  */
  /*                                                                                                  */
  /*                                        BUTTONS                                                   */
  /*__________________________________________________________________________________________________*/
  /*                                                                                                  */
  /*         Button A = 0                                    Button B = 1                             */
  /*         Button X = 2                                    Button Y = 3                             */
  /*         Left Bumper = 4                                 Right Bumper = 5                         */
  /*         Pause Button = 6                                Menu Button = 7                          */
  /*                                                                                                  */
  /****************************************************************************************************/

   //Set driver controller here
   public static final class DriverControllerAssignments
   {
     public static final int driverControllerPort = 0;  //driver controller port
     public static final int forwardReverseAxis = 1;  //moves robot foward or reverse
     public static final int strafeLeftRight = 0;  //makes robot strafe left or right
     public static final int rotationLeftRight = 4;  //makes robot rotate left or right
 
   }

    //Set operator controller here
   public static final class OperatorControllerAssignments
   {

    public static final int operatorControllerPort = 0;  //driver controller port

   }
}
