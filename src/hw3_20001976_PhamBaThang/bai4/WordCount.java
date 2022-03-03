package hw3_20001976_PhamBaThang.bai4;

import java.util.Objects;

public class WordCount {
    private final String word;
    private int count;

    public WordCount(String word) {
        this.word = word;
        this.count = 1;
    }


    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void upCount() {
        this.count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCount wordCount = (WordCount) o;
        return Objects.equals(word, wordCount.word);
    }

    @Override
    public String toString() {
        return "'" + word + '\'' + ":" + count;
    }
}
