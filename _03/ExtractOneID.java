package _03;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ExtractOneID {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new FileReader("/home/kodoj/codecool/adwent/_03/input.txt"));

        List<String> claims = new ArrayList<>();
        String line;
        int[][] fabric = new int [1100][1100];
        String[] currentClaim;
        ExtractOneID extractOneID = new ExtractOneID();

        while ((line = input.readLine()) != null) {
            claims.add(line);
        }

        int widthPosition;
        int heightPosition;
        int width;
        int height;
        for (int i = 0; i < claims.size(); i++) {
            currentClaim = extractOneID.parser(claims.get(i));
            heightPosition = Integer.valueOf(currentClaim[1]) + 1;
            widthPosition = Integer.valueOf(currentClaim[0]) + 1;
            width = Integer.valueOf(currentClaim[2]);
            height = Integer.valueOf(currentClaim[3]);


            for (int j = heightPosition; j < heightPosition + height; j++) {
                for (int z = widthPosition; z < widthPosition + width ; z++) {
                    fabric[j][z]++;
                }
            }
        }

        String ID;
        for (int i = 0; i < claims.size(); i++) {
            currentClaim = extractOneID.parser(claims.get(i));
            heightPosition = Integer.valueOf(currentClaim[1]) + 1;
            widthPosition = Integer.valueOf(currentClaim[0]) + 1;
            width = Integer.valueOf(currentClaim[2]);
            height = Integer.valueOf(currentClaim[3]);
            ID = currentClaim[4];
            boolean correctClaim = true;

            for (int j = heightPosition; j < heightPosition + height; j++) {
                for (int z = widthPosition; z < widthPosition + width ; z++) {
                    if(fabric[j][z] != 1) {
                        correctClaim = false;
                    }
                }
            }
            if(correctClaim == true) {
                System.out.println(ID);
            }
        }
//        for(int i = 0; i<1100; i++)
//        {
//            for(int j = 0; j<1100; j++)
//            {
//                System.out.print(fabric[i][j]);
//            }
//            System.out.println();
//        }

    }

    public String[] parser(String line) {
        String[] firstParseLine = line.split(" "); // #1401 @ 432,243: 19x17
        String deletedSpecialCharacter = firstParseLine[2].substring(0, firstParseLine[2].length() - 1);
        String[] secondParseLine = deletedSpecialCharacter.split(",");
        String[] thirdParseLine = firstParseLine[3].split("x");
        String ID = firstParseLine[0];

        String [] answerWithID  = Arrays.copyOf(secondParseLine, 5);
        answerWithID[2] = thirdParseLine[0];
        answerWithID[3] = thirdParseLine[1];
        answerWithID[4] = ID;
        return answerWithID;
    }
}