package hw3_20001976.bai4;

import hw3_20001976.bai2.SimpleArrayList;

public class UseArrayList {
    public static void main(String[] args) {
        String[] contents = GetText.getText();
        WordCount wordCount;
        SimpleArrayList<WordCount> wordCounts = new SimpleArrayList<>();
        for (String word : contents) {
            wordCount = new WordCount(word);
            int index = wordCounts.indexOf(wordCount);
            if (index != -1) {
                wordCounts.get(index).upCount();
            } else {
                wordCounts.add(wordCount);
            }
        }
        if (wordCounts.size() == 0) {
            System.out.println("None word");
        }
        for (WordCount wordCountd : wordCounts) {
            System.out.println(wordCountd);
        }
    }
}
