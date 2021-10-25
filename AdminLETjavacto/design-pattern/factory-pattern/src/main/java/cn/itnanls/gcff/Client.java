package cn.itnanls.gcff;

/**
 *
 */
public class Client {
    public static void main(String[] args) {
        CarFactory carFactory=new BenzFactory();
        Car car=carFactory.createCar();
        car.run();

    }
}
