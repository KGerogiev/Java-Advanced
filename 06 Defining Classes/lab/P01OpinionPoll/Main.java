package P01OpinionPoll;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> personSet = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);

            Person person = new Person(name, age);

            personSet.add(person);
        }
        personSet = personSet.stream().filter(e -> e.getAge() > 30)
                                      .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                                      .collect(Collectors.toList());


        for (Person person : personSet) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}
