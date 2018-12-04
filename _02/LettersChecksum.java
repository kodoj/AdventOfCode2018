package _02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LettersChecksum {
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("/home/kodoj/codecool/adwent/_02/input.txt"));
        LettersChecksum lettersChecksum = new LettersChecksum();
        System.out.println(lettersChecksum.getChecksum(input));

    }

    public int getChecksum(BufferedReader reader) throws IOException {
        String line;
        int doubleDigits = 0;
        int tripleDigits = 0;
        while ((line = reader.readLine()) != null) {
            Map<Character, Integer> frequencies = new HashMap<>();
            for (char c : line.toCharArray()) {
                frequencies.merge(c, 1, (oldValue, newValue) -> oldValue + newValue);
            }
            Set<Integer> uniqueFrequencies = new HashSet<>(frequencies.values());
            if (uniqueFrequencies.contains(2)) doubleDigits++;
            if (uniqueFrequencies.contains(3)) tripleDigits++;
        }
        return doubleDigits * tripleDigits;
    }
}