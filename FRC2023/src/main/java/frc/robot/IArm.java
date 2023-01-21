package frc.robot;

public interface IArm {

    public void init();

    public void stop();
    
    //go to position (0, 0)
    public void positionDefault(double angle);

    //go to a fully extended position
    public void positionExtended(double angle);

    //go to grabbing position
    public void positionGrab(double angle);

    public void periodic();

}
