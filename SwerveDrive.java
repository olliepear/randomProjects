package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.Constants.robotConstants;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SwerveDrive extends CommandBase {
    public SwerveDrive() {
        addRequirements(RobotContainer.DRIVE_TRAIN);
    }

    public void initialize() {

        RobotContainer.DRIVE_TRAIN.FRMsetV(0);
        RobotContainer.DRIVE_TRAIN.FLMsetV(0);
        RobotContainer.DRIVE_TRAIN.BRMsetV(0);
        RobotContainer.DRIVE_TRAIN.BLMsetV(0);

        RobotContainer.DRIVE_TRAIN.FRMsetA(0);
        RobotContainer.DRIVE_TRAIN.FLMsetA(0);
        RobotContainer.DRIVE_TRAIN.BRMsetA(0);
        RobotContainer.DRIVE_TRAIN.BLMsetA(0);

    }

    

    public void execute() {
        double driverAxisX = RobotContainer.CONTROLLER_JOYSTICK.getRawAxis(0);
        double driverAxisY = RobotContainer.CONTROLLER_JOYSTICK.getRawAxis(1);
        double driverAxisZ = RobotContainer.CONTROLLER_JOYSTICK.getRawAxis(2);

        //needs testing but should work as swerve drive math

        RobotContainer.DRIVE_TRAIN.FRMsetV(Math.sqrt((driverAxisX+driverAxisZ) * (driverAxisX+driverAxisZ) + (driverAxisY-driverAxisZ) * (driverAxisY-driverAxisZ))/Constants.robotConstants.MOVE_SPEED);
        RobotContainer.DRIVE_TRAIN.FLMsetV(Math.sqrt((driverAxisX+driverAxisZ) * (driverAxisX+driverAxisZ) + (driverAxisY+driverAxisZ) * (driverAxisY+driverAxisZ))/Constants.robotConstants.MOVE_SPEED);
        RobotContainer.DRIVE_TRAIN.BRMsetV(Math.sqrt((driverAxisX-driverAxisZ) * (driverAxisX-driverAxisZ) + (driverAxisY-driverAxisZ) * (driverAxisY-driverAxisZ))/Constants.robotConstants.MOVE_SPEED);
        RobotContainer.DRIVE_TRAIN.BLMsetV(Math.sqrt((driverAxisX-driverAxisZ) * (driverAxisX-driverAxisZ) + (driverAxisY+driverAxisZ) * (driverAxisY+driverAxisZ))/Constants.robotConstants.MOVE_SPEED);

        RobotContainer.DRIVE_TRAIN.FRMsetA(Constants.robotConstants.TURN_SPEED * Math.atan((driverAxisX+driverAxisZ)/(driverAxisY-driverAxisZ)));
        RobotContainer.DRIVE_TRAIN.FLMsetA(Constants.robotConstants.TURN_SPEED * Math.atan((driverAxisX+driverAxisZ)/(driverAxisY+driverAxisZ)));
        RobotContainer.DRIVE_TRAIN.BRMsetA(Constants.robotConstants.TURN_SPEED * Math.atan((driverAxisX-driverAxisZ)/(driverAxisY-driverAxisZ)));
        RobotContainer.DRIVE_TRAIN.BLMsetA(Constants.robotConstants.TURN_SPEED * Math.atan((driverAxisX-driverAxisZ)/(driverAxisY+driverAxisZ)));

    }

    public void end(boolean interrupted) {
        initialize();
    }

    public boolean isFinished() {
        return false;
    }
}
