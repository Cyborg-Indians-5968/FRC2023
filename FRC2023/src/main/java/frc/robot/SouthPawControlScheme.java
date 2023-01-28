package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class SouthPawControlScheme extends ControlSchemeA{

    public SouthPawControlScheme(XboxController controller){
        super(controller);
    }

    @Override
    public void periodicSync(){
        //joystick calculations
        double leftX = controller.getRightX();
        double leftY = -controller.getRightY();

        leftX = Math.pow(leftX, LEFT_STICK_EXPONENT);
        leftY = Math.pow(leftY, LEFT_STICK_EXPONENT);

        double rightX = controller.getLeftX();
        double rightY = -controller.getLeftY();

        rightX = Math.pow(rightX, RIGHT_STICK_EXPONENT);
        rightY = Math.pow(rightY, RIGHT_STICK_EXPONENT);
    }
}
