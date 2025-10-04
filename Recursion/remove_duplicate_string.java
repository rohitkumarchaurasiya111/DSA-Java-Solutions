package Recursion;

public class remove_duplicate_string {
    public static void main(String args[]) {
        String name = "appnacollege";
        StringBuilder sb = new StringBuilder(""); //To store new string without duplicate characters
        boolean arr[] = new boolean[26]; //It indicates that the character is present in new string or not
        System.out.println(remove_dub(name, 0, sb, arr));
    }

    public static String remove_dub(String name, int i, StringBuilder sb, boolean arr[]) { // This function gives the string without duplicate characters
        char ch = name.charAt(i);  //It stores the character at specific location
        if (i == name.length() - 1) {  //It returns the new string if old string with duplicates is iterated to it's last character
            return sb.toString();
        }

        if (arr[ch - 'a']) { 
            remove_dub(name, i + 1, sb, arr); //If character is already present then it will iternal to i+1 character. The character is already present is indicated by arr[]
        } else {
            arr[ch - 'a'] = true;  // If character is not present then the character is added to new string and the arr corresponding to that character is made true
            sb.append(ch);
            remove_dub(name, i + 1, sb, arr);
        }
    
        return sb.toString();
    }
}
