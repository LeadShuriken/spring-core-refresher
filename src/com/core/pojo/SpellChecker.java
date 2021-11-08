package com.core.pojo;

public class SpellChecker {

    private String checkerName;

    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }

    public SpellChecker() {
        System.out.println("Inside SpellChecker constructor.");
    }

    public void checkSpelling() {
        System.out.println("Inside checkSpelling of : " + checkerName);
    }
}