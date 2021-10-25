package cn.itnanls.jdgc;

/**
 *
 */
public class Crv extends Car {
    /**
     * 汽车启动的方法
     */
    @Override
    void run() {
        System.out.println(this.getColor()+"crv在奔跑！");
    }
}
