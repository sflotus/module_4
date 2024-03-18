package org.arthur.ss1_dictionary.service;

import org.arthur.ss1_dictionary.model.Dictionary;

public interface IService {
    String search(String inputWord);
    void  addNew(Dictionary dictionary);
}
