package frc.robot;


public interface IDrive {
    
    public Mode getCurrentDriveMode();

    public void resetGyro();

    // Teleoperated methods use radians
    // Turns the robot by a relative angle
    public void rotateRelative(double angle);

    // Turns the robot to an absolute angle
    public void rotateAbsolute(double angle);

    public void driveDistance(double distanceInches, double speed, double angle);

    /*
     * completionRoutine is called when the current action has been completed
     * Autonomous methods use degrees
     */
    public void driveDistance(double distanceInches, double speed, double angle, Runnable completionRoutine);

    public void gyroCorrection();

    public void rotateRelative(double angle, Runnable completionRoutine);

    public void rotateAbsolute(double angle, Runnable completionRoutine);

    /*
     * This is the method used to drive manually during teleoperated mode
     */
    public void driveManual(double forwardSpeed, double strafeSpeed);

    // This turns the robot to an absolute field angle

    public void stop();

    public void init();

    /*
     * Called periodically to actually execute the driving and rotating set by
     * the driveDistance() and rotateDegrees() methods
     */
    public void periodic();
    
}
