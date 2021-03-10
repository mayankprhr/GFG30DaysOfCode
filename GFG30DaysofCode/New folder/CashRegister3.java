import java.io.*;

public class CashRegister3 {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while((line=in.readLine())!=null)
        {
            printCashChange(line);
        }
    }    

    public enum Denomination
    {
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
            private final String desc;

            Denomination (float value)
            {
                this.value=value;
                this.desc=this.name().replace("_", " ");
            } 

            public float getValue()
            {
                return this.value;
            }

            public String toString()
            {
                return this.desc;
            }

    }

    public static String getCashChange(float cash,float price)
    {
        if (cash<price) return "ERROR";
        if (cash==price) return "ZERO";
        
        float cashBack=cash-price;

        StringBuilder change = new StringBuilder();
        for (Denomination d: Denomination.values())
        {
            while (cashBack>=d.getValue())
            {
                cashBack=cashBack-d.getValue();
                change=change.append(d).append(",");
            }
        }

        return change.toString().substring(0, change.length()-1);
    }

    public static void printCashChange(String line)
    {
        String fields[]=line.split(";",2);
        
        float pp=Float.parseFloat(fields[0]);
        float ch=Float.parseFloat(fields[1]);

        System.out.println(getCashChange(pp,ch));
    }

}
