package adapter;

public class TempAdapter extends FahrenheitSensor {

    public double getTemp() {
        double temp;
        temp = (getSensor() - 32) * 5 / 9;
        return temp;
    }

}
