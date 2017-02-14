class Engine {
    String computeSciFun(String funcName, String param){
        return "Not implemented yet";
    }
    public static double calculate(double number1, double number2, char operation){
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

    public static String getResultToDisplay(boolean hasPoint, char operation, double result){
        //when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
        if (hasPoint || operation == '/')
        {
            return "" + result;
        } else if (!hasPoint) {
            //when there is no bPoint in the result
            return "" + (long) result;
        }
        return "";
    }

    public static String getResultToDisplay(boolean hasPoint, double result){
        return hasPoint ? ""+result : ""+(long)result;
    }
}
