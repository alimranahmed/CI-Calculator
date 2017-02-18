import java.util.Arrays;

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
}
