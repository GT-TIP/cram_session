import java.util.*;

/**
 * @author: Jenna Kwon jkwon47@gatech.edu. Email if you have any questions!
 *
 * This code is for the workshop at Georgia Tech Technical Interview Prep Club.
 * Slides pertaining to this module's code is at: http://bitly.com/gttip_fall2016_cram_session
 *
 * Problem - Given a dictionary (String[]) and a target word (String),
 * check whether the target word can be made with concatenation of dictionary words.
 *
 * Ex. “amanaplanacanal” -> “a”, “man”, “a”, “plan”, “a”, “canal”
 *
 */

public class Intermediate {

    public static List<String> decomposeIntoWords(String domain, Set<String> dictionary) {

        // list to return
        List<String> strList = new LinkedList<>();

        // ith element in memo tells you whether it is possible to decompose string up to i including i
        boolean[] memo = new boolean[domain.length()];

        for (int i = 0; i < domain.length(); i++) {
            if (dictionary.contains(domain.substring(0, i + 1))) {
                memo[i] = true;
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if (memo[j] && dictionary.contains(domain.substring(j + 1, i + 1))) {
                        memo[i] = true;
                    }
                }
            }
        }

        int lastChar = 0;
        for (int i = 0; i < memo.length; i++) {
            if (memo[i]) {
                strList.add(domain.substring(lastChar, i + 1));
                lastChar = i + 1;
            }
        }

        return strList;
    }


    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("bed");
        dictionary.add("bath");
        dictionary.add("and");
        dictionary.add("hand");
        dictionary.add("beyond");
        List<String> ans = decomposeIntoWords("bedbathandbeyond", dictionary);
        List<String> goldenAns = Arrays.asList("bed", "bath", "and", "beyond");
        System.out.println(ans);
    }
}