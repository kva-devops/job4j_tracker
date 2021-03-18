package ru.job4j.tracker;

public class Proffession {
    private String name;

    private String surname;

    private String education;

    private int birthday;

    private String[] skills;

    private int stageOfWork;

    private int salary;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public int getBirthday() {
        return birthday;
    }
}

class Doctor extends Proffession {
    private String Qualification;

    private String numLicense;

    private String placeOfWork;

    public Diagnosis heal(Patient patient) {}

    public void setRecipe(Patient patient) {}

    public String getNumLicense() {
        return numLicense;
    }

    public String getQualification() {
        return Qualification;
    }
}

class Surgeon extends Doctor {
    private int numberOfOperation;

    private String[] listOfAssistants;

    public void scheduleOfSurgery(Patient patient, Diagnosis diagnosis) {}

    public void appendicitisRemoval(Patient patient, Diagnosis diagnosis) {}

    public String reportOfSurgery() {}
}

class Dentist extends Doctor {

    public void toothExtraction(Patient patient, Diagnosis diagnosis) {}

    public void putFilling(Patient patient, Diagnosis diagnosis) {}
}

class Patient {
    private String name;
    private int age;
    private Recipe recipe;

    public Diagnosis getDiagnosis() {
        return null;
    }
}

class Diagnosis {}

class Recipe extends Diagnosis {
    private String title;

    public String getRecipe() {
        return title;
    }

    public void setRecipe(String recipe) {
        this.title = recipe;
    }
}

class Engineer extends Proffession {
    private String[] listOfPossibleWorks;

    public Project createProject(Client client) {}
}

class Programmer extends Engineer {

    public WebSite createWebSite(Project project, Client client) {}

    public MobileApp createMobApp(Project project, Client client) {}

    public void hacking(WebSite name) {}

    public void hacking(MobileApp name) {}
}

class Builder extends Engineer {

    public Shed buildingShed(Project project, Client client) {}

    public House buildingHouse(Project project, Client client) {}
}

class Project {}

class WebSite {}

class MobileApp {}

class Shed {}

class House {}

class Client {}