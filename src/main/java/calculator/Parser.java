package calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private List<Operator> operatorList = new ArrayList<>();
    private List<BigDecimal> numbersList = new ArrayList<>();

    public Parser(String inputString){
        String[] splitedString = splitInputString(inputString);
        validatedLength(splitedString);
        divideOperatorAndNumber(splitInputString(inputString));
    }

    public List<Operator> getOperatorList(){
        return operatorList;
    }
    public List<BigDecimal> getNumbersList(){
        return numbersList;
    }

    public void validatedLength(String[] splitedString){
        if(splitedString.length%2==0){
            throw new IllegalArgumentException(String.format("입력하신 문자열의 길이가 알맞지 않습니다"));
        }
    }

    public static String[] splitInputString(String inputString){
        return inputString.split(" +");
    }

    public void divideOperatorAndNumber(String[] inputString){
        for(int i=0; i<inputString.length; i++){
            addOperatorsList(inputString[i], i);
            addNumbersList(inputString[i], i);
        }
    }

    public void addOperatorsList(String inputString, int index){
        if(index%2==1){
            operatorList.add(Operator.of(inputString));
        }
    }
    public void addNumbersList(String inputString, int index){
        if(index%2==0){
            numbersList.add(createBigDecimal(inputString));
        }
    }

    public static BigDecimal createBigDecimal(String str){
        return new BigDecimal(str);
    }

}
