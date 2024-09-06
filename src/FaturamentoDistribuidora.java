import java.io.FileReader;
import java.io.IOException;

public class FaturamentoDistribuidora {

    public static void main(String[] args) {

        String path = "src/monthlyIncome.json";

        StringBuilder jsonString = new StringBuilder();
        try {
            FileReader reader = new FileReader(path);
            int character;
            while ((character = reader.read()) != -1) {
                jsonString.append((char) character);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonArrayString = jsonString.toString();
        jsonArrayString = jsonArrayString.substring(jsonArrayString.indexOf("[") + 1, jsonArrayString.lastIndexOf("]"));

        String[] incomeArray = jsonArrayString.split("},\\s*\\{");

        incomeArray[0] = incomeArray[0].replace("{", "");
        incomeArray[incomeArray.length - 1] = incomeArray[incomeArray.length - 1].replace("}", "");  // Remove the last object

        double totalIncome = 0.0;
        double[] values = new double[incomeArray.length];

        for (int i = 0; i < incomeArray.length; i++) {
            String item = incomeArray[i];
            String[] keyValuePairs = item.split(",");

            for (String pair : keyValuePairs) {
                String[] entry = pair.split(":");
                String key = entry[0].trim().replace("\"", "");
                String value = entry[1].trim().replace("\"", "").replace("]", "").replace("[", "");

                if (key.equals("valor")) {
                    double amount = Double.parseDouble(value);
                    totalIncome += amount;
                    values[i] = amount;
                }
            }
        }

        for (int i = 0; i < incomeArray.length; i++) {
            String item = incomeArray[i];
            String[] keyValuePairs = item.split(",");

            String state = "";
            double value = values[i];

            for (String pair : keyValuePairs) {
                String[] entry = pair.split(":");
                String key = entry[0].trim().replace("\"", "");
                String valueString = entry[1].trim().replace("\"", "").replace("]", "").replace("[", "");

                if (key.equals("estado")) {
                    state = valueString;
                }
            }

            double percentage = (value / totalIncome) * 100;

            System.out.printf("State: %s, Value: %.2f, Percentage: %.2f%%\n", state, value, percentage);
        }
        System.out.println("Total Income: " + totalIncome);
    }
}
