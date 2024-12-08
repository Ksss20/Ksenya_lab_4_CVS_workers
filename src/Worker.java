public class Worker {
    private int id;
    private String name;
    private String gender;
    private String birthDate;
    private Division division;
    private double salary;

    public Worker(int id, String name, String gender, String birthDate, Division division, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.division = division;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Division getDivision() {
        return division;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", division=" + division +
                ", salary=" + salary +
                '}';
    }
}
