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
}