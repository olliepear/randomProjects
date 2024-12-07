package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX; !!!OLD DO NOT USE WITH 2023 MECH!!! (Might change later)
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    
    VictorSPX frontRightMotor = new VictorSPX(Constants.driveConstants.FRONT_RIGHT_MOTOR);
    VictorSPX frontLeftMotor = new VictorSPX(Constants.driveConstants.FRONT_LEFT_MOTOR);

    VictorSPX backRightMotor = new VictorSPX(Constants.driveConstants.BACK_RIGHT_MOTOR);
    VictorSPX backLeftMotor = new VictorSPX(Constants.driveConstants.BACK_LEFT_MOTOR);

    public DriveTrain() {
        
        frontRightMotor.setInverted(false);
        frontLeftMotor.setInverted(true);
        
        backRightMotor.setInverted(false);
        backLeftMotor.setInverted(true);

    }

    public void FRMsetV(double speed) {
        if (speed >= -1 && speed <= 1)
        {
            frontRightMotor.set(ControlMode.PercentOutput, speed);
        }
         else
        {
            frontRightMotor.set(ControlMode.PercentOutput, 0);
        }
    }

    public void FLMsetV(double speed) {
        if (speed >= -1 && speed <= 1)
        {
            frontLeftMotor.set(ControlMode.PercentOutput, speed);
        }
         else
        {
            frontLeftMotor.set(ControlMode.PercentOutput, 0);
        }
    }

    public void BRMsetV(double speed) {
        if (speed >= -1 && speed <= 1)
        {
            backRightMotor.set(ControlMode.PercentOutput, speed);
        }
         else
        {
            backRightMotor.set(ControlMode.PercentOutput, 0);
        }
    }

    public void BLMsetV(double speed) {
        if (speed >= -1 && speed <= 1)
        {
            backLeftMotor.set(ControlMode.PercentOutput, speed);
        }
        else
        {
           backLeftMotor.set(ControlMode.PercentOutput, 0);
        }
    }

    // input angle measure variables and find out how to measure them

    public void FRMsetA(double angle) {
        var angleMeasure = 0;
        if (angle >= (RobotContainer.Angle.getRawAngle(angleMeasure) + Constants.SwerveConstants.turnThreshold) ){
            frontRightMotorAngle.set(ControlMode.PercentOutput, Constants.SwerveConstants.Angle);
        }
        if (angle <= (RobotContainer.Angle.getRawAngle(angleMeasure) - Constants.SwerveConstants.turnThreshold) ){
            frontRightMotorAngle.set(ControlMode.PercentOutput, -Constants.SwerveConstants.Angle);
        }
        else {
            frontRightMotorAngle.set(ControlMode.PercentOutput, 0);
        }
    }       

    public void FLMsetA(double angle) {
        var angleMeasure = 1;
        if (angle >= (RobotContainer.Angle.getRawAngle(angleMeasure) + Constants.SwerveConstants.turnThreshold) ){
            frontLeftMotorAngle.set(ControlMode.PercentOutput, Constants.SwerveConstants.Angle);
        }
        if (angle <= (RobotContainer.Angle.getRawAngle(angleMeasure) - Constants.SwerveConstants.turnThreshold) ){
            frontLeftMotorAngle.set(ControlMode.PercentOutput, -Constants.SwerveConstants.Angle);
        }
        else {
            frontLeftMotorAngle.set(ControlMode.PercentOutput, 0);
        }
    }       
    public void BRMsetA(double angle) {
        var angleMeasure = 2;
        if (angle >= (RobotContainer.Angle.getRawAngle(angleMeasure) + Constants.SwerveConstants.turnThreshold) ){
            backRightMotorMotorAngle.set(ControlMode.PercentOutput, Constants.SwerveConstants.Angle);
        }
        if (angle <= (RobotContainer.Angle.getRawAngle(angleMeasure) - Constants.SwerveConstants.turnThreshold) ){
            backRightMotorAngle.set(ControlMode.PercentOutput, -Constants.SwerveConstants.Angle);
        }
        else {
            backRightMotorAngle.set(ControlMode.PercentOutput, 0);
        }
    }   
    public void BRMsetA(double angle) {
        var angleMeasure = 3;
        if (angle >= (RobotContainer.Angle.getRawAngle(angleMeasure) + Constants.SwerveConstants.turnThreshold) ){
            backLeftMotorAngle.set(ControlMode.PercentOutput, Constants.SwerveConstants.Angle);
        }
        if (angle <= (RobotContainer.Angle.getRawAngle(angleMeasure) - Constants.SwerveConstants.turnThreshold) ){
            backLeftMotorAngle.set(ControlMode.PercentOutput, -Constants.SwerveConstants.Angle);
        }
        else {
            backLeftMotorAngle.set(ControlMode.PercentOutput, 0);
        }
    }               
}
