package frc.robot;

public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class IntakeConstants {
    public static final int m1Id = 0;
    public static final int m2Id = 1;
    public static final int m3Id = 2;

    public static enum RollerState {
      INTAKE(0.5),
      OUTTAKE(-0.5),
      OFF(0);

      public final double speed;
      RollerState(double speed) {
        this.speed = speed;
      }
    }

    public static enum ArmState {
      HIGH(0),
      LOW(0),
      NEUTRAL(0);

      public final double pos;
      ArmState(double pos) {
        this.pos = pos;
      }
    }

    public static final double armkP = 0;
    public static final double armkI = 0;
    public static final double armkD = 0;
  }

  public static class JoystickConstants {
    public static final class Secondary {
      public static final int port = 1;
      public static final int intake = 1;
      public static final int outtake = 2;
    }
  }

  public static class ShooterConstants {
    public static final int motor1ID = 8;
    public static final int motor2ID = 12;
    public static final int feederMotorID = 16;
    public static final int angleMotorID = 20;

    public static final double kP = 0;
    public static final double kI = 0;
    public static final double kD = 0;

    public static enum AngleState {
      HIGH(0),
      LOW(0);

      public final double pos;
      AngleState(double pos) {
        this.pos = pos;
      }
    }

    public static enum ShooterState {
      SHOOT(0.8, 0.4, 0.2),
      REVERSE(-0.2, -0.2, -0.2),
      FEED(0, 0, 0.2),
      OFF(0, 0, 0);

      public double speed1;
      public double speed2;
      public double feederSpeed;

      private ShooterState(double speed1, double speed2, double feederSpeed) {
        this.speed1 = speed1;
        this.speed2 = speed2;
        this.feederSpeed = feederSpeed;
      }
    }
  }
}