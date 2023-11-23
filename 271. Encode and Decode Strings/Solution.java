public class Solution {

    public static final char SYMBOL = '@';

    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here

        String encoded = "";
        for (String str: strs) {
            encoded += "" + str.length() + SYMBOL + str;
        }

        System.out.println(encoded);

        return encoded;
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here

        List<String> strs = new ArrayList<>();

        int index = 0;
        while (index < str.length()) {
            int symbolIndex = str.indexOf(SYMBOL, index);
            int length = Integer.parseInt(str.substring(index, symbolIndex));
            strs.add(str.substring(symbolIndex + 1, symbolIndex + length + 1));
            index = symbolIndex + length + 1;
        }

        return strs;
    }
}