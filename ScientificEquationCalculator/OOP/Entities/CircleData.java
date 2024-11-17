package OOP.Entities;

public class CircleData {
    private double radius;
    private BaseData baseData;

    public CircleData(double radius, BaseData baseData) {
        this.radius = radius;
        this.baseData = baseData;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public BaseData getBaseData() {
        return baseData;
    }

    public void setBaseData(BaseData baseData) {
        this.baseData = baseData;
    }
}
