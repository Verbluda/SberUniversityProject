package Homework_3_Part_3;

public class AmazingString {
    private char[] s;
    private int length;
    public AmazingString(char[] s) {
        length = s.length;
        this.s = new char[length];
        for (int i = 0; i < length; i++) {
            this.s[i] = s[i];
        }
    }
    public AmazingString(String s) {
        length = s.length();
        this.s = new char[length];
        for (int i = 0; i < length; i++) {
            this.s[i] = s.charAt(i);
        }
    }
    public char getCharAt(int i) {
        return s[i - 1];
    }
    public int getLength() {
       return length;
    }
    public void printString() {
        for (int i = 0; i < length; i++) {
            System.out.print(s[i]);
        }
        System.out.println();
    }
    public boolean isSubstring(char[] subs) {
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (s[i] == subs[j]) {
                while (s[i] == subs[j] && j < subs.length - 1) {
                    j++;
                    i++;
                }
            }
        }
        if (j == subs.length - 1) {
            return true;
        }
        return false;
    }
    public boolean isSubstring(String subs) {
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (s[i] == subs.charAt(j)) {
                while (s[i] == subs.charAt(j) && j < subs.length() - 1) {
                    j++;
                    i++;
                }
            }
        }
        if (j == subs.length() - 1) {
            return true;
        }
        return false;
    }
    public void trim() {
        int j = 0;
        for (int i = 0; i < length; i++) {
            while (s[i] == ' ') {
                j++;
                i++;
            }
            for (int k = i; k < length; k++) {
                s[k - j] = s[k];
                break;
            }
        }
        char[] temp = new char[length];
        for (int i = 0; i < length; i++) {
            temp[i] = s[i];
        }
        length -= j;
        s = new char[length];
        for (int i = 0; i < length; i++) {
            s[i] = temp[i];
        }
    }
    public void reverse() {
        char[] temp = new char[length];
        for (int i = 0; i < length; i++) {
            temp[i] = s[i];
        }
        for (int i = 0, j = length - 1; i < length && j >= 0; i++, j--) {
            s[i] = temp[j];
        }
    }
}
