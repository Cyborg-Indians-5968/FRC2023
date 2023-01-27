package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class TeleoperatedMode implements IRobotMode {
    
    private XboxController xboxController;
    private IDrive drive;
    private ControlScheme controlScheme;
    // check values above

    public TeleoperatedMode(IDrive drive){ 
        xboxController = new XboxController(PortMap.USB.XBOXCONTROLLER);
        controlScheme = new ControlSchemeA(xboxController);
        this.drive = drive;
    }

    @Override
    public void init(){
        drive.init();
    }

     @Override
     public void periodic() {

        if (controlScheme.resetGyro()) {
            drive.resetGyro();
        }

        controlScheme.periodicSync();

        drive.driveManual(controlScheme.getMovementY(), controlScheme.getMovementX());

        // Think Pythagorean Thereom
        if(controlScheme.changeAngle()) {
            drive.rotateAbsolute(controlScheme.getAngle());
        }

     }

}
