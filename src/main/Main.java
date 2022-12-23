package main;

public class Main {
    public static void main(String[] args) {
        String text = "bbbbbbbb";
        String word = "bb";
        wordOccurrence(text, word);
        text = "saleem has read all the books  written by saleem";
        word = "SaleeM";

        System.out.println(numOfOccurrence(text, word));
        System.out.println(wordOccurrence(text, word).length);
        printArray(wordOccurrence(text, word));

    }

    public static int[] wordOccurrence(String text, String word)
    {

        // null
        if(word == null || text == null)
            return null;

        // if search keyword > text => break
        if(word.length() > text.length())
            return null;

        // if keyword or text empty => break
        if(word.length() == 0 || text.length() == 0)
            return null;

        int[] result =new int[text.length()];
        int resultPos = 0;

        int len = word.length();
        word = getLowercase(word);

        // for loop solution
        for(int i = 0; i <= text.length(); i++)
        {
            int posEnd = len + i;
            String keyword = getLowercase(stringSlice(text, i, posEnd));

            if(stringEquals(keyword, word))
            {
                result[resultPos] = i;
                resultPos++;
            }

            if(i + word.length() == text.length())
                break;
        }

        return shrinkArray(result, resultPos);
    }

    public static int numOfOccurrence(String text, String word)
    {
        //null
        if(word == null || text == null)
            throw new NullPointerException();

        // if search keyword > text => break
        if(word.length() > text.length())
            return 0;

        // if keyword or text empty => break
        if(word.length() == 0 || text.length() == 0)
            return 0;

        int len = word.length();
        word = getLowercase(word);

        int count = 0;
        for(int i = 0; i <= text.length(); i++)
        {
            int posEnd = len + i;

            String keyword = getLowercase(stringSlice(text, i, posEnd));

            if(stringEquals(keyword, word))
                count++;

            if(i + word.length() == text.length())
                break;
        }
        return count;
    }


    public static String stringSlice(String text, int start, int end)
    {
        // null check
        if(text == null)
            throw new NullPointerException();

        // bounndaries
        if(start > end || end > text.length())
            throw new ArrayIndexOutOfBoundsException();

        String temp ="";
        for(int i = start; i < end; i++)
        {
            temp += (char)text.charAt(i);
        }
        return temp;
    }

    public static boolean stringEquals(String word1, String word2)
    {
        // null check
        if(word1 == null || word2 == null)
            throw new NullPointerException();

        if(word1.length() != word2.length())
            return false;

        for(int i=0; i < word1.length(); i++)
        {
            if(word1.charAt(i) != word2.charAt(i))
                return false;
        }
        return true;
    }

    public static String getLowercase(String word)
    {
        // uni code
        String temp = "";
        for(int i= 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            temp += (ch >= 65 && ch <= 90) ? (char)(ch+32) : (char)(ch);
        }
        return temp;
    }

    public static int[] shrinkArray(int[] arr, int size)
    {
        int[] temp= new int[size];
        for(int i = 0; i < size; i++)
        {
            temp[i] = arr[i];
        }
        return temp;
    }

    public static void printArray(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
}