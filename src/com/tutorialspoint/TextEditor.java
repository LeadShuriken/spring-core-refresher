package com.tutorialspoint;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TextEditor {
    // @Autowired
    // @Qualifier("spellChecker2")
    private SpellChecker spellChecker;

    // @Autowired
    @Resource(name = "spellChecker")
    public void setSpellChecker(SpellChecker spellChecker) {
        System.out.println("Inside setSpellChecker.");
        this.spellChecker = spellChecker;
    }

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}