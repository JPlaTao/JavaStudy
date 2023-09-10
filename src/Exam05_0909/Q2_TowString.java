package Exam05_0909;

import java.util.HashMap;
public class Q2_TowString {
    public static void main(String[] args) {
        //测试用例 1
//        String s = "anagram",t = "nagaram";
        //测试用例 2
        String s = "rat",t = "car";

        System.out.println(isAllotropic(s, t));
    }
    public static boolean isAllotropic(String s,String t){
        HashMap<Character,Integer> sHM = computeStr(s);
        HashMap<Character,Integer> tHM = computeStr(t);
        return sHM.equals(tHM);
    }

    public static HashMap<Character,Integer> computeStr(String str){
        HashMap<Character,Integer> hashMap = new HashMap<>();
        //计算字符串中每个字符出现的次数
        for (int i = 0; i < str.length(); i++) {
                hashMap.compute(str.charAt(i),
                        (cKey,iValue)->(iValue==null? 0:iValue+1 )
                );
        }
        return hashMap;
    }

}
