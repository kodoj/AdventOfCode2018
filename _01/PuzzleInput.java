package _01;

import java.util.List;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;

public class PuzzleInput {

    // ---- FIRST PART ----//
    // public static void main(String []args) throws IOException{

    // BufferedReader input = new BufferedReader(new FileReader("input.txt"));
    // List<String> lines = new LinkedList<String>();

    // String line;
    // while((line = input.readLine()) != null) {
    //     lines.add(line);
    // }
    // input.close();

    // int sum = 0;

    // for (String entry: lines) {
    //     sum += Integer.valueOf(entry);
    // }

    // System.out.println(sum);
    // }

    public static void main(String []args) throws IOException, FileNotFoundException{

        BufferedReader input = new BufferedReader(new FileReader("/home/kodoj/codecool/adwent/_01/input.txt"));
        List<String> lines = new LinkedList<String>(); 
        String line;

        while((line = input.readLine()) != null) {
            lines.add(line);
        }
        input.close();

        int sum = 0;
        Set<Integer> setOfEntrys = new TreeSet<Integer>();
        int actualLength = 0;
        int lastLength = 0;
        boolean flag = false;

        setOfEntrys.add(0);
        while (flag == false) {
            for (int i = 0; i < lines.size(); i++) {
                sum += Integer.valueOf(lines.get(i));
                setOfEntrys.add(sum);
                actualLength = setOfEntrys.size();
                if (actualLength == lastLength) {
                    System.out.println(sum);
                    flag = true;
                    break;
                } else {
                    lastLength = actualLength;
                }
            }
        }
    }
}