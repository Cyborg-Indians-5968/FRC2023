package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Grabber implements IGrabber{
    //represents a motorized grabber on the robot using a SparkMax controller
    PWMSparkMax motor;


    public Grabber(int channel){
        motor = new PWMSparkMax(channel);
    }
    
    //TODO: check if the motor needs to be inverted
    @Override
    public void open(double speed){
        motor.set(speed);
    }
    @Override
    public void close(double speed){
        motor.set((speed * -1));
    }

    @Override
    public void init(){
        motor.stopMotor();
    }

    @Override
    public void periodic(){

    }
}
