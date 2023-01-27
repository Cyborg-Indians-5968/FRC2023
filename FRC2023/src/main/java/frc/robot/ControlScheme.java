package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public abstract class ControlScheme {
    //represents a control scheme
    XboxController controller;

    public ControlScheme(){
        controller = new XboxController(PortMap.USB.XBOXCONTROLLER);
    }

    public abstract double getMovementX();

    public abstract double getMovementY();

    //should the gyro reset?
    public abstract boolean resetGyro();

    //angle for the robot
    public abstract double getAngle();

    //should the robot point in a different direction?
    public abstract boolean changeAngle();

    //must be called in the same periodic that controlls the drive
    public void periodicSync(){};
}
