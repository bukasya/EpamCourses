package task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account(5000));
        accounts.add(new Account(4000));

        File ops = new File("src\\operations.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(ops);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String currentLine;

            for (Account a: accounts) {
                System.out.println(a.getBalance());
            }

            while ((currentLine = bufferedReader.readLine()) != null) {
                String newLine = currentLine.replace(':', ' ');
                Scanner scanner = new Scanner(newLine);

                ArrayList<Integer> ints = new ArrayList<>();
                while (scanner.hasNext()) {
                    if (scanner.hasNextInt()) {
                        ints.add(new Integer(scanner.nextInt()));
                    } else {
                        scanner.next();
                    }
                }
                int from = ints.get(0);
                int to = ints.get(1);
                int amount = ints.get(2);


                Account aFrom = accounts.get(from - 1);
                Account aTo = accounts.get(to - 1);

                Thread t1 = new Thread(() -> {
                    aFrom.withdraw(amount);
                });
                Thread t2 = new Thread(() -> {
                    aTo.deposit(amount);
                });

                t1.start();
                t2.start();

                Thread.sleep(100);

            }

            for (Account a: accounts) {
                System.out.println(a.getBalance());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
