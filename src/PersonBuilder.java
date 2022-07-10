import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private Integer age;
    private String address;
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст должен быть больше 0");
        }
        this.age = age;
        return this;
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException("Необходимо указать имя");
        }
        if (surname == null) {
            throw new IllegalStateException("Необходимо указать фамилию");
        }
        return new Person(name, surname, age, address);
    }
}
