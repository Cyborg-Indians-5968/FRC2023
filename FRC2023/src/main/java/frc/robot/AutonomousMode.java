package frc.robot;

import java.lang.Thread;


public class AutonomousMode implements IRobotMode {

    private IDrive drive;
    private IGyroscopeSensor gyroscope;
    
    public AutonomousMode(IDrive drive, IGyroscopeSensor gyroscope) {
        this.drive = drive;
        this.gyroscope = gyroscope;
        }


    public void init() {
        move();
    }

    public void move() {
        if (gyroscope.getRoll() > .2) {
            drive.cartesianMovement(gyroscope.getRoll()/2, 0.01, null);
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            Debug.logPeriodic("Rolling positive");
        }
        else if (gyroscope.getRoll() < -.2) {
            drive.cartesianMovement(gyroscope.getRoll()/2, -0.01, null);
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            Debug.logPeriodic("Rolling negative");
        }
        else {
            drive.stop();

        }
    }

    @Override
    public void periodic() {
        move();
    }
}

