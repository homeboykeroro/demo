package written.test.demo;
import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import written.test.demo.constant.QuestionEnum;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    static final int MOD = 1000000007;
    static final int MAX = 1000;
    static long[] dp = new long[MAX];

    @Override
    public void run(String...args) throws Exception {
        try {
            while(true) {
                Scanner scannerObj = new Scanner(System.in);
                String questionStr;

                System.out.println("Enter question: "); 
                questionStr = scannerObj.nextLine();   

                QuestionEnum question = null;

                try {
                    question = QuestionEnum.valueOf(questionStr.toUpperCase());
                } catch (Exception e) {
                    throw new Exception("Question Not Found");
                }

                switch (question) {
                    case ONE:
                        calculateFibonacci();
                        break;  
                    case TWO:
                        break;
                    case THREE:
                        broadGame();
                        break;
                    default:
                        calculateFibonacci();
                }

                continue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void calculateFibonacci() throws Exception {
        Scanner scannerObj = new Scanner(System.in);
        String nStr;
        
        System.out.println("Enter n: "); 
        nStr = scannerObj.nextLine();   

        Integer n = Integer.parseInt(nStr);
        BigDecimal result = null;

        if (n <= 0) {
            result = BigDecimal.ZERO;
        } else if (n == 1) {
            result = BigDecimal.ONE;
        } else {
            BigDecimal a = BigDecimal.ZERO, b = BigDecimal.ONE;
            for (int i = 2; i <= n; i++) {
                BigDecimal temp = a;
                a = b;
                b = temp.add(b);
            }
            result = b;
        }

        System.out.println("Result: " + result.toString());
    }

    public void randomBinaryTree() {

    }

    public void broadGame() {
        Scanner scannerObj = new Scanner(System.in);
        String nStr;
        
        System.out.println("Enter n: "); 
        nStr = scannerObj.nextLine();   

        Integer n = Integer.parseInt(nStr);

        dp[0] = 1;
        for (int i = 1; i < MAX; i++) {
            for (int j = 1; j <= 6 && j <= i; j++) {
                dp[i] = (dp[i] + dp[i - j]) % MOD;
            }
        }

        System.out.println("The number of ways to reach " + n + " is " + dp[n]);

    }
}