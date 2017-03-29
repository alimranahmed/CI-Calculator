import java.util.Arrays;
import java.util.Date;

class Engine {
    String computeSciFun(String funcName, String input) {
        double inputValue = Double.parseDouble(input);

        if (funcName.equalsIgnoreCase("square")) {
            return "" + (inputValue * inputValue);

        } else if (funcName.equalsIgnoreCase("cube")) {
            return "" + (inputValue * inputValue * inputValue);

        } else if (funcName.equalsIgnoreCase("square_root")) {
            return "" + (Math.sqrt(inputValue));

        } else if (funcName.equalsIgnoreCase("one_by_n")) {
            return "" + ((double) 1 / inputValue);

        }else if(funcName.equalsIgnoreCase("ln")){
            return ""+Math.log(inputValue);

        } else if(funcName.equalsIgnoreCase("log")){
            return ""+Math.log10(inputValue);

        }else if (Arrays.asList("sin", "cos", "tan").contains(funcName)) {
            return "" + this.calculateTrigonometry(funcName, inputValue);

        }
        return "Not implemented yet";
    }

    private double calculateTrigonometry(String functionName, double input) {
        double radianInput = Math.toRadians(input);
        if (functionName.equalsIgnoreCase("sin")) {
            return Math.sin(radianInput);
        } else if (functionName.equalsIgnoreCase("cos")) {
            return Math.cos(radianInput);
        } else if (functionName.equalsIgnoreCase("tan")) {
            return Math.tan(radianInput);
        }
        return input;
    }

    String compute(String operand1, String operand2, String operator){
        try {
            double parsedOperand1 = Double.parseDouble(operand1);
            double parsedOperand2 = Double.parseDouble(operand2);
            if (operator.equalsIgnoreCase("+")) {
                return ""+(parsedOperand1 + parsedOperand2);

            } else if (operator.equalsIgnoreCase("\u00D7")) {
                return ""+(parsedOperand1 * parsedOperand2);

            } else if (operator.equalsIgnoreCase("\u02D7")) {
                return ""+(parsedOperand1 - parsedOperand2);

            } else if (operator.equalsIgnoreCase("mod")) {
                return ""+(parsedOperand1 % parsedOperand2);

            }else if(operator.equalsIgnoreCase("\u00F7")){
                return ""+(parsedOperand1 / parsedOperand2);

            }
        }catch (Exception e){
            System.out.println(new Date()+"[Engine][compute] "+e.getMessage());
            return "ERROR";
        }
        return "FAILED";
    }
}
