/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.utilities.DrivePID;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.*;



/**
 * Add your docs here.
 * 
 * 
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  CANSparkMax leftFront = new CANSparkMax(RobotMap.neoLeftFront, MotorType.kBrushless);
  CANSparkMax leftMiddle = new CANSparkMax(RobotMap.neoLeftMiddle, MotorType.kBrushless);
  CANSparkMax leftBack = new CANSparkMax(RobotMap.neoLeftBack, MotorType.kBrushless);
  CANSparkMax rightFront = new CANSparkMax(RobotMap.neoRightFront, MotorType.kBrushless);
  CANSparkMax rightMiddle = new CANSparkMax(RobotMap.neoRightMiddle, MotorType.kBrushless);
  CANSparkMax rightBack = new CANSparkMax(RobotMap.neoRightBack, MotorType.kBrushless);
  CANEncoder leftFrontEncoder = new CANEncoder(leftFront);
  CANEncoder leftMiddleEncoder = new CANEncoder(leftMiddle);
  CANEncoder leftBackEncoder = new CANEncoder(leftBack);
  CANEncoder rightFrontEncoder = new CANEncoder(rightFront);
  CANEncoder rightMiddleEncoder = new CANEncoder(rightMiddle);
  CANEncoder rightBackEncoder = new CANEncoder(rightBack);

  DrivePID drivePID = new DrivePID(leftFrontEncoder, leftMiddleEncoder, leftBackEncoder,
  rightFrontEncoder, rightMiddleEncoder, rightBackEncoder,
  1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setDriveLeft(double speed){
    leftFront.set(speed);
    leftMiddle.set(speed);
    leftBack.set(speed);
  }

  public void setDriveRight(double speed){
    rightFront.set(speed);
    rightMiddle.set(speed);
    rightBack.set(speed);
  }
  
  public void ReadLeftFrontEncoder(){
    leftFrontEncoder.getPosition();
  }

  public void ReadLeftMiddleEncoder(){
    leftMiddleEncoder.getPosition();
  }

  public void ReadLeftBackEncoder(){
    leftBackEncoder.getPosition();
  }

  public void ReadRightFrontEncoder(){
    rightFrontEncoder.getPosition();
  }

  public void ReadRightMiddleEncoder(){
    rightMiddleEncoder.getPosition();
  }

  public void ReadRightBackEncoder(){
    rightBackEncoder.getPosition();
  }

  public void setDriveMotorsPID(){
    drivePID.updateMotorValues();
    setDriveLeft(drivePID.getLeftMotorValue());
    setDriveRight(drivePID.getRightMotorValue());
  }

  public void setDesiredDriveDistance(double value){
    drivePID.setDriveDesiredDistance(value);
  }

  public void setDesiredDriveAngle(double value){
    drivePID.setDriveDesiredAngle(value);
  }

  public double getDesiredDriveDistance(double value){
    return drivePID.getDriveDesiredDistance();
  }

  public double getDesiredDriveAngle(double value){
    return drivePID.getDriveDesiredAngle();
  }
}
