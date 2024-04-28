import java.util.*;

public class FractionInputParser {
    private String input;
    private String stringFractionOne;
    private String stringFractionTwo;
    private String operation;
    private Map<String, Integer>  fractionWords;
    private Map<String, Integer>  especialFractionWords;
    private Map<String, String>  fractionDenominatorWords;

    public FractionInputParser() {
        this.input = "";
        this.stringFractionOne = "";
        this.stringFractionTwo = "";
        this.operation = "";
        this.fractionWords = new HashMap<>();
        this.especialFractionWords = new HashMap<>();
        this.fractionDenominatorWords = new HashMap<>();
        initializeFractionDictionary();
    }

    public void initializeFractionDictionary(){
        fractionWords.put("cero", 0);
        fractionWords.put("un", 1);
        fractionWords.put("uno", 1);
        fractionWords.put("dos", 2);
        fractionWords.put("tres", 3);
        fractionWords.put("cuatro", 4);
        fractionWords.put("cinco", 5);
        fractionWords.put("seis", 6);
        fractionWords.put("siete", 7);
        fractionWords.put("ocho", 8);
        fractionWords.put("nueve", 9);
        fractionWords.put("diez", 10);
        fractionWords.put("once", 11);
        fractionWords.put("doce", 12);
        fractionWords.put("trece", 13);
        fractionWords.put("catorce", 14);
        fractionWords.put("quince", 15);
        fractionWords.put("dieci", 10);
        fractionWords.put("veinte", 20);
        fractionWords.put("veint", 20);
        fractionWords.put("treinta", 30);
        fractionWords.put("cuarenta", 40);
        fractionWords.put("cincuenta", 50);
        fractionWords.put("sesenta", 60);
        fractionWords.put("setenta", 70);
        fractionWords.put("ochenta", 80);
        fractionWords.put("noventa", 90);
        fractionWords.put("entero", 1);
        fractionWords.put("medio", 2);
        fractionWords.put("tercio", 3);
        fractionWords.put("cuarto", 4);
        fractionWords.put("quinto", 5);
        fractionWords.put("sexto", 6);
        fractionWords.put("septimo", 7);
        fractionWords.put("oct", 8);
        fractionWords.put("noveno", 9);
        fractionWords.put("decimo", 10);

        especialFractionWords.put("cero", 0);
        especialFractionWords.put("uno", 1);
        especialFractionWords.put("dos", 2);
        especialFractionWords.put("tres", 3);
        especialFractionWords.put("cuatro", 4);
        especialFractionWords.put("cinco", 5);
        especialFractionWords.put("seis", 6);
        especialFractionWords.put("siete", 7);
        especialFractionWords.put("ocho", 8);
        especialFractionWords.put("nueve", 9);
        especialFractionWords.put("diez", 10);
        especialFractionWords.put("once", 11);
        especialFractionWords.put("doce", 12);
        especialFractionWords.put("trece", 13);
        especialFractionWords.put("catorce", 14);
        especialFractionWords.put("quince", 15);
        especialFractionWords.put("veinte", 20);
        especialFractionWords.put("quinientos", 500);
        especialFractionWords.put("siescientos", 600);
        especialFractionWords.put("setecientos", 700);
        especialFractionWords.put("ochocientos", 800);
        especialFractionWords.put("novecientos", 900);
        especialFractionWords.put("treinta", 30);
        especialFractionWords.put("cuarenta", 40);
        especialFractionWords.put("cincuenta", 50);
        especialFractionWords.put("sesenta", 60);
        especialFractionWords.put("setenta", 70);
        especialFractionWords.put("ochenta", 80);
        especialFractionWords.put("noventa", 90);

        fractionDenominatorWords.put("enteros", "uno");
        fractionDenominatorWords.put("medios", "dos");
        fractionDenominatorWords.put("tercios", "tres");
        fractionDenominatorWords.put("cuartos", "cuatro");
        fractionDenominatorWords.put("quintos", "cinco");
        fractionDenominatorWords.put("sextos", "seis");
        fractionDenominatorWords.put("septimos", "siete");
        fractionDenominatorWords.put("octavos", "ocho");
        fractionDenominatorWords.put("novenos", "nueve");
        fractionDenominatorWords.put("decimos", "diez");
        fractionDenominatorWords.put("centesimos", "cien");

    }

    public void askForOperation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese la operacion:");
        this.input = scanner.nextLine();
        this.input.toLowerCase();
    }

    public int fractionInputParserNumber(String stringNumber){
        int number = 0;
        for (Map.Entry<String ,Integer> entry: this.fractionWords.entrySet()){
            if(stringNumber.contains(entry.getKey())){
                number += entry.getValue();
            }
        }
        return number;
    }
    public Fraction parseFraction(String stringFraction) {
        Fraction output = new Fraction();
        String[] wordsFromFraction = stringFraction.split(" ");
        int numerator = 0;
        int denominator = 0;
        List<String> listNumerator = new ArrayList<>();
        List<String> listDenominator = new ArrayList<>();

        if (wordsFromFraction.length == 2) {
            numerator = fractionInputParserNumber(wordsFromFraction[0]);
            denominator = fractionInputParserNumber(wordsFromFraction[1]);
        } else {
            for (int i = 0; i < wordsFromFraction.length; i++) {
                if (listNumerator.isEmpty()){
                    listNumerator.add(wordsFromFraction[i]);
                }
                else if(wordsFromFraction[i].equals("y") && listNumerator.size() == 1 && listDenominator.isEmpty()){
                    listNumerator.add(wordsFromFraction[i]);
                }
                else if (wordsFromFraction[i -1 ].equals("y") && listNumerator.size() == 2 && listDenominator.isEmpty()){
                    listNumerator.add(wordsFromFraction[i]);
                }
                else {
                    listDenominator.add(wordsFromFraction[i]);
                }
            }
            numerator = fractionInputParserNumber(listNumerator.toString());
            denominator = fractionInputParserNumber(listDenominator.toString());
        }
        output.setNumerator(numerator);
        output.setDenominator(denominator);
        return output;
    }

    public void separateFractions() {
        String[] wordsFromOperation = this.input.split(" ");
        int i = 0;
        while (!isOperator(wordsFromOperation[i]) && i < wordsFromOperation.length) {
            this.stringFractionOne += wordsFromOperation[i] + " ";
            i++;
        }
        this.operation = wordsFromOperation[i];
        i++;
        while (i < wordsFromOperation.length) {
            this.stringFractionTwo += wordsFromOperation[i] + " ";
            i++;
        }
        this.stringFractionOne = this.stringFractionOne.trim();
        this.stringFractionTwo = this.stringFractionTwo.trim();
    }

    private boolean isOperator(String word) {
        return word.equals("mas") || word.equals("menos") || word.equals("entre") || word.equals("por");
    }

    public String fractionObjectToStringWithWords(Fraction fraction){
        StringBuilder stringResult = new StringBuilder();
        StringBuilder numeratorResult = new StringBuilder();
        StringBuilder denominatorResult = new StringBuilder();
        numeratorResult = numeratorToStringWithWords(fraction.getNumerator());
        denominatorResult = denominatorToStringWithWords(fraction.getDenominator());
        denominatorResult = handleSingularDenominator(numeratorResult, denominatorResult);
        stringResult.append(numeratorResult).append(" ").append(denominatorResult);
        return stringResult.toString();
    }

    public StringBuilder numeratorToStringWithWords(int numerator){
        StringBuilder stringResultNumerator = new StringBuilder();
        if(numerator < 0){
            stringResultNumerator.append("menos ");
            numerator *= -1;
        }
        if (numerator == 0){
            stringResultNumerator.append("cero");
            return stringResultNumerator;
        }
        if (numerator == 1){
            stringResultNumerator.append("un");
            return stringResultNumerator;
        }
        stringResultNumerator.append(thousandsToStringWithWords(numerator));
        numerator %= 1000;
        stringResultNumerator.append(hundredsToStringWithWords(numerator));
        numerator %= 100;
        stringResultNumerator.append(tensToStringWithWords(numerator));
        return stringResultNumerator;
    }

    public StringBuilder denominatorToStringWithWords(int denominator){
        StringBuilder stringResultDenominator = new StringBuilder();
        if(denominator < 0){
            stringResultDenominator.append("menos ");
            denominator *= -1;
        }
        if (denominator == 0){
            stringResultDenominator.append("ceroavos");
            return  stringResultDenominator;
        }
        stringResultDenominator.append(thousandsToStringWithWords(denominator));
        denominator %= 1000;
        stringResultDenominator.append(hundredsToStringWithWords(denominator));
        denominator %= 100;
        stringResultDenominator.append(tensToStringWithWords(denominator));
        stringResultDenominator = this.numberStringToDenominatorString(stringResultDenominator.toString());
        stringResultDenominator = this.replaceYWithIInDenominator(stringResultDenominator);
        return stringResultDenominator;
    }

    public StringBuilder thousandsToStringWithWords(int number){
        StringBuilder result = new StringBuilder();
        result.append("");
        int thousands = number / 1000;
        if (thousands > 0){
            if(thousands == 1){
                result.append("mil");
            }
            else if (thousands < 15){
                result.append(this.getKeyFromValue(this.especialFractionWords,thousands)).append(" mil ");
            } else if(thousands > 15 && thousands < 20){
                result.append("dieci").append(this.getKeyFromValue(this.especialFractionWords,thousands-10)).append(" mil ");
            } else {
                result.append(this.getKeyFromValue(this.fractionWords,thousands)).append(" mil ");
            }
        }
        return result;
    }

    public StringBuilder hundredsToStringWithWords(int number){
        StringBuilder result = new StringBuilder();
        result.append("");
        int hundreds = number / 100;
        int boolOfModule = number%100;
        if (hundreds > 0){
            if(hundreds == 1 && boolOfModule==0){
                result.append("cien ");
            } else if (hundreds == 1 && boolOfModule!=0) {
                result.append("ciento ");
            } else if (hundreds >= 5 && hundreds <= 9){
                result.append(this.getKeyFromValue(this.especialFractionWords,number - boolOfModule)).append(" ");
            } else {
                result.append(this.getKeyFromValue(this.fractionWords,hundreds)).append(" cientos ");
            }
        }
        return result;
    }

    public StringBuilder tensToStringWithWords(int number) {
        StringBuilder result = new StringBuilder();
        int tens = number / 10;
        int units = number % 10;
        if (tens > 0) {
            if (tens == 1 && units > 0 && units <= 5) {
                result.append(this.getKeyFromValue(this.especialFractionWords, number));
            } else if (tens == 1 && units == 0) {
                result.append("diez");
            } else if (tens == 1 && units > 5) {
                result.append("dieci").append(this.getKeyFromValue(this.especialFractionWords, units));
            } else if (tens == 2 && units == 0) {
                result.append("veinte");
            } else if (tens == 2 && units > 0) {
                result.append("veinti").append(this.getKeyFromValue(this.especialFractionWords, units));
            } else if (tens > 2 && units == 0) {
                result.append(this.getKeyFromValue(this.fractionWords, tens * 10));
            } else {
                result.append(this.getKeyFromValue(this.fractionWords, tens * 10)).append(" y ").append(this.getKeyFromValue(this.especialFractionWords, units));
            }
        } else if(units > 0){
            result.append(this.getKeyFromValue(this.especialFractionWords, units));
        }
        return result;
    }

    public StringBuilder numberStringToDenominatorString(String stringNumber) {
        StringBuilder result = new StringBuilder();
        String[] wordsFromFraction = stringNumber.split(" ");
        if (wordsFromFraction.length == 1) {
            String denominatorWord = getKeyFromValue(this.fractionDenominatorWords, wordsFromFraction[0]);
            if (denominatorWord != null) {
                result.append(denominatorWord);
            } else {
                result.append(wordsFromFraction[0]).append("avos");
            }
        } else {
            for (String entry : wordsFromFraction) {
                result.append(entry);
            }
            result.append("avos");
        }
        return result;
    }

    public StringBuilder replaceYWithIInDenominator(StringBuilder denominatorString) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < denominatorString.length(); i++) {
            char currentChar = denominatorString.charAt(i);
            if (currentChar == 'y' || currentChar == 'Y') {
                result.append('i');
            } else {
                result.append(currentChar);
            }
        }
        return result;
    }

    public StringBuilder handleSingularDenominator(StringBuilder resultNumerator, StringBuilder resultDenominator) {
        if (resultNumerator.toString().equalsIgnoreCase("un") && resultDenominator.toString().endsWith("s")) {
            resultDenominator.deleteCharAt(resultDenominator.length() - 1);
        }
        return resultDenominator;
    }

    public <K, V> K getKeyFromValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public boolean checkForInvalidWords(String[] words) {
        for (String word : words) {
            boolean validWord = false;
            for (int i = 1; i <= word.length(); i++) {
                String subWord = word.substring(0, i);
                if (fractionWords.containsKey(subWord) || especialFractionWords.containsKey(subWord) || fractionDenominatorWords.containsKey(subWord) || isOperator(subWord) || subWord.equals("y")) {
                    validWord = true;
                    break;
                }
            }
            if (!validWord) {
                System.out.println("Palabra inválida encontrada: " + word);
                return false;
            }
        }
        return true;
    }

    public boolean checkDenominatorsValid(Fraction fractionOne, Fraction fractionTwo) {
        if (fractionOne.getDenominator() == 0 || fractionTwo.getDenominator() == 0) {
            System.out.println("Error: denominador de una fracción es cero.");
            return false;
        }
        if (operation.equals("entre") && fractionTwo.getNumerator() == 0) {
            System.out.println("Error: división por cero.");
            return false;
        }
        return true;
    }


    public void fractionOperationWithString(){
        this.askForOperation();
        String[] wordsFromOperation = this.input.split(" ");
        if (!checkForInvalidWords(wordsFromOperation)) {
            System.out.println("Operación terminada debido a palabras inválidas.");
            return;
        }
        this.separateFractions();
        Fraction fractionOne = parseFraction(stringFractionOne);
        Fraction fractionTwo = parseFraction(stringFractionTwo);
        if (!checkDenominatorsValid(fractionOne, fractionTwo)) {
            return;
        }
        Fraction result = new Fraction();
        switch (this.operation){
            case "mas":{
                result = fractionOne.add(fractionTwo);
            } break;
            case "menos":{
                result = fractionOne.subtract(fractionTwo);
            } break;
            case "por":{
                result = fractionOne.multiply(fractionTwo);
            } break;
            case "entre":{
                result = fractionOne.divide(fractionTwo);
            } break;
        }
        System.out.println(fractionOne.toString());
        System.out.println(operation);
        System.out.println(fractionTwo.toString());
        System.out.println("Result:" + result);
        System.out.println(fractionObjectToStringWithWords(result));
    }
}