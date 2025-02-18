// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public class driveConstants{

    public static final int FRONT_RIGHT_MOTOR = 8;
    public static final int FRONT_LEFT_MOTOR = 7;
    public static final int BACK_RIGHT_MOTOR = 5;
    public static final int BACK_LEFT_MOTOR = 6;

  }

  public static class robotConstants{
    public static int MOVE_SPEED = 4; //4 is minimum to function
    public static double CAM_SPEED = 0.10;
    public static double TURN_SPEED = 0.25; //0.25 is maximum
  }

  public static class SwerveConstants {
    public static double turnThreshold = 0.2 //requires testing to find good value (non jittery but as low as possible)
    public static double Angle = 1 // value must be between 0,1 controls how fast wheels change angle
  }

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
