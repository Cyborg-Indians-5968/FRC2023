package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class ControlSchemeA extends ControlScheme {
    //implementation of a control scheme

    protected final static double ROTATION_THRESHOLD = 0.3;
    protected final static double LEFT_STICK_EXPONENT = 3.0;
    protected final static double RIGHT_STICK_EXPONENT = 3.0;
    
    double leftX = controller.getLeftX();
    double leftY = controller.getLeftY();
    double rightX = controller.getRightX();
    double rightY = -controller.getRightY();

    public ControlSchemeA(XboxController controller){
        this.controller = controller;
    }

    public double getMovementX(){
        return leftX;
    }
    
    public double getMovementY(){
        return leftY;
    }

    public double getAngle(){
        return Math.atan2(rightX, rightY);
    }

    public boolean resetGyro(){
        return controller.getBackButton();
    }

    public boolean changeAngle(){
        //Think Pythagorean theorem
        return Math.sqrt(Math.pow(rightX, 2) + Math.pow(rightY, 2)) > ROTATION_THRESHOLD;
    }

    public boolean changeScheme(){
        return controller.getStartButtonPressed();
    }

    @Override
    public void periodicSync(){
        //joystick calculations
        double leftX = controller.getLeftX();
        double leftY = -controller.getLeftY();

        leftX = Math.pow(leftX, LEFT_STICK_EXPONENT);
        leftY = Math.pow(leftY, LEFT_STICK_EXPONENT);

        double rightX = controller.getRightX();
        double rightY = -controller.getRightY();

        rightX = Math.pow(rightX, RIGHT_STICK_EXPONENT);
        rightY = Math.pow(rightY, RIGHT_STICK_EXPONENT);
    }
}
