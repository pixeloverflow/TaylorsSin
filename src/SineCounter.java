public class SineCounter {
    private double x;
    private int steps;
    private double result = 0;

    private double nominator;
    private int denominator;
    private int factorial = 1;
    private boolean addOrSubt = true;

    public SineCounter(String[] input) throws Exception {
        convert(input);
    }

    public void calculate(){
        while (steps != 0) makeStep();
    }

    public double getResult(){
        return result;
    }

    private void convert(String[] input) throws Exception {
        if (input.length != 3) {
            throw new Exception("Incorrect number of arguments");
        }

        x = Integer.parseInt(input[0]);

        char angle = input[1].toLowerCase().charAt(0);
        if (angle=='r' || angle == 'p') {
            x -= 2*(x/2);
        }
        else if (angle=='d') {
            x %= 360;
            x /= 180;
        }
        else throw new Exception("Incorrect angle format");

        nominator = x;
        denominator = 1;

        steps = Integer.parseInt(input[2]);
    }

    private void makeStep(){
        if (addOrSubt) result += nominator/denominator;
        else result -= nominator/denominator;

        for (int i=0; i<2 ;++i){
            factorial += 1;
            denominator *= factorial;
        }
        nominator *= x * x;
        addOrSubt = !addOrSubt;
        --steps;
    }
}
