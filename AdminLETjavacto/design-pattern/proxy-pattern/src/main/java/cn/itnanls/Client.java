package cn.itnanls;

/**
 *
 */
public class Client {
    public static void main(String[] args) {
        Singer singer=new MaleSinger();
        Agent agent=new Agent(singer);
        agent.sing();
    }
}
