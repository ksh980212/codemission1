import calculator.Calculate;
import calculator.Parser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
public class ApplicationTest{

    @Test(expected = ArithmeticException.class)
    public void divide_BY_ZERO(){

        //given
        String inputString="10 / 3";

        //when
        Parser parser= new Parser(inputString);
        Calculate cal =new Calculate(parser.getOperatorList(), parser.getNumbersList());


        System.out.println(cal.getResult());

    }

    @Test(expected = IllegalArgumentException.class)
    public void WRONG_INPUT_LENGTH(){
        //given
        String inputString= "10 /";

        //when
        Parser parser = new Parser(inputString);
        Calculate calculate = new Calculate(parser.getOperatorList(), parser.getNumbersList());
        System.out.println(calculate.getResult());
    }

    @Test(expected = IllegalArgumentException.class)
    public void WRONG_OPERATOR(){
        //given
        String inputString= "10 & 3";

        //when
        Parser parser = new Parser(inputString);
        Calculate calculate = new Calculate(parser.getOperatorList(), parser.getNumbersList());
        System.out.println(calculate.getResult());
    }


    @Test
    public void calculator_TEST(){

        //given

        String add= String.format("1 %s 2", "+");
        String min= String.format("1 %s 2", "-");
        String mul= String.format("1 %s 2", "*");
        String div= String.format("1 %s 2", "/");

        //when
        Parser addParser=new Parser(add);
        Parser minParser=new Parser(min);
        Parser mulParser=new Parser(mul);
        Parser divParser=new Parser(div);

        Calculate addCal= new Calculate(addParser.getOperatorList(), addParser.getNumbersList());
        Calculate minCal= new Calculate(minParser.getOperatorList(), minParser.getNumbersList());
        Calculate mulCal= new Calculate(mulParser.getOperatorList(), mulParser.getNumbersList());
        Calculate divCal= new Calculate(divParser.getOperatorList(), divParser.getNumbersList());
        //then
        assertThat(addCal.getResult()).isEqualTo(new BigDecimal(3));
        assertThat(minCal.getResult()).isEqualTo(new BigDecimal(-1));
        assertThat(mulCal.getResult()).isEqualTo(new BigDecimal(2));
        assertThat(divCal.getResult()).isEqualTo(new BigDecimal(0.5));
    }

}
