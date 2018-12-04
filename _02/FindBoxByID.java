package _02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FindBoxByID {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("/home/kodoj/codecool/adwent/_02/input.txt"));

        List<String> boxesIDList = new ArrayList<>();
        String line;

        while ((line = input.readLine()) != null) {
            boxesIDList.add(line);
        }

        FindBoxByID findBoxByID = new FindBoxByID();
        System.out.println(findBoxByID.searchForBox(boxesIDList));


    }

    public String searchForBox(List<String> boxesIDList) {
        String currentlyCheckedBox = "";
        String secondCheckedBox = "";
        int wrongLetters = 0;
        int wrongLetterIndex = 0;
        String answer = "";

        for (int i = 0; i < boxesIDList.size(); i++) {
            currentlyCheckedBox = boxesIDList.get(i);

            for (int j = i + 1; j < boxesIDList.size(); j++) {
                secondCheckedBox = boxesIDList.get(j);
                wrongLetters = 0;

                for (int z = 0; z < currentlyCheckedBox.length(); z++) {
                    if (currentlyCheckedBox.charAt(z) != secondCheckedBox.charAt(z)) {
                        wrongLetters++;
                        wrongLetterIndex = z;
                    }
                    if (wrongLetters > 1) {
                        break;
                    }
                }

                if (wrongLetters == 1) {
                    answer = currentlyCheckedBox.substring(0, wrongLetterIndex);
                    answer += currentlyCheckedBox.substring(wrongLetterIndex + 1);
                    return answer;
                }
            }
        }
        return null;
    }
}
