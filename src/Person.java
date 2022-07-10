import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Person{
    protected final String name;
    protected final String surname;
    private Integer age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, Integer age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age != null;
        //return getAge().isPresent();
    }
    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public OptionalInt getAge() {
        if (hasAge()) {
            return OptionalInt.of(age);
        }
        return OptionalInt.empty();
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void happyBirthday() {
        if (hasAge()) {
        age++;
        }
    }

    @Override
    public String toString() {
        return name + " " + surname + " в возрасте " + age + " год" + " проживает в " + address;
    }

   @Override
    public int hashCode() {
       return Objects.hash(getName(), getSurname(), getAge(), getAddress());
    }

    public PersonBuilder newChildBuilder() {return new PersonBuilder()
            .setSurname(surname)
            .setAge(age)
            .setAddress(address);}
}
