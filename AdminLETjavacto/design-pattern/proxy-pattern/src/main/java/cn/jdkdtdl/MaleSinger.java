package cn.jdkdtdl;

/**
 *
 */
public class MaleSinger implements Singer {
    @Override
    public void sing() {
        System.out.println("周杰伦要去唱歌了");
    }

    @Override
    public void say() {
        System.out.println("周杰伦要去说唱了");
    }
}
