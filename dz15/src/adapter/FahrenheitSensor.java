package adapter;

public class FahrenheitSensor implements Sensor {

    @Override
    public double getSensor() {
        //например
        double t = 55.0;
        return t;
    }

}
