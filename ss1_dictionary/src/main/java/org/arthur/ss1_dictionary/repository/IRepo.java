package org.arthur.ss1_dictionary.repository;

import org.arthur.ss1_dictionary.model.Dictionary;

public interface IRepo {
    String search(String inputWord);
    void  addNew(Dictionary dictionary);
}
