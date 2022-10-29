import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        String ans = "";

        int temp;
        if(year%4==0) {
            temp = ((year - 2000) / 4) * 5;
        } else {
            temp = ((year - 2000) / 4) * 5 + (year - 2000) % 4;
        }
        temp = temp%7;

        final String[] week = {"MONDAY","TUESDAY", "WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};
        switch (month) {
            case 1 -> ans = week[(6+temp+day)%7]; //Январь
            case 2 -> ans = week[(2+temp+day)%7]; //Февраль
            case 3 -> ans = week[(2+temp+day)%7]; //Март
            case 4 -> ans = week[(5+temp+day)%7]; //Апрель
            case 5 -> ans = week[(temp+day)%7]; //Май
            case 6 -> ans = week[(3+temp+day)%7]; //Июнь
            case 7 -> ans = week[(5+temp+day)%7]; //Июль
            case 8 -> ans = week[(1+temp+day)%7]; //Август
            case 9 -> ans = week[(4+temp+day)%7]; //Сентябрь
            case 10 -> ans = week[(6+temp+day)%7]; //Октябрь
            case 11 -> ans = week[(2+temp+day)%7]; //Ноябрь
            case 12 -> ans = week[(4+temp+day)%7]; //Декабрь
        }
        return ans;
    }

}

public class Training {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
