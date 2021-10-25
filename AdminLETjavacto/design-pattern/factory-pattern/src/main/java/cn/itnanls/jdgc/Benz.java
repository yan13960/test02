package cn.itnanls.jdgc;

/**
 *
 */
public class Benz  extends Car {
    /**
     * 汽车启动的方法
     */
    @Override
    void run() {
        System.out.println(this.getColor()+"奔驰在奔跑！");
    }
}
