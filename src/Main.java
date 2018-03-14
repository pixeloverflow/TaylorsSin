public class Main {

    public static void main(String[] args) throws Exception {
        String[] test1 = "270 DeGreEs 15".split(" ");
        String[] test2 = "0.75 pi 15".split(" ");
        String[] test3 = "0.25 radians 15".split(" ");

        SineCounter logic1 = new SineCounter(test1);
        SineCounter logic2 = new SineCounter(test2);
        SineCounter logic3 = new SineCounter(test3);
        logic1.calculate();
        logic2.calculate();
        logic3.calculate();

        System.out.println(logic1.getResult());
        System.out.println(logic2.getResult());
        System.out.println(logic3.getResult());

        System.out.println(Math.sin(logic2.getRadians()));
    }
}
