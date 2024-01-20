package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.IntakeConstants.IntakeState;
import frc.robot.subsystems.Intake;

public class RobotContainer {
  private final Joystick secondary = new Joystick(Constants.JoystickConstants.Secondary.port);
  private final JoystickButton intakeButton = new JoystickButton(secondary, Constants.JoystickConstants.Secondary.intake);
  private final JoystickButton outtakeButton = new JoystickButton(secondary, Constants.JoystickConstants.Secondary.outtake);

  private final Intake intake = new Intake();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    intakeButton.onTrue(new InstantCommand(() -> intake.setState(IntakeState.INTAKE))); 
    outtakeButton.onTrue(new InstantCommand(() -> intake.setState(IntakeState.OUTTAKE))); 
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
