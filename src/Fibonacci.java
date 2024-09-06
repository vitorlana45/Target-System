
public class Fibonacci {
    public static void main(String[] args) {

        String genericResponse = " faz parte da sequência de Fibonacci ";

        int targetNumber = 56;

        boolean isFibonacciNumber = (isFibonacci(targetNumber));

        System.out.println(isFibonacciNumber ? targetNumber + genericResponse : targetNumber + " Não" + genericResponse);

    }

    public static boolean isFibonacci(int targetNumber) {

        if (targetNumber < 0) {
            return false;
        }

        int currentNumber = 0;
        int next = 1;

        while (currentNumber < targetNumber) {
            int aux = currentNumber;
            currentNumber = next;
            next += aux;
        }
        return currentNumber == targetNumber;
    }
}
