package _03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TwoOrMoreClaims {

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new FileReader("/home/kodoj/codecool/adwent/_03/input.txt"));

        List<String> claims = new ArrayList<>();
        String line;
        int[][] fabric = new int [1100][1100];
        String[] currentClaim;
        TwoOrMoreClaims twoOrMoreClaims = new TwoOrMoreClaims();
        int fabricInchesUnderManyClaims = 0;

        while ((line = input.readLine()) != null) {
            claims.add(line);
        }

        int widthPosition;
        int heightPosition;
        int width;
        int height;
        for (int i = 0; i < claims.size(); i++) {
            currentClaim = twoOrMoreClaims.parser(claims.get(i));
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

        for(int i=0; i<fabric.length; i++) {
            for(int j=0; j<fabric[i].length; j++) {
                if (fabric[i][j] > 1) {
                    fabricInchesUnderManyClaims++;
                }
            }
        }

        System.out.println(fabricInchesUnderManyClaims);
    }

    public String[] parser(String line) {
        String[] firstParseLine = line.split(" "); // #1401 @ 432,243: 19x17
        String deletedSpecialCharacter = firstParseLine[2].substring(0, firstParseLine[2].length() - 1);
        String[] secondParseLine = deletedSpecialCharacter.split(",");
        String[] thirdParseLine = firstParseLine[3].split("x");
        String[] answer = Stream.concat(Arrays.stream(secondParseLine), Arrays.stream(thirdParseLine))
                .toArray(String[]::new);
        return answer;
    }
}
