package calculator;

import java.math.BigDecimal;
import java.util.List;

public class Calculate {

    private static BigDecimal result;

    public static void validateOperandsAndOperators(List<Operator> operatorList, List<BigDecimal> numberList){
        if(numberList.size() -1 != operatorList.size()){
            throw new IllegalArgumentException(String.format("잘못된 문자열 입력입니다"));
        }
    }

    public static BigDecimal getResult(){
        return result;
    }

    public static void calculateWholeProblem(List<Operator> operatorList, List<BigDecimal> numberList){

        validateOperandsAndOperators(operatorList, numberList);

        result = numberList.get(0);

        if(operatorList.isEmpty()){
            return;
        }

        for(int i=0; i<operatorList.size(); i++){
            result= calculateTwoNumber(operatorList.get(i), numberList.get(i+1));
        }
    }

    public static BigDecimal calculateTwoNumber(Operator operator, BigDecimal number){
        return operator.calculate(result, number);
    }

}
