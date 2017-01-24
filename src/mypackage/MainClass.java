package mypackage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class MainClass {
    public static void main(String[] args) {              ////// Все Exception нужно обработать!!

        if (args.length == 0) {
            System.out.println("Нет параметров.");
        } else {
            System.out.println("Вот и список параметров подкатил:");
            for (String arg : args) {
                System.out.println(arg);
            }
        }

        List<String> list = new ArrayList<>();
        ArrayList<Integer> listInt = new ArrayList<>();
        String inputFileName = "/home/ilya/IdeaProjects/TestSort/src/mypackage/in.txt";
        String outputFileName = "/home/ilya/IdeaProjects/TestSort/src/mypackage/out.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String data;
            while ((data = reader.readLine()) != null) {
                list.add(data);
            }
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException!");
        } catch (IOException e) {
            System.out.println("IOException!");
        }

        for (String line : list) {
            listInt.add(Integer.parseInt(line)); // Можно перенести сразу в try
        }
        insertionSort(listInt);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            String data;
            File file = new File(outputFileName);
            for (Integer num : listInt)
                writer.write(num.toString() + "\n");
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException!");
        } catch (IOException e) {
            System.out.println("IOException!");
        }

    }

    private static void insertionSort(ArrayList<Integer> list) {
        int i, j, newValue;
        for (i = 1; i < list.size(); i++) {
            newValue = list.get(i);
            j = i;
            while (j > 0 && list.get(j - 1) > newValue) {
                list.set(j,list.get(j - 1));
                j--;
            }
            list.set(j,newValue);
        }
    }
}