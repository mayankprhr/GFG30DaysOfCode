import java.io.*;

public class CashRegister {
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) 
        {
        printCashChange(line);
        }
    }
    private static void printCashChange(String line) {
       String[] fields = line.split(";", 2);
        float pp = Float.parseFloat(fields[0]);
        float ch = Float.parseFloat(fields[1]);

         System.out.println(getCashChange(pp, ch));
    }

    private static String getCashChange(float price, float cash) {
        if (cash < price) { return "ERROR"; }
        if (cash == price) { return "ZERO"; }
        float cashBack = cash - price;

        StringBuilder change = new StringBuilder();
    for (Denomination d : Denomination.values()) {
        while (cashBack >= d.getValue()) {
            cashBack -= d.getValue();

            change.append(d).append(',');
            }
        }

            return change.toString().substring(0,change.length()-1);
        }

    public enum Denomination {
        ONE_HUNDRED(100.00f),
            FIFTY( 50.00f),
            TWENTY( 20.00f),
            TEN( 10.00f),
            FIVE(  5.00f),
            TWO(  2.00f),
            ONE(  1.00f),
            HALF_DOLLAR(  0.50f),
            QUARTER(  0.25f),
            DIME(  0.10f),
            NICKEL(  0.05f),
            PENNY(  0.01f);

        private final float value;
        private final String description;

        Denomination(float value) {
            this.value = value;
            this.description = this.name().replace("_", " ");
        }

        public float getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.description;
        }
    }
}