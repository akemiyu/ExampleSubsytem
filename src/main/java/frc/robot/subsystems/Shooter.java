package frc.robot.subsystems;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ShooterConstants.AngleState;
import frc.robot.Constants.ShooterConstants.ShooterState;

public class Shooter extends SubsystemBase {
    private CANSparkFlex motor1;
    private CANSparkFlex motor2;
    private CANSparkMax feederMotor;
    private CANSparkFlex angleMotor;

    private ShooterState shooterState;
    private AngleState angleState;

    public Shooter() {
        motor1 = new CANSparkFlex(Constants.ShooterConstants.motor1ID, MotorType.kBrushless);
        motor2 = new CANSparkFlex(Constants.ShooterConstants.motor2ID, MotorType.kBrushless);
        feederMotor = new CANSparkMax(Constants.ShooterConstants.feederMotorID, MotorType.kBrushless);
        angleMotor = new CANSparkFlex(Constants.ShooterConstants.angleMotorID, MotorType.kBrushless);

        angleMotor.getPIDController().setP(Constants.ShooterConstants.kP);
        angleMotor.getPIDController().setI(Constants.ShooterConstants.kI);
        angleMotor.getPIDController().setD(Constants.ShooterConstants.kD);

        shooterState = ShooterState.OFF;
        angleState = AngleState.LOW;
    }

    @Override
    public void periodic() {
        motor1.set(shooterState.speed1);
        motor2.set(shooterState.speed2);
        feederMotor.set(shooterState.feederSpeed);

        angleMotor.getPIDController().setReference(angleState.pos, ControlType.kPosition);
    }
    
    public void setShooterState(ShooterState state) {
        shooterState = state;
    }

    public void setAngleState(AngleState state) {
        angleState = state;
    }

    public ShooterState getState() {
        return shooterState;
    }

    public void stopMotors() {
        motor1.stopMotor();
        motor2.stopMotor();
        feederMotor.stopMotor();
    }
}
