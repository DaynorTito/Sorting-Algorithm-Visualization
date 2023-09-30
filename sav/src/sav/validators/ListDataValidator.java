package university.jala.sav.validators;

public final class ListDataValidator {

    private ListDataValidator() {

    }

    public static void validateArrayInteger(String[] listNumbers) {
        if (listNumbers.length > 1) {
            for (int iesimoNumber = 0; iesimoNumber < listNumbers.length; iesimoNumber++) {
                try {
                    Integer.parseInt(listNumbers[iesimoNumber]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid values");
                }
            }
        }
    }

    public static void validateArrayCharacter(String[] listChar) {
        if(listChar.length > 1) {
            for (int iesimoCharacter = 0; iesimoCharacter < listChar.length; iesimoCharacter++) {
                if (listChar[iesimoCharacter].length() != 1) {
                    throw new IllegalArgumentException("Invalid character at index " + iesimoCharacter + ": " + listChar[iesimoCharacter]);
                }
                char character = listChar[iesimoCharacter].charAt(0);
                if (Character.isDigit(character)) {
                    throw new IllegalArgumentException("The Character '" + character + "' cannot be a number. Invalid values");
                }
            }
        }
    }

    public static void validateExistList(String listParameter) {
        if(!listParameter.substring(0,2).equals("v=") && listParameter.substring(0,2).equals("s=")) {
            try {
                throw new InvalidParameterException("Invalid values.");
            } catch (InvalidParameterException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
