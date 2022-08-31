import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Task01 {

    public static void main (String[] args) {

        File file = new File("Calc1.stk");
        ArrayList<String> input = new ArrayList<String>();

        try (Scanner in = new Scanner(file, StandardCharsets.UTF_8)) {
            while(in.hasNextLine()) {
                String x = in.nextLine();
                input.add(x);
            }
        } catch (IOException e ){
            e.printStackTrace();
        }

        Iterator<String> iterator = input.iterator();
        Stack<Integer> stackpile = new Stack<Integer>();

        Integer output = 0;

        while(iterator.hasNext()) {
            String rpnElemenString = iterator.next();

            if (stackpile.size() < 2) {
                output = Integer.parseInt(rpnElemenString);
            } else {
                Integer segundo = stackpile.pop();
                Integer primeiro = stackpile.pop();

                if (rpnElemenString.equals("+")) output = primeiro + segundo;
                else if (rpnElemenString.equals("-")) output = primeiro - segundo;
                else if (rpnElemenString.equals("*")) output = primeiro * segundo;
                else if (rpnElemenString.equals("/")) output = primeiro / segundo;
                 
            }

            stackpile.add(output);
        }

        Integer out = stackpile.pop();
        System.out.println("O resultado é: " + out);
    }
}