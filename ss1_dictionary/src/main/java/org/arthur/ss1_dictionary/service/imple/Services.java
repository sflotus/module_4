package org.arthur.ss1_dictionary.service.imple;

import org.arthur.ss1_dictionary.model.Dictionary;
import org.arthur.ss1_dictionary.repository.IRepo;
import org.arthur.ss1_dictionary.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class Services implements IService {
    @Autowired
    IRepo repo;
    @Override
    public String search(String inputWord) {
        return repo.search(inputWord);
    }

    @Override
    public void addNew(Dictionary dictionary) {
    repo.addNew(dictionary);
    }
}
