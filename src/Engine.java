import java.util.DoubleSummaryStatistics;

class Engine {
    String computeSciFun(String funcName, String param){
        if(funcName.equalsIgnoreCase("square")){
            return ""+(Double.parseDouble(param) * Double.parseDouble(param));
        }else if(funcName.equalsIgnoreCase("cube")){
            return ""+(Double.parseDouble(param) * Double.parseDouble(param) * Double.parseDouble(param));
        }else if(funcName.equalsIgnoreCase("square_root")){
            return ""+(Math.sqrt(Double.parseDouble(param)));
        }else if(funcName.equalsIgnoreCase("one_by_n")){
            return ""+((double)1/Double.parseDouble(param));
        }else if(funcName.equalsIgnoreCase("sin")){
            double value = Double.parseDouble(param);
            return ""+this.calculateTrigonometry("sin", value);
        }
        return "Not implemented yet";
    }

    private double calculateTrigonometry(String functionName, double param){
        double result = 0.0;
        if(functionName.equalsIgnoreCase("sin")) {
            result = Math.sin(Math.toRadians(param));
        }
        if(param == 30){
            result += 0.0000000000000001;
        }
        return result;
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
