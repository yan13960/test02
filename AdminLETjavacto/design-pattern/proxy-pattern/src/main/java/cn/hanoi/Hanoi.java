package cn.hanoi;

/**
 *
 */
public class Hanoi {
    public static void main(String[] args) {
        System.out.println(Hanoi(10));
        System.out.println(Hanoi(2));
        HanoiPrint("A", "B", "C", 2);
        System.out.println(Hanoi(3));
        System.out.println("========================");
        HanoiPrint("A", "B", "C", 3);
        System.out.println("========================");
        System.out.println(Hanoi(4));
        HanoiPrint("A", "B", "C", 4);
    }

    public static int Hanoi(int n) {
        if (n == 1) {
            return 1;
        }
        return 2 * Hanoi(n - 1) + 1;

    }

    /* 打印盘移动过程
     * n个盘由A借助B移到C
     */
    public static void HanoiPrint(String A, String B, String C, int n) {
        if (n == 1) {
            System.out.println(n + " : " + A + " --> " + C);
        } else {
            HanoiPrint(A, C, B, n - 1);    // A上的n-1个盘借C移到B
            System.out.println(n + " : " + A + " --> " + C);    // A现在为空
            HanoiPrint(B, A, C, n - 1);                   // B上的n-1个盘借A移到C
        }
    }

}
