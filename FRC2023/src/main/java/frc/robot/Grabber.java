package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Grabber implements IGrabber{
    PWMSparkMax motor;

    public Grabber(int channel){
        motor = new PWMSparkMax(channel);
    }

    public void open(double speed){
        motor.set(speed);
    }

    public void close(double speed){
        motor.set((speed * -1));
    }

    public void init(){
        motor.stopMotor();
    }

    public void periodic(){

    }
}
