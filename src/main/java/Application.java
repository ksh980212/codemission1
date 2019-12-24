import calculator.Calculate;
import calculator.Parser;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        try {
            Parser parser = new Parser(scannerInput());
            Calculate.calculateWholeProblem(parser.getOperatorList(), parser.getNumbersList());
        }catch(IllegalArgumentException e){
            System.out.println(String.format("입력한 문자열을 확인 해주세요. Error message : %s", e.getMessage()));
        }catch(ArithmeticException e){
            System.out.println(String.format("피연산자는 0으로 나눌수 없습니다. Error message: %s", e.getMessage()));
        }
    }

    public static String scannerInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
