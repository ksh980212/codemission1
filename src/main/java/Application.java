import calculator.Calculate;
import calculator.Parser;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        try {
            Parser parser = new Parser(scannerInput());
            Calculate calculate = new Calculate(parser.getOperatorList(), parser.getNumbersList());
            System.out.println(calculate.getResult());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }

    public static String scannerInput(){
        Scanner stdIn =new Scanner(System.in);
        return stdIn.nextLine();
    }
}
