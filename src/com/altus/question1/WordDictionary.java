package com.altus.question1;

import java.util.ArrayList;
import java.util.List;

/**
 * WordDictionary allows for storage, retrieval, and management of words and their definitions.
 */
public class WordDictionary {

    private static class Entry {
        String word;
        String definition;
        Entry next;

        Entry(String word, String definition) {
            this.word = word;
            this.definition = definition;
        }
    }

    private Entry[] entries;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    /**
     * Create a new WordDictionary with default capacity.
     */
    public WordDictionary() {
        this.entries = new Entry[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Add a word and its definition to the dictionary.
     * @param word Word to be added.
     * @param definition Definition of the word.
     */
    public void insertWord(String word, String definition) {
        validateInput(word, definition);

        if (needResize()) {
            resize();
        }

        int index = getHashIndex(word);
        Entry newEntry = new Entry(word.toLowerCase(), definition);
        newEntry.next = entries[index];
        entries[index] = newEntry;
        size++;
    }

    /**
     * Fetch definition of a word from the dictionary.
     * @param word Word to find.
     * @return Definition of the word. Null if not found.
     */
    public String findDefinition(String word) {
        validateInput(word);

        int index = getHashIndex(word);
        Entry current = entries[index];

        while (current != null) {
            if (current.word.equalsIgnoreCase(word)) {
                return current.definition;
            }
            current = current.next;
        }

        return null;
    }

    /**
     * Search for words that contain a particular string.
     * @param partialWord String to search for within words.
     * @return List of definitions for words that contain partialWord.
     */
    public List<String> partialSearch(String partialWord) {
        validateInput(partialWord);

        List<String> results = new ArrayList<>();
        for (Entry entry : entries) {
            Entry current = entry;

            while (current != null) {
                if (current.word.contains(partialWord.toLowerCase())) {
                    results.add(current.definition);
                }
                current = current.next;
            }
        }
        return results;
    }

    /**
     * Remove a word and its definition from the dictionary.
     * @param word Word to be removed.
     */
    public void remove(String word) {
        validateInput(word);

        int index = getHashIndex(word);
        Entry current = entries[index];
        Entry prev = null;

        while (current != null) {
            if (current.word.equalsIgnoreCase(word)) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    entries[index] = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    private int getHashIndex(String word) {
        return Math.abs(word.toLowerCase().hashCode()) % entries.length;
    }

    private boolean needResize() {
        return size > entries.length * LOAD_FACTOR;
    }

    private void resize() {
        int newCapacity = entries.length * 2;
        Entry[] newEntries = new Entry[newCapacity];

        for (Entry entry : entries) {
            Entry current = entry;

            while (current != null) {
                int newIndex = getHashIndex(current.word);
                Entry newEntry = new Entry(current.word, current.definition);
                newEntry.next = newEntries[newIndex];
                newEntries[newIndex] = newEntry;
                current = current.next;
            }
        }
        entries = newEntries;
    }

    private void validateInput(String... values) {
        for (String value : values) {
            if (value == null || value.isEmpty()) {
                throw new IllegalArgumentException("Input cannot be null or empty.");
            }
        }
    }

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();

        dictionary.insertWord("Apple", "A common fruit.");
        dictionary.insertWord("Banana", "A common fruit, typically yellow.");

        System.out.println("applE: " + dictionary.findDefinition("applE"));
        System.out.println("banana: " + dictionary.findDefinition("banana"));

        dictionary.remove("bANana");
        System.out.println("bANana (After Removal): " + dictionary.findDefinition("banana"));

        dictionary.insertWord("grape", "A sweet fruit.");
        dictionary.insertWord("mango", "A juicy fruit.");

        System.out.println("Partial search for 'a': " + dictionary.partialSearch("a"));
    }
}

/*
insertWord Method:
    TC = O(1) average, O(n) worst
    SC: O(1)
findDefinition Method
    TC: O(1) average, O(n) worst
    SC: O(1)
partialSearch Method
    TC: O(n * k)
    SC: O(m)
remove Method
    TC: O(1) average, O(n) worst
    SC: O(1)
Note: n is the number of entries, k is the size of words, and m is the number of matches found in partial search.
 */