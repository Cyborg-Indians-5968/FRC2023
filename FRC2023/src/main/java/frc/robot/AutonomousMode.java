package frc.robot;

public class AutonomousMode implements IRobotMode {

    private IDrive drive;
    private double speed = 0.15;

    public AutonomousMode(IDrive drive) {
        this.drive = drive;
    }

    public void init() {
        autoBalance();
    }

    public void autoBalance() {
        drive.driveDistance(12, .5, 0, null);
        drive.gyroCorrection( /* put parameters in here */);
    }

    @Override
    public void periodic() {

    }
}
