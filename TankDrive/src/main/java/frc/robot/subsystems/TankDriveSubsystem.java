// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TankDriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  TalonFX topleftMotor;
  TalonFX toprightMotor;
  TalonFX bottomrightMotor;
  TalonFX bottomleftMotor;
  TalonFX coralMotor;
  TalonFXConfiguration pidConfiguration = new TalonFXConfiguration().withSlot0(new Slot0Configs().withKP(1).withKI(0).withKD(0));


  public TankDriveSubsystem() {
     topleftMotor = new TalonFX(Constants.topleftMotorPort);
     toprightMotor = new TalonFX(Constants.toprightMotorPort);
     bottomrightMotor = new TalonFX(Constants.bottomrightMotorPort);
     bottomleftMotor = new TalonFX(Constants.bottomleftMotorPort);
     topleftMotor.getConfigurator().apply(pidConfiguration);
     toprightMotor.getConfigurator().apply(pidConfiguration);
     bottomleftMotor.getConfigurator().apply(pidConfiguration);
     bottomrightMotor.getConfigurator().apply(pidConfiguration);
  }

  public void setSpeedMotorDynamic (double setSpeedRight, double setSpeedLeft){
    topleftMotor.set(setSpeedLeft);
    toprightMotor.set(setSpeedRight);
    bottomleftMotor.set(-setSpeedLeft);
    bottomrightMotor.set(-setSpeedRight);
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
