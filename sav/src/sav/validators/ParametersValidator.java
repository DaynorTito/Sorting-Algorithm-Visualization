package university.jala.sav.validators;

public final class ParametersValidator {

    private ParametersValidator(){

    }
    public static void validateTypeData(String typeParameter) {
        validateIsThereValue("t=",typeParameter,"Error, missing value for type");
        if(!typeParameter.substring(2).equalsIgnoreCase("N") && !typeParameter.substring(2).equalsIgnoreCase("C")) {
            try {
                throw new InvalidParameterException("Error, Unrecognized Type.");
            } catch (InvalidParameterException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void validateIsNumber(String number, String message) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }
    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void validateCharacter(String character, String message) {
        if (character.equalsIgnoreCase("") || isNumber(character)) {
            try {
                throw new InvalidParameterException(message);
            } catch (InvalidParameterException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void validateAlgorithm(String algorithmParameter) {
        validateIsThereValue("a=",algorithmParameter,"Error, missing algorithm.");
        validateCharacter(algorithmParameter.substring(2),"Error, invalid value to select algorithm.");
        if(!algorithmParameter.substring(2).equalsIgnoreCase("B") && !algorithmParameter.substring(2).equalsIgnoreCase("Q") && !algorithmParameter.substring(2).equalsIgnoreCase("M")) {
            try {
                throw new InvalidParameterException("Error, there is no value for algorithm selection.");
            } catch (InvalidParameterException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void validateOrder(String orderParameter) {
        validateIsThereValue("o=",orderParameter,"Error, missing sort order.");
        if(!orderParameter.substring(2).equals("az") && !orderParameter.substring(2).equals("za") && !orderParameter.substring(2).equals("AZ") && !orderParameter.substring(2).equals("ZA")) {
            try {
                throw new InvalidParameterException("Error, unrecognized sort type.");
            } catch (InvalidParameterException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void validateDataModel(String dataMode) {
        validateIsThereValue("in",dataMode,"Error, missing input type values.");
        if(!dataMode.substring(3).equalsIgnoreCase("M") && !dataMode.substring(3).equalsIgnoreCase("R")) {
            try {
                throw new InvalidParameterException("Error, Invalid value input type.");
            } catch (InvalidParameterException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void validatePauseTime(String pauseTime) {
        try {
            Integer.parseInt(pauseTime.substring(2));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Pause parameter in milliseconds invalid");
        }
        if (!(100 <= Integer.parseInt(pauseTime.substring(2)) && Integer.parseInt(pauseTime.substring(2))<=1000)) {
            try {
                throw new InvalidParameterException("Value for delay pause invalid.");
            } catch (InvalidParameterException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void validateIsThereValue(String parameter, String argParameter, String message) {
        if (!parameter.equalsIgnoreCase(argParameter.substring(0,2))) {
            try {
                throw new InvalidParameterException(message);
            } catch (InvalidParameterException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void validateNumberRandomElements(String numberLemementsRandomParameter) {
        if (!numberLemementsRandomParameter.substring(0,2).equals("r=")) {
            try {
                throw new InvalidParameterException("Missing number of values to be generated.");
            } catch (InvalidParameterException e) {
                throw new RuntimeException(e);
            }
        }
        validateIsNumber(numberLemementsRandomParameter.substring(2), "Number of values to generate invalid.");
        int value = Integer.parseInt(numberLemementsRandomParameter.substring(2));
        if (!(1 <= value && value <=40)) {
            try {
                throw new InvalidParameterException("Number of values to generate invalid.");
            } catch (InvalidParameterException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
