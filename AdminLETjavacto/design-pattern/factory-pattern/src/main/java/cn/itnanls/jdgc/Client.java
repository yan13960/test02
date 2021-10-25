package cn.itnanls.jdgc;

/**
 *
 */
public class Client {
    public static void main(String[] args) {
        CarFactory carFactory=new CarFactory();
        Car car=carFactory.createCar("BWM","white");
        car.run();
        Car car2=carFactory.createCar("Benz","white");
        car2.run();
        Car car3=carFactory.createCar("Crv","white");
        car3.run();
    }
}
