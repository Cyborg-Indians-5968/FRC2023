package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class PrecisionControlScheme extends ControlSchemeA{
    public PrecisionControlScheme(XboxController controller){
        super(controller);
    }

    public void periodicSync(){
        //joystick calculations
        double leftX = controller.getLeftX();
        double leftY = -controller.getLeftY();

        leftX = Math.pow(leftX, LEFT_STICK_EXPONENT) / 2;
        leftY = Math.pow(leftY, LEFT_STICK_EXPONENT) / 2;

        double rightX = controller.getRightX();
        double rightY = -controller.getRightY();

        rightX = Math.pow(rightX, RIGHT_STICK_EXPONENT) / 2;
        rightY = Math.pow(rightY, RIGHT_STICK_EXPONENT) / 2;
    }
    
}
