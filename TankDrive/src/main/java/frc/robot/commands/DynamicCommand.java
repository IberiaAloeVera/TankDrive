// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.TankDriveSubsystem;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class DynamicCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final TankDriveSubsystem m_tankDriveSubsystem;
  Supplier <Double> setSpeedLeft;   //counts and calculates speed number
  Supplier <Double> setSpeedRight;  //gets speeds for each side
  
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
 

  public DynamicCommand(TankDriveSubsystem tankDriveSubsystem, Supplier <Double> new_setSpeedLeft, Supplier <Double> new_setSpeedRight) {
    m_tankDriveSubsystem = tankDriveSubsystem;
    setSpeedLeft = new_setSpeedLeft;  // gives speeds for each side
    setSpeedRight = new_setSpeedRight;  //sets(gives) speed numbers to the motors 
      //sets grabbed variables from subsystem = to calculated speed value
      addRequirements(tankDriveSubsystem); //makes it so only one command can run is subsystem at a time.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    m_tankDriveSubsystem.setSpeedMotorDynamic(setSpeedLeft.get(),setSpeedRight.get());  //calls upon public DynamicCommand above to run
    
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
