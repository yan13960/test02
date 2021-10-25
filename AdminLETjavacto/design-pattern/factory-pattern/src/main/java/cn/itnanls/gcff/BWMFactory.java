package cn.itnanls.gcff;

/**
 *
 */
public class BWMFactory implements CarFactory {
    @Override
    public Car createCar() {
        Car bmw=new BMW();
        //中间可能有两百行代码
        bmw.setColor("white");
        return bmw;
    }
}
