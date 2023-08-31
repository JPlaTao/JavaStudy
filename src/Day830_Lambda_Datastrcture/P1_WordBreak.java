package Day830_Lambda_Datastrcture;

/**
 * @author 25603
 */
public class P1_WordBreak {

    public static void main(String[] args) {
        String string = "catsandog";
        String[] wordDict = {"cats","cat","and","dog"};
        // 输出: true
        System.out.println(wordBreak(string, wordDict));
    }
    /**
     * 判定一个字符串是否全部由给定的字典中的单词组成
     *
     * @param s        需要判断的字符串
     * @param wordDict 字典
     * @return         返回是否全部由字典中的单词组成
     */
    public static boolean wordBreak(String s, String[] wordDict) {
        boolean[] bs = new boolean[s.length()];
        int subStartIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(subStartIndex, i + 1);
            for (String value : wordDict) {
                if (str.equals(value)) {
                    bs[i] = true;
                    subStartIndex = i + 1;
                    break;
                }
            }
        }
        return bs[s.length() - 1];
    }
}
