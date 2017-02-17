import java.util.Arrays;

class Engine {
    String computeSciFun(String funcName, String param) {
        double paramValue = Double.parseDouble(param);

        if (funcName.equalsIgnoreCase("square")) {
            return "" + (paramValue * paramValue);

        } else if (funcName.equalsIgnoreCase("cube")) {
            return "" + (paramValue * paramValue * paramValue);

        } else if (funcName.equalsIgnoreCase("square_root")) {
            return "" + (Math.sqrt(paramValue));

        } else if (funcName.equalsIgnoreCase("one_by_n")) {
            return "" + ((double) 1 / paramValue);

        } else if (Arrays.asList("sin", "cos", "tan").contains(funcName)) {
            return "" + this.calculateTrigonometry(funcName, paramValue);

        }
        return "Not implemented yet";
    }

    private double calculateTrigonometry(String functionName, double param) {
        if (functionName.equalsIgnoreCase("sin")) {
            return Math.sin(Math.toRadians(param));
        } else if (functionName.equalsIgnoreCase("cos")) {
            return Math.cos(Math.toRadians(param));
        } else if (functionName.equalsIgnoreCase("tan")) {
            return Math.tan(Math.toRadians(param));
        }
        return param;
    }

    static double calculate(double number1, double number2, char operation) {
        if (operation == '+') {
            return number1 + number2;
        } else if (operation == '-') {
            return number1 - number2;
        } else if (operation == '*') {
            return number1 * number2;
        } else if (operation == '/') {
            return number1 / number2;
        } else if (operation == '%') {
            return number1 % number2;
        } else {
            return number2;
        }
    }

    static String getResultToDisplay(boolean hasPoint, char operation, double result) {
        //when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
        if (hasPoint || operation == '/') {
            return "" + result;
        } else {
            //when there is no bPoint in the result
            return "" + (long) result;
        }
    }

    static String getResultToDisplay(boolean hasPoint, double result) {
        return hasPoint ? "" + result : "" + (long) result;
    }
}
