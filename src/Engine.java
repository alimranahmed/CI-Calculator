import java.util.DoubleSummaryStatistics;

class Engine {
    String computeSciFun(String funcName, String param){
        if(funcName.equalsIgnoreCase("square")){
            return ""+(Double.parseDouble(param) * Double.parseDouble(param));
        }else if(funcName.equalsIgnoreCase("cube")){
            return ""+(Double.parseDouble(param) * Double.parseDouble(param) * Double.parseDouble(param));
        }else if(funcName.equalsIgnoreCase("square_root")){
            return ""+(Math.sqrt(Double.parseDouble(param)));
        }
        return "Not implemented yet";
    }

    static double calculate(double number1, double number2, char operation){
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

    static String getResultToDisplay(boolean hasPoint, char operation, double result){
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

    static String getResultToDisplay(boolean hasPoint, double result){
        return hasPoint ? ""+result : ""+(long)result;
    }
}
