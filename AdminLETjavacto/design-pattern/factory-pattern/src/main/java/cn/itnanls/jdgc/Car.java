package cn.itnanls.jdgc;

/**
 *
 */
public abstract class Car {

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 汽车启动的方法
     * */
   abstract void run();
}
