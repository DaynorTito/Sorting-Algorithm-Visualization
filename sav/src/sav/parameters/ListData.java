package university.jala.sav.parameters;

import university.jala.sav.validators.ListDataValidator;

import java.util.Objects;
import java.util.Random;

public class ListData {

    private String[] args;
    private String type;
    private static final int MIN_RANGE = -100;
    private static final int MAX_RANGE = 100;
    private static final int ASCII_LETTER_A = 65;
    private static final int ASCII_LETTER_z = 122;
    private static final int MAX_ASCII_SYMBOLS_RANGE = 96;
    private static final int MIN_ASCII_SYMBOLS_RANGE = 91;
    private static final int ASCII_DECREMENT = 10;
    private Parameter parameters;
    private static ListData listDataInstance;

    public static ListData getInstance(String[] args) {
        if(listDataInstance == null) {
            listDataInstance = new ListData(args);
        }
        return listDataInstance;
    }

    private ListData(String[] args) {
        parameters = Parameter.getInstance(args);
        this.args = args;
        this.type = parameters.getTypeData();
    }

    public Integer[] getArrayInteger() {
        String numbersString = args[4].substring(2, args[4].length());
        ListDataValidator.validateExistList(args[4]);
        String[] listNumbers = numbersString.split(",");
        printType(listNumbers);
        ListDataValidator.validateArrayInteger(listNumbers);
        Integer[] numbers = new Integer[listNumbers.length];
        for (int iesimoNumber = 0; iesimoNumber < listNumbers.length; iesimoNumber++) {
            if (!listNumbers[iesimoNumber].equals(""))
                numbers[iesimoNumber] = Integer.parseInt(listNumbers[iesimoNumber]);
        }
        return numbers;
    }

    public Integer[] getArrayIntegerRandom() {
        Random random = new Random();
        Integer[] numbers = new Integer[parameters.getNumberValuesRandom()];
        for (int iesimoNumber = 0; iesimoNumber < numbers.length; iesimoNumber++) {
            numbers[iesimoNumber] = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
        }
        printArrayIntegers(numbers);
        return numbers;
    }

    public void printType(String[] listElements) {
        System.out.print("Values: [");
        if (listElements.length > 0) {
            for (int iNumber = 0; iNumber < listElements.length - 1; iNumber++)
                System.out.print(listElements[iNumber] + ", ");
            System.out.print(listElements[listElements.length - 1]);
        }
        System.out.println("]");
    }

    public Character[] getArrayCharacter() {
        String charString = args[4].substring(2, args[4].length());
        String[] listChar = charString.split(",");
        printType(listChar);
        ListDataValidator.validateArrayCharacter(listChar);
            Character[] characters = new Character[listChar.length];
        for (int iesimoCharacter = 0; iesimoCharacter < listChar.length; iesimoCharacter++) {
            if (listChar[iesimoCharacter].length()>0)
                characters[iesimoCharacter] = listChar[iesimoCharacter].charAt(0);
        }
        return characters;
    }

    public Character[] getArrayCharacterRandom() {
        Random random = new Random();
        int arraySize = parameters.getNumberValuesRandom();
        Character[] characters = new Character[arraySize];
        for (int iesimoCharacter = 0; iesimoCharacter < characters.length; iesimoCharacter++) {
            int randomCharValue = random.nextInt(ASCII_LETTER_z - ASCII_LETTER_A + 1) + ASCII_LETTER_A;
            if (MIN_ASCII_SYMBOLS_RANGE <= randomCharValue && randomCharValue <= MAX_ASCII_SYMBOLS_RANGE) {
                randomCharValue -= ASCII_DECREMENT;
            }
            characters[iesimoCharacter] = (char) randomCharValue;
        }
        printArrayCharacters(characters);
        return characters;
    }

    public void printArrayCharacters(Character[] characters) {
        System.out.print("Values: [");
        for (int iesimoCharacter = 0; iesimoCharacter < characters.length - 1; iesimoCharacter++)
            System.out.print("'" + characters[iesimoCharacter] + "', ");
        if (characters.length > 0)
            System.out.print("'" + characters[characters.length - 1] + "'");
        System.out.println("]");
    }

    public void printArrayIntegers(Integer[] numbers) {
        System.out.println("Values: [");
        for (int iesimoNumber = 0; iesimoNumber < numbers.length - 1; iesimoNumber++)
            System.out.print(numbers[iesimoNumber] + ", ");
        if (numbers.length > 0)
            System.out.print(numbers[numbers.length - 1]);
        System.out.println("]");
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Parameter getParameters() {
        return parameters;
    }

    public void setParameters(Parameter parameters) {
        this.parameters = parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListData listData = (ListData) o;
        return Objects.equals(type, listData.type) && Objects.equals(parameters, listData.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, parameters);
    }
}
