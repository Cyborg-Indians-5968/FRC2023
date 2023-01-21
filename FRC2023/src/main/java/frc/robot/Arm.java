package frc.robot;

import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Arm implements IArm {

    private Mode mode;
    private Runnable currentCompletionRoutine;

    // Motors
    private CANSparkMax shoulderMotor;
    private CANSparkMax elbowMotor;
    private CANSparkMax handMotor;

    // rotations
    private double shoulderRotations = 0.0;
    private double elbowRotations = 0.0;
    private double handRotations = 0.0;

    // static rotations
    private static final double SHOULDER_MOTOR_ROTATIONS = 200; // change values
    private static final double ELBOW_MOTOR_ROTATIONS = 25;
    private static final double HAND_MOTOR_ROTATIONS = 25;




    public Arm() {

        shoulderMotor = new CANSparkMax(PortMap.CAN.SHOULDER_MOTOR, MotorType.kBrushed);
        elbowMotor = new CANSparkMax(PortMap.CAN.ELBOW_MOTOR, MotorType.kBrushed);
        handMotor = new CANSparkMax(PortMap.CAN.HAND_MOTOR, MotorType.kBrushed);

    }

    private enum ArmMode {
        IDLE,
        PICKUP,
        EXTENDED,
    }

    private ArmMode armMode = ArmMode.IDLE;

    @Override
    public void init() {
        stop();
        shoulderMotor.restoreFactoryDefaults();
        elbowMotor.restoreFactoryDefaults();
        handMotor.restoreFactoryDefaults();

    }

    @Override
    public void stop() {
        shoulderRotations = 0.0;
        elbowRotations = 0.0;
        handRotations = 0.0;
    }

    @Override
    public void positionDefault(double angle) {
        mode = Mode.MANUAL;
        armMode = ArmMode.IDLE;
        
    }

    @Override
    public void positionExtended(double angle) {
        mode = Mode.MANUAL;
        armMode = ArmMode.EXTENDED;
        
    }

    @Override
    public void positionGrab(double angle) {
        mode = Mode.MANUAL;
        armMode = ArmMode.PICKUP;
        
    }

    private void handleActionEnd() {
        stop();
        
        if (currentCompletionRoutine != null) {
            Runnable oldCompletionRoutine = currentCompletionRoutine;
            currentCompletionRoutine = null;
            oldCompletionRoutine.run();
        }
    }

    public void periodic() {
        if (mode == Mode.MANUAL) {
            if (armMode == ArmMode.IDLE) {
                // TODO
            } else if (armMode == ArmMode.EXTENDED) {
                // TODO
            }
        }
        shoulderMotor.set(shoulderRotations);
        elbowMotor.set(elbowRotations);
        handMotor.set(handRotations);
    }
    
}
