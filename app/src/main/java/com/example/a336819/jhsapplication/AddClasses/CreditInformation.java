package com.example.a336819.jhsapplication.AddClasses;

public class CreditInformation {
    int math;
    int english;
    int science;
    int elective;
    int language;
    boolean languagemet;
    int socialStudies;
    int fineArts;
    int fitness;
    int CTE;

    public CreditInformation(int CTE, int elective,int english,int  finearts, int fitness ,int language,int math, int science,int socialstudies) {
        this.CTE = CTE;
        this.elective = elective;
        this.fineArts=finearts;
        this.english=english;
        this.fitness=fitness;
        this.language=language;
        this.math=math;
        this.science=science;
        this.socialStudies=socialstudies;

    }
    public CreditInformation() {

    }

    public int getCTE() {
        return CTE;
    }

    public int getElective() {
        return elective;
    }

    public int getEnglish() {
        return english;
    }

    public int getFineArts() {
        return fineArts;
    }

    public int getFitness() {
        return fitness;
    }

    public int getLanguage() {
        return language;
    }

    public int getMath() {
        return math;
    }

    public int getScience() {
        return science;
    }

    public int getSocialStudies() {
        return socialStudies;
    }

    public void setCTE(int CTE) {
        this.CTE = CTE;
    }

    public void setElective(int elective) {
        this.elective = elective;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public void setFineArts(int fineArts) {
        this.fineArts = fineArts;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public void setSocialStudies(int socialStudies) {
        this.socialStudies = socialStudies;
    }

    public boolean isLanguagemet() {
        return languagemet;
    }

    public void setLanguagemet(boolean languagemet) {
        this.languagemet = languagemet;
    }

}
