package org.example.utils;

public class StringUtils {
    /**
     * Converte cada elemento do array de Strings de minúsculas para capitalização
     * @param inputArray array de Strings em minúsculas
     * @return um array de Strings com elementos capitalizados
     */
    public static String[] capitalizeArray(String[] inputArray) {
        String[] resultArray = new String[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            String input = inputArray[i].toLowerCase();
            String[] words = input.split("_");
            String result = "";

            for (String word : words) {
                if (!word.isEmpty()) {
                    char firstChar = word.charAt(0);
                    result += Character.toUpperCase(firstChar) + word.substring(1) + " ";
                }
            }

            resultArray[i] = result.trim();
        }

        return resultArray;
    }
}
