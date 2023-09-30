package university.jala.sav.parameters;

import university.jala.sav.validators.ListDataValidator;
import university.jala.sav.validators.ParametersValidator;

import java.util.Objects;

public class Parameter {

    private String algorithm;
    private boolean ascendant;
    private boolean random;
    private String dataMode;
    private String typeData;
    private int numberValuesRandom;
    private int pauseTime;
    private static Parameter parameterInstance;

    public static Parameter getInstance(String[] args) {
        if(parameterInstance == null) {
            parameterInstance = new Parameter(args);
        }
        return parameterInstance;
    }


    private Parameter() {

    }
    private Parameter(String[] args) {
        ParametersValidator.validateAlgorithm(args[0]);
        algorithm = args[0].substring(2);

        ParametersValidator.validateTypeData(args[1]);
        typeData = args[1].substring(2);

        ParametersValidator.validateOrder(args[2]);
        ascendant = (args[2].substring(2).equalsIgnoreCase("az"))? true:false;

        ParametersValidator.validateDataModel(args[3]);
        dataMode = args[3].substring(3);

        printType();
        if(!dataMode.equalsIgnoreCase("M") ) {
            ParametersValidator.validateNumberRandomElements(args[4]);
            numberValuesRandom = Integer.parseInt(args[4].substring(2));
            random=true;
        } else {
            ListDataValidator.validateExistList(args[4]);
            random = false;
        }

        if (args.length<=6) {
            ParametersValidator.validatePauseTime(args[5]);
            pauseTime = Integer.parseInt(args[5].substring(2));
        } else
            ParametersValidator.validateIsThereValue("s=",args[4],"Missing value for delay pause.");
    }

    public Parameter(String algorithm, boolean ascendant, String dataMode, int numberValuesRandom, int pauseTime) {
        this.algorithm = algorithm;
        this.ascendant = ascendant;
        this.dataMode = dataMode;
        this.numberValuesRandom = numberValuesRandom;
        this.pauseTime = pauseTime;
    }

    public void printType() {
        if (typeData.equalsIgnoreCase("C")) {
            System.out.println("\nType: [character]");

        } else {
            System.out.println("\nType: [integer]");
        }
    }
    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public boolean isAscendant() {
        return ascendant;
    }

    public void setAscendant(boolean ascendant) {
        this.ascendant = ascendant;
    }

    public String getDataMode() {
        return dataMode;
    }

    public void setDataMode(String dataMode) {
        this.dataMode = dataMode;
    }

    public int getNumberValuesRandom() {
        return numberValuesRandom;
    }

    public void setNumberValuesRandom(int numberValuesRandom) {
        this.numberValuesRandom = numberValuesRandom;
    }

    public int getPauseTime() {
        return pauseTime;
    }

    public void setPauseTime(int pauseTime) {
        this.pauseTime = pauseTime;
    }

    public boolean isRandom() {
        return random;
    }

    public void setRandom(boolean random) {
        this.random = random;
    }

    public String getTypeData() {
        return typeData;
    }

    public void setTypeData(String typeData) {
        this.typeData = typeData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameter parameter = (Parameter) o;
        return ascendant == parameter.ascendant && random == parameter.random && numberValuesRandom == parameter.numberValuesRandom && pauseTime == parameter.pauseTime && Objects.equals(algorithm, parameter.algorithm) && Objects.equals(dataMode, parameter.dataMode) && Objects.equals(typeData, parameter.typeData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(algorithm, ascendant, random, dataMode, typeData, numberValuesRandom, pauseTime);
    }
}
