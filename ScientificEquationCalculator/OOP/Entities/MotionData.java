package OOP.Entities;

public class MotionData {
    private double initialVelocity;
    private double acceleration;
    private double time;
    private BaseData baseData;

    public MotionData(double initialVelocity, double acceleration, double time, BaseData baseData) {
        this.initialVelocity = initialVelocity;
        this.acceleration = acceleration;
        this.time = time;
        this.baseData = baseData;
    }

    public double getInitialVelocity() {
        return initialVelocity;
    }

    public void setInitialVelocity(double initialVelocity) {
        this.initialVelocity = initialVelocity;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public BaseData getBaseData() {
        return baseData;
    }

    public void setBaseData(BaseData baseData) {
        this.baseData = baseData;
    }
}
