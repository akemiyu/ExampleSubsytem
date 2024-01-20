package frc.robot;

public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class IntakeConstants {
    public static final int m1Id = 0;
    public static final int m2Id = 1;
  
    public static enum IntakeState {
      INTAKE(0.5),
      OUTTAKE(-0.5),
      OFF(0);

      public final double speed;
      IntakeState(double speed) {
        this.speed = speed;
      }
    }
  }

  public static class JoystickConstants {
    public static final class Secondary {
      public static final int port = 1;
      public static final int intake = 1;
      public static final int outtake = 2;
    }
  }
}
