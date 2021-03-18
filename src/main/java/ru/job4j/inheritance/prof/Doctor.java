package ru.job4j.inheritance.prof;

class Doctor extends Proffession {
    private String Qualification;

    private String numLicense;

    private String placeOfWork;

    public Diagnosis heal(Patient patient) {
        return null;
    }

    public void setRecipe(Patient patient) {
    }

    public String getNumLicense() {
        return numLicense;
    }

    public String getQualification() {
        return Qualification;
    }
}
