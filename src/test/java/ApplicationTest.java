import calculator.Calculate;
import calculator.Operator;
import calculator.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest{

    private Parser parser;

    @Test
    public void 숫자를0으로나눈다(){

        //given
        String inputString="10 / 3";

        //when + then
        Assertions.assertThrows(ArithmeticException.class, () -> {
            parser= new Parser(inputString);
            Calculate.calculateWholeProblem(parser.getOperatorList(), parser.getNumbersList());
        });
    }

    @Test
    public void 잘못된_문자열길이를_입력한다(){
        //given
        String inputString= "10 /";

        //when + then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            parser = new Parser(inputString);
        });

    }

    @Test
    public void 잘못된_연산자를_입력한다(){
        //given
        String inputString= "10 & 3";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           parser = new Parser(inputString);
        });
    }

    @ParameterizedTest
    @CsvSource({"+,ADD", "-,SUB", "*,MUL", "/,DIV"})
    public void 사칙연산_사용한다(String operationExpression, Operator operator){

        //given
        String inputString = String.format("1 %s 2", operationExpression);

        //when
        parser = new Parser(inputString);

        //then
        assertThat(parser.getOperatorList()).containsExactly(operator);
    }

}
