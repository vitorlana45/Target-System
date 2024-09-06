public class FaturamentoDiario {

    public static void main(String[] args) {

        double highestDailyIncome = Double.MIN_VALUE;
        double lowestDailyIncome = Double.MAX_VALUE;
        double total = 0;
        int dayWithLowestIncome = 0;
        int dayWithHighestIncome = 0;
        int daysAboveAverage = 0;

        int[] incomeList = {
                234, 123, 345, 456, 567, 678, 789, 890, 1234, 1500,
                1600, 1700, 1800, 1900, 2000, 2100, 2200, 2300, 2400, 2500,
                2600, 2700, 2800, 2900, 3000, 3100, 3200, 3500, 3400, 3212
        };

        int currentDay = 1;
        for (int index : incomeList) {
            if (lowestDailyIncome > index) {
                lowestDailyIncome = index;
                dayWithLowestIncome = currentDay;
            }
            if (highestDailyIncome < index) {
                highestDailyIncome = index;
                dayWithHighestIncome = currentDay;
            }
            total += index;
            currentDay++;
        }

        double average = total / incomeList.length;

        for (int v : incomeList) {
            if (v > average) {
                daysAboveAverage++;
            }
        }

        System.out.println("O menor faturamento do mês foi no dia " + dayWithLowestIncome + " com R$ " + String.format("%.2f", lowestDailyIncome));
        System.out.println("O maior faturamento do mês foi no dia " + dayWithHighestIncome + " com R$ " + String.format("%.2f", highestDailyIncome));
        System.out.println("Quantidade de dias acima da média: " + daysAboveAverage);
        System.out.println("Média do faturamento do mês: " + String.format("%.2f", average));

    }
}
