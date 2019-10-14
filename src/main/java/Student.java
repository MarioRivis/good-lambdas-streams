public class Student {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Student(String name, String email, int age, String university) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.university = university;
    }

    private String name;
    private String email;
    private int age;
    private String university;

    @Override
    public String toString() {
        return name + " " + email + " " + age + " " + university;
    }
}
