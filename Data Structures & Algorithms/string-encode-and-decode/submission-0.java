class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String st : strs) {
            sb.append(st.length());
            sb.append('#');
            sb.append(st);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            // 1. Find the '#' that ends the length number
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            // 2. Read the length between i and j
            int length = Integer.parseInt(str.substring(i, j));

            // 3. Take exactly `length` characters after the '#'
            String s = str.substring(j + 1, j + 1 + length);
            result.add(s);

            // 4. Move i to the start of the next encoded string
            i = j + 1 + length;
        }
        return result;
    }
}
