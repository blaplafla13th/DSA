package hw3_20001976_PhamBaThang.bai4;

import hw3_20001976_PhamBaThang.bai2.SimpleArrayList;

public class UseArrayList {
    public static void main(String[] args) {
        String[] contents = GetText.getText();
        SimpleArrayList<WordCount> wordCounts = new SimpleArrayList<>();
        for (String word : contents) {
            WordCount wordCount = new WordCount(word);
            if (wordCounts.isContain(wordCount)) {
                wordCounts.get(wordCounts.indexOf(wordCount)).upCount();
            } else {
                wordCounts.add(wordCount);
            }
        }
        for (WordCount wordCount : wordCounts) {
            System.out.println(wordCount);
        }
    }
}
