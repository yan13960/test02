package cn.itnanls;

/**
 *
 */
public class Agent implements Singer {
    private  Singer singer;

    public Agent(Singer singer) {
        this.singer = singer;
    }

    @Override
    public void sing() {
        System.out.println("协商价钱，会场等等工作");
        //一定是歌手去唱歌
        singer.sing();

        System.out.println("结算费用");
    }
}
