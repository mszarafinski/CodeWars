package com.company;

public class Main {

    public static void main(String[] args) {
        String str = "Dura lex[ sed lex]";

        System.out.println(pigIt(str));

    }

    public static String pigIt(String str){
        String changedStr;

        String[] strTab = str.split(" ");

        StringBuilder sbSentence = new StringBuilder("");

        for (String s : strTab) {

            if (s.length()==1 && Character.isLetter(s.charAt(0))) {
                sbSentence.append(s);
                continue;
            }

            StringBuilder sbWord = new StringBuilder(s);

            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);

            if (!Character.isLetter(first)) {
                sbWord.deleteCharAt(0);
            }
            if (!Character.isLetter(last)) {
                sbWord.deleteCharAt(s.length() - 1);
            }

            sbWord
                    .append(sbWord.charAt(0))
                    .append("ay")
                    .deleteCharAt(0);

            if (!Character.isLetter(first)) {
                sbWord.insert(0,first);
            }
            if (!Character.isLetter(last)) {
                sbWord.append(last);
            }

            String modified = sbWord.toString();

            sbSentence.append(modified);

            if (s.equals(strTab[strTab.length - 1])) {
                break;
            }
            sbSentence.append(" ");

        }

        changedStr = sbSentence.toString();

        return changedStr;

    }
}
