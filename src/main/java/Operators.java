public class Operators {
    static int i1 = 6;
    static int i2 = 2;
    static int i3 = 7;
    static int i4 = 3;
    static int sum1 = i1 + i2;
    static int sum2 = i3 + i4;

    public static boolean compareSum1(){
        return sum1 > sum2;
    }

    public static boolean compareSum2(){
        sum1 ++;
        sum2 -= 2;
        return sum1 > sum2;
    }

    public static boolean compareSum3(){
        sum1 = sum1 % 2;
        sum2 = sum2 % 2;
        return sum1 == 0 || sum2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(compareSum1());
        System.out.println(compareSum2());
        System.out.println(compareSum3());
    }
}
