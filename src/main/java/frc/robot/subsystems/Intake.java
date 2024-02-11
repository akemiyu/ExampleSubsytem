package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.IntakeConstants.ArmState;
import frc.robot.Constants.IntakeConstants.RollerState;

public class Intake extends SubsystemBase {
    private CANSparkFlex m1;
    private CANSparkFlex m2;
    private CANSparkFlex m3;
    private RollerState rollerState;
    private ArmState armState;

    public Intake() {
        m1 = new CANSparkFlex(Constants.IntakeConstants.m1Id, MotorType.kBrushless);
        m2 = new CANSparkFlex(Constants.IntakeConstants.m2Id, MotorType.kBrushless);
        m2.follow(m1);
        rollerState = RollerState.OFF;
        
        m3 = new CANSparkFlex(Constants.IntakeConstants.m3Id, MotorType.kBrushless);
        m3.getPIDController().setP(IntakeConstants.armkP);
        m3.getPIDController().setI(IntakeConstants.armkI);
        m3.getPIDController().setD(IntakeConstants.armkD);
        armState = ArmState.NEUTRAL;
    }

    @Override
    public void periodic() {
        m1.set(rollerState.speed);
        m3.getPIDController().setReference(armState.pos, ControlType.kPosition);
    }

    public void setRollerState(RollerState state) {
        rollerState = state;
    }

    public void setArmState(ArmState state) {
        armState = state;
    }
}
