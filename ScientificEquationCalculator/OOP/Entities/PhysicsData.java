package OOP.Entities;

public class PhysicsData {
    private double mass;
    private double acceleration;
    private MotionData motionData;
    private double volume;

    public double getVolume() {
        return volume;
    }

    public PhysicsData(double mass, double acceleration, MotionData motionData) {
        this.mass = mass;
        this.acceleration = acceleration;
        this.motionData = motionData;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public MotionData getMotionData() {
        return motionData;
    }

    public void setMotionData(MotionData motionData) {
        this.motionData = motionData;
    }
}
