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

    public abstract boolean resetGyro();

    public abstract double getAngle();

    public abstract boolean changeAngle();

    //must be called in the same periodic that controlls the drive
    public void periodicSync(){};
}
