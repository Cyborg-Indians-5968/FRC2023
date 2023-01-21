package frc.robot;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends RobotBase {

    private IRobotMode disabledMode;
    private IRobotMode autonomousMode;
    private IRobotMode teleoperatedMode;

    private IDrive drive;
    private IGyroscopeSensor gyroscope;

    public Robot() {
        gyroscope = new NavXMXP();

        drive = new Drive(gyroscope);
        //drive = new NullDrive(gyroscope);
        disabledMode = new DisabledMode();
        teleoperatedMode = new TeleoperatedMode(drive);
        autonomousMode = new AutonomousMode(drive);
    }


    @Override
    public void startCompetition() {
        // HAL.observeUserProgramStarting();
        //HAL.observeUserProgramStarting()

        IRobotMode currentMode = null;
        IRobotMode desiredMode = null;

        while (true) {
            desiredMode = getDesiredMode();
            
            if (desiredMode != currentMode) {
                LiveWindow.setEnabled(isTest());
                doPeripheralReinitialization();
                desiredMode.init();
                currentMode = desiredMode;
            }
            currentMode.periodic();
            doPeripheralPeriodicProcessing();
            SmartDashboard.updateValues();
            LiveWindow.updateValues();
        }
    }

    private void doPeripheralReinitialization() {
        drive.init();
    }

    private void doPeripheralPeriodicProcessing() {
        drive.periodic();
        Debug.periodic();
    }

    private IRobotMode getDesiredMode() {
        if (isDisabled()) {
           // HAL.observeUserProgramDisabled();
            return disabledMode;
        } else if (isAutonomous()) {
            // HAL.observeUserProgramAutonomous();
            return autonomousMode;
        } else if (isTeleop()) {
            // HAL.observeUserProgramTeleop();
            return teleoperatedMode;
        } else if (isTest()) {
            // HAL.observeUserProgramTest();
            return teleoperatedMode;
        } else {
            throw new IllegalStateException("Robot is in an invalid mode");
        }
    }

    @Override
    public void endCompetition() {
        
    }
}