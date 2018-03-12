public class Main {

    public static void main(String[] args) throws Exception {
        SineCounter logic = new SineCounter(args);
        logic.calculate();
        System.out.println(logic.getResult());
    }
}
