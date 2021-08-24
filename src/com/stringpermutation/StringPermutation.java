package com.stringpermutation;

public class StringPermutation {
    public static void main(String[] args)
    {
        //Print the all Permutations of a given String using Static Function.
        String str = "ABC";
        int n = str.length();
        StringPermutation permutation = new StringPermutation();
        permutation.permute(str, 0, n-1);

        //Print the all Permutations of a given String using Recursive Method.
        String s = "abb";
        printPermutRecursive(s, "");

        //Checking Two Strings are Equal or Not.
        System.out.println("\n" + str.equals(s));
    }

    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    // Function to print all the permutations of str
    static void printPermutRecursive(String str, String ans)
    {

        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recurvise call
            printPermutRecursive(ros, ans + ch);
        }
    }

}
