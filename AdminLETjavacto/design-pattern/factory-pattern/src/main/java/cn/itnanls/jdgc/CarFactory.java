package cn.itnanls.jdgc;

/**
 *
 */
public class CarFactory {

    public Car createCar(String type, String color){
        //如果将来传进来的是宝马， 我就创建一个宝马
        if ("BWM".equals(type)){
            Car car =new BMW();
            car.setColor(color);
            return car;
        }else if ("Benz".equals(type)){
            Car car=new Benz();
            car.setColor(color);
            return car;
        }else if ("Crv".equals(type)){
            Car car=new Crv();
            car.setColor(color);
            return car;
        }
        return null;
    }
}
