package frc.robot;

public class NullDrive implements IDrive {

    private IGyroscopeSensor gyroscope;

    public NullDrive(IGyroscopeSensor gyroscope) {
        this.gyroscope = gyroscope;
    }

    public void resetGyro() {
        gyroscope.resetYaw();
        Debug.log("Yaw: " + gyroscope.getYaw());
    }
    
    public Mode getCurrentDriveMode() {
        return Mode.IDLE;
    }

    public void rotateRelative(double angle) {
    }

    public void rotateAbsolute(double angle) {
    }

    public void driveDistance(double distanceInches, double speed, double angle) {
    }

    public void gyroCorrection() {
        
    }

    public void driveDistance(double distanceInches, double speed, double angle, Runnable completionRoutine) {  
    }

    public void rotateRelative(double angle, Runnable completionRoutine) {
    }

    public void rotateAbsolute(double angle, Runnable completionRoutine) {
    }

    public void driveManual(double xDirectionSpeed, double yDirectionSpeed) {
    }

    public void stop() {
    }

    public void init() {
    }

    public void periodic() {
    }
}
