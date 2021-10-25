package cn.itnanls.gcff;

/**
 *
 */
public class BenzFactory implements CarFactory {
    @Override
    public Car createCar() {
        Car benz=new Benz();
        //中间可能有两百行代码
        benz.setColor("red");
        return benz;
    }
}
