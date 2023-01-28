package frc.robot;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.XboxController;

public class TeleoperatedMode implements IRobotMode {
    
    private XboxController xboxController;
    private IDrive drive;
    private ControlScheme controlScheme;
    private ArrayList<ControlScheme> controlSchemes;
    private int currentScheme;
    // check values above

    public TeleoperatedMode(IDrive drive){ 
        xboxController = new XboxController(PortMap.USB.XBOXCONTROLLER);
        controlSchemes = new ArrayList<ControlScheme>();
        controlSchemes.add(new ControlSchemeA(xboxController));
        controlSchemes.add(new SouthPawControlScheme(xboxController));
        controlSchemes.add(new PrecisionControlScheme(xboxController));
        currentScheme = 0;
        controlScheme = controlSchemes.get(currentScheme);
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

        if (controlScheme.changeScheme()){
            currentScheme++;
            if(currentScheme >= controlSchemes.size()){
                currentScheme = 0;
            }
        }

        controlScheme.periodicSync();

        drive.driveManual(controlScheme.getMovementY(), controlScheme.getMovementX());

        // Think Pythagorean Thereom
        if(controlScheme.changeAngle()) {
            drive.rotateAbsolute(controlScheme.getAngle());
        }

     }

}
