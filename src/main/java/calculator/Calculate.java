package calculator;

import java.math.BigDecimal;
import java.util.List;

public class Calculate {

    private List<Operator> operatorList;
    private List<BigDecimal> numberList;
    private BigDecimal result;

    public Calculate(List<Operator> operatorList, List<BigDecimal> numberList){
        this.operatorList=operatorList;
        this.numberList=numberList;

        result= numberList.get(0);

        calculateWholeProblem(operatorList, numberList);
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
