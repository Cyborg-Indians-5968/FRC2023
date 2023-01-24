package frc.robot;

public interface IGrabber{
    public void open(double speed);

    public void close(double speed);

    public void init();

    public void periodic();
}