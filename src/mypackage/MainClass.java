package mypackage;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
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

        if (args.length != 4 ) {
            System.out.println("Wrong number of args.");
        }

        List<String> list = new ArrayList<>();
        ArrayList<Integer> listInt = new ArrayList<>();

        String inputFileName = "/home/ilya/IdeaProjects/TestSort/src/mypackage/in.txt";
        //String inputFileName = args[0];
        String outputFileName = "/home/ilya/IdeaProjects/TestSort/src/mypackage/out.txt";
        //String outputFileName = args[1];

        readFile(inputFileName);
        writeFileInt(outputFileName, listInt);


        for (String line : list) {
            listInt.add(Integer.parseInt(line)); // Можно перенести сразу в try
        }
        insertionSort(listInt);



    }

    private static ArrayList<String> readFile(String inputFileName) {
        ArrayList<String> list = new ArrayList<>();
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
        return list;
    }

    private static void writeFileInt(String outputFileName, ArrayList<Integer> listInt) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            new File(outputFileName);
            for (Integer num : listInt)
                writer.write(num.toString() + "\n");
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException!");
        } catch (IOException e) {
            System.out.println("IOException!");
        }
        System.out.println("Файл записан");
    }

    private static void writeFileString(String outputFileName, ArrayList<String> listInt) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            new File(outputFileName);
            //for (Integer num : listInt)
                //writer.write(num.toString() + "\n");
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException!");
        } catch (IOException e) {
            System.out.println("IOException!");
        }
        System.out.println("Файл записан");
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