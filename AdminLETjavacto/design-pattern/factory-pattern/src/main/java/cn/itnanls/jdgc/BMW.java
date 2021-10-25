package cn.itnanls.jdgc;

/**
 *
 */
public class BMW extends Car {

    //可能有20个成员变量

    /**
     * 汽车启动的方法
     */
    @Override
    void run() {
        System.out.println(this.getColor()+"宝马在奔跑！");
    }
}
