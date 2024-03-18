package org.arthur.ss1_dictionary.model;

public class Dictionary {
    private String VNWord;
    private String ENGWord;

    public Dictionary(String VNWord, String ENGWord) {
        this.VNWord = VNWord;
        this.ENGWord = ENGWord;
    }

    public String getVNWord() {
        return VNWord;
    }

    public void setVNWord(String VNWord) {
        this.VNWord = VNWord;
    }

    public String getENGWord() {
        return ENGWord;
    }

    public void setENGWord(String ENGWord) {
        this.ENGWord = ENGWord;
    }
}
