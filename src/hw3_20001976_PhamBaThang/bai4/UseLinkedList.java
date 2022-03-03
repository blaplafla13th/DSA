package hw3_20001976_PhamBaThang.bai4;

import hw3_20001976_PhamBaThang.bai3.SimpleLinkedList;

public class UseLinkedList {
    public static void main(String[] args) {
        String[] contents = GetText.getText();
        SimpleLinkedList<WordCount> wordCounts = new SimpleLinkedList<>();
        for (String word : contents) {
            WordCount wordCount = new WordCount(word);
            if (wordCounts.isContain(wordCount)) {
                wordCounts.get(wordCounts.indexOf(wordCount)).upCount();
            } else {
                wordCounts.add(wordCount);
            }
        }
        if (wordCounts.size() == 0) {
            System.out.println("None word");
        }
        for (int i = 0; i < wordCounts.size(); i++) {
            System.out.println(wordCounts.get(i));
        }
    }
}
