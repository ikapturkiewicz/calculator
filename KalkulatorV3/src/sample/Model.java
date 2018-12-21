package sample;


public class Model {

    /**
     * metoda dokonujaca obliczen zaleznie od przekazanego operatora
     * @param number1
     * @param number2
     * @param operator
     * @return
     */

    public double calculate(double number1, double number2, String operator) {
        switch (operator) {

            case "x^2":
                return Math.pow(number1, number2);
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0) {
                    return 0;
                }
                return number1 / number2;

        }


        System.out.println("Unknown operator - " + operator);
        return 0;
    }

    /**
     * przeladowana metoda dokonujaca obliczen na jednej liczbie
     * @param number
     * @param operator
     * @return
     */
    public double calculate (double number, String operator) {
        switch(operator) {

            case "pierw":
                return Math.sqrt(number);
            case "sin":
                return Math.sin(number);
            case "cos":
                return Math.cos(number);
            case "tg":
                return Math.tan(number);
            case"exp()":
                return Math.exp(number);
            case "log()":
                return Math.log10(number);
            case "ln()":
                return Math.log(number);
        }
        System.out.println("Unknown operator - " + operator);
        return 0;
    }
}
