package frc.robot;

public interface IGrabber{
    //Represents a grabber on the robot
    public void open(double speed);

    public void close(double speed);

    public void init();

    public void periodic();
}