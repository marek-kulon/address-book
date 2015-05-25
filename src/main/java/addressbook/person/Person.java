package addressbook.person;

public class Person {
    private final String name;
    private final String gender;
    private final String dateOfBirth;

    public Person(String name, String gender, String dateOfBirth) {
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
