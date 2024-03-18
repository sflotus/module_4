package org.arthur.ss1_dictionary.repository.imple;

import org.arthur.ss1_dictionary.model.Dictionary;
import org.arthur.ss1_dictionary.repository.IRepo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class Repo implements IRepo {
    static Map<String,String> dictionaryMap = new HashMap<>();
    static {
        dictionaryMap.put("Car","Xe");
        dictionaryMap.put("Dog","Con Cho");
        dictionaryMap.put("Cat","Con Meo");
        dictionaryMap.put("Pig","Con Heo");
    }
    @Override
    public String search(String inputWord) {
        return dictionaryMap.get(inputWord);
    }

    @Override
    public void addNew(Dictionary dictionary) {
        dictionaryMap.put(dictionary.getENGWord(), dictionary.getVNWord());
    }
}
