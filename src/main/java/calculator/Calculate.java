package calculator;

import java.math.BigDecimal;
import java.util.List;

public class Calculate {

    private BigDecimal result;

    public Calculate(List<Operator> operatorList, List<BigDecimal> numberList){
        validateOperandsAndOperators(operatorList, numberList);

        result= numberList.get(0);
        if(operatorList.isEmpty()){
            return;
        }

        calculateWholeProblem(operatorList, numberList);
    }

    public void validateOperandsAndOperators(List<Operator> operatorList, List<BigDecimal> numberList){
        if(numberList.size()-1 != operatorList.size()){
            throw new IllegalArgumentException("Wrong String input");
        }
    }

    public BigDecimal getResult(){
        return result;
    }

    public void calculateWholeProblem(List<Operator> operatorList, List<BigDecimal> numberList){
        for(int i=0; i<operatorList.size(); i++){
            result= calculateTwoNumber(operatorList.get(i), numberList.get(i+1));
        }
    }

    public BigDecimal calculateTwoNumber(Operator operator, BigDecimal number){
        return operator.calculate(result, number);
    }

}
