package frc.robot.subsystems;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.IntakeConstants.IntakeState;

public class Intake extends SubsystemBase {
    private CANSparkFlex m1;
    private CANSparkFlex m2;
    private IntakeState intakeState;

    public Intake() {
        m1 = new CANSparkFlex(Constants.IntakeConstants.m1Id, MotorType.kBrushless);
        m2 = new CANSparkFlex(Constants.IntakeConstants.m2Id, MotorType.kBrushless);
        m2.follow(m1);
        m2.setInverted(true);
        intakeState = IntakeState.OFF;
    }

    @Override
    public void periodic() {
        m1.set(intakeState.speed);
    }

    public void setState(IntakeState state) {
        intakeState = state;
    }
}
