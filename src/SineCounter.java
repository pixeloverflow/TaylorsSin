public class SineCounter {
    private double x;
    private int steps;
    private double result = 0;

    private double nominator;
    private int denominator;
    private int factorial = 1;
    private boolean addOrSubt = true;
    private boolean toFlip = false;

    public SineCounter(String[] input) throws Exception {
        convert(input);
    }

    public void calculate(){
        while (steps != 0) makeStep();
        if (toFlip) result = -result;
    }

    public double getResult(){
        return result;
    }

    public double getRadians(){
        return x;
    }

    private void convert(String[] input) throws Exception {
        if (input.length != 3) {
            throw new Exception("Incorrect number of arguments");
        }

        x = Double.parseDouble(input[0]);

        char angle = input[1].toLowerCase().charAt(0);
        if (angle=='r' || angle == 'p') {
            if (x > 2 || x < -2) x -= 2*(int)(x/2);
            if (x < 0) x += 2;
        }
        else if (angle=='d') {
            if (x > 360 || x < -360) x %= 360;
            if (x < 0) x += 360;
            x /= 180;
        }
        else throw new Exception("Incorrect angle unit");

        if (x == 0.5) {
            result = 1;
            steps = 0;
            return;
        }
        else if (x > 0.5 && x < 1) x = 1 - x;
        else if (x%1==0) {
            result = 0.0;
            x = 0;
            steps = 0;
            return;
        }
        else if (x > 1 && x < 1.5) {
            x -= 1;
            toFlip = true;
        }
        else if (x == 1.5) {
            result = 1;
            steps = 0;
            toFlip = true;
            return;
        }
        else if (x > 1.5 && x < 2) {
            x -= 1;
            x = 1 - x;
            toFlip = true;
        }
        x = x * Math.PI;
        nominator = x;
        denominator = 1;

        steps = Integer.parseInt(input[2]);
    }

    private void makeStep(){
        if (addOrSubt) result += nominator/denominator;
        else result -= nominator/denominator;

        factorial += 1;
        denominator *= factorial;
        factorial += 1;
        denominator *= factorial;

        nominator *= x * x;
        addOrSubt = !addOrSubt;
        --steps;
    }
}
