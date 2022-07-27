import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;

class Person {
    String forename;
    String surname;
    LocalDate birthday;
    String gender;
    String emailAddress;
    int age;

    public Person(String forename, String surname, LocalDate birthday, String gender, String emailAddress, int age) {
        this.forename = forename;
        this.surname = surname;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}

@FunctionalInterface
interface PersonFactory {
    Person create(String forename, String surname,
                  LocalDate birthday, String gender, String emailAddress, int age);
}


public class Main {
    private void initialize(List<Person> list, PersonFactory factory,
                            String forename, String surname, LocalDate birthday, String gender,
                            String emailAddress, int age) {
        for (int i = 0; i < 10; i++) {
            list.add(factory.create(forename, surname, birthday, gender, emailAddress, age));
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        PersonFactory factory = Person::new;
        ArrayList<Person> list = new ArrayList<>();
        T.initialize(list, factory, "a", "b", LocalDate.parse("2000-11-21"), "asdf", "asf@naver.com", 1);
        for (Person person : list) {
            System.out.println(person);
        }
    }
}