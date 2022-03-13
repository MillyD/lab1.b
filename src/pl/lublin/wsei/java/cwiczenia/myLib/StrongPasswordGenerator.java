package pl.lublin.wsei.java.cwiczenia.myLib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StrongPasswordGenerator {
    private int length = 10;
    private boolean lowerCaseLetters = true;
    private boolean upperCaseLetters = false;
    private boolean digits = false;
    private boolean specialCharacters = false;
    private String specialCharactersAllowed = "!@#";

    private CharactersPool charactersPool;

    public StrongPasswordGenerator(int length, boolean lowerCaseLetters,
                                   boolean upperCaseLetters, boolean digits,
                                   boolean specialCharacters, String specialCharactersAllowed) {
        this.length = length;
        this.lowerCaseLetters = lowerCaseLetters;
        this.upperCaseLetters = upperCaseLetters;
        this.digits = digits;
        this.specialCharacters = specialCharacters;
        this.specialCharactersAllowed = specialCharactersAllowed;
        this.charactersPool = new CharactersPool();
    }

    public String generate() {
        char[] password = new char[length];
        List<Integer> randomPasswordPosition = createShuffledNumbers(this.length);
        for (int i = 0; i < length; i++) {
            password[randomPasswordPosition.get(i)] = charactersPool.getRandomChar();
            charactersPool.nextRange();
        }
        return String.valueOf(password);
    }

    private List<Integer> createShuffledNumbers(int length) {
        List<Integer> randomPasswordPosition = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            randomPasswordPosition.add(i);
        }
        Collections.shuffle(randomPasswordPosition);
        return randomPasswordPosition;
    }

    private static class Range {
        private final int count;
        private final int offset;

        public Range(int count, int offset) {
            this.count = count;
            this.offset = offset;
        }

        public int getCount() {
            return count;
        }

        public int getOffset() {
            return offset;
        }
    }

    private class CharactersPool {

        private final List<Character> availableCharacters;
        private final List<Range> ranges;
        private int currentRangeIndex;

        private CharactersPool() {

            this.availableCharacters = new ArrayList<>();
            this.ranges = new ArrayList<>();

            if (digits) {
                ranges.add(new Range(10, 0));
                availableCharacters.addAll(createCharactersPool(48, 10));
            }
            if (upperCaseLetters) {
                ranges.add(new Range(26, availableCharacters.size()));
                availableCharacters.addAll(createCharactersPool(65, 26));
            }
            if (lowerCaseLetters) {
                ranges.add(new Range(26, availableCharacters.size()));
                availableCharacters.addAll(createCharactersPool(97, 26));
            }
            if (specialCharacters) {
                for (int i = 0; i < specialCharactersAllowed.length(); i++) {
                    availableCharacters.add(specialCharactersAllowed.charAt(i));
                }
                ranges.add(new Range(specialCharactersAllowed.length(), availableCharacters.size() - specialCharactersAllowed.length()));
            }
            if (ranges.isEmpty()) {
                throw new IllegalArgumentException();
            }
            this.currentRangeIndex = 0;
        }

        private Character getRandomChar() {
            Random random = new Random();
            int bound = ranges.get(currentRangeIndex).getCount();
            int offset = ranges.get(currentRangeIndex).getOffset();
            return availableCharacters.get(random.nextInt(bound) + offset);
        }

        private void nextRange() {
            currentRangeIndex++;
            if (currentRangeIndex == ranges.size()) {
                currentRangeIndex = 0;
            }
        }

        private List<Character> createCharactersPool(int asciiCode, int count) {
            List<Character> charactersPool = new ArrayList<>();
            for (int i = asciiCode; i < asciiCode + count; i++) {
                charactersPool.add((char) i);
            }
            return charactersPool;
        }

    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isLowerCaseLetters() {
        return lowerCaseLetters;
    }

    public void setLowerCaseLetters(boolean lowerCaseLetters) {
        this.lowerCaseLetters = lowerCaseLetters;
    }

    public boolean isUpperCaseLetters() {
        return upperCaseLetters;
    }

    public void setUpperCaseLetters(boolean upperCaseLetters) {
        this.upperCaseLetters = upperCaseLetters;
    }

    public boolean isDigits() {
        return digits;
    }

    public void setDigits(boolean digits) {
        this.digits = digits;
    }

    public boolean isSpecialCharacters() {
        return specialCharacters;
    }

    public void setSpecialCharacters(boolean specialCharacters) {
        this.specialCharacters = specialCharacters;
    }

    public String getSpecialCharactersAllowed() {
        return specialCharactersAllowed;
    }

    public void setSpecialCharactersAllowed(String specialCharactersAllowed) {
        this.specialCharactersAllowed = specialCharactersAllowed;
    }

    public CharactersPool getCharactersPool() {
        return charactersPool;
    }

    public void setCharactersPool(CharactersPool charactersPool) {
        this.charactersPool = charactersPool;
    }
}
