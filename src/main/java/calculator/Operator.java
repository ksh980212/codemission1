package calculator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", BigDecimal::add),
    SUB("-", BigDecimal::subtract),
    MUL("*", BigDecimal::multiply),
    DIV("/", BigDecimal::divide);

    private String operatorExpression;
    private BiFunction<BigDecimal, BigDecimal, BigDecimal> operate;

    Operator(String operatorExpression, BiFunction<BigDecimal, BigDecimal, BigDecimal> operate){
        this.operatorExpression=operatorExpression;
        this.operate=operate;
    }

    private static Map<String, Operator> operatorMap= new HashMap<>();

    static{
        for(Operator operator: Operator.values()){
            operatorMap.put(operator.operatorExpression, operator);
        }
    }

    public static Operator of(String inputString){
        if(operatorMap.containsKey(inputString)){
            return operatorMap.get(inputString);
        }
        throw new IllegalArgumentException(String.format("operator not exists"));
    }

    public BigDecimal calculate(BigDecimal leftOperand, BigDecimal rightOperand){
        return operate.apply(leftOperand, rightOperand);
    }

}
