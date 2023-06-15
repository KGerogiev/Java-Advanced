package P02CompanyRoster;

import P01OpinionPoll.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> company = new HashMap<>();

        while (n != 0) {
            //Peter 120.00 Dev Development peter@abv.bg 28

            String[] inputArr = scanner.nextLine().split("\\s+");

            if (inputArr.length == 6) {
                String name = inputArr[0];
                double salary = Double.parseDouble(inputArr[1]);
                String position = inputArr[2];
                String department = inputArr[3];
                String email = inputArr[4];
                int age = Integer.parseInt(inputArr[5]);

                Employee employee = new Employee(name, salary, position, department, email, age);

                if (!company.containsKey(department)) {
                    List<Employee> employeeList = new ArrayList<>();
                    employeeList.add(employee);
                    company.put(department, employeeList);
                } else {
                    company.get(department).add(employee);
                }

            } else if (inputArr[4].contains("@")) {
                String name = inputArr[0];
                double salary = Double.parseDouble(inputArr[1]);
                String position = inputArr[2];
                String department = inputArr[3];
                String email = inputArr[4];

                Employee employee = new Employee(name, salary, position, department, email);

                if (!company.containsKey(department)) {
                    List<Employee> employeeList = new ArrayList<>();
                    employeeList.add(employee);
                    company.put(department, employeeList);
                } else {
                    company.get(department).add(employee);
                }
            } else {
                String name = inputArr[0];
                double salary = Double.parseDouble(inputArr[1]);
                String position = inputArr[2];
                String department = inputArr[3];
                int age = Integer.parseInt(inputArr[4]);

                Employee employee = new Employee(name, salary, position, department, age);

                if (!company.containsKey(department)) {
                    List<Employee> employeeList = new ArrayList<>();
                    employeeList.add(employee);
                    company.put(department, employeeList);
                } else {
                    company.get(department).add(employee);
                }
            }
            n--;
        }

        String hiestSellaryDep = "";
        double hiestSellary = 0;

        for (Map.Entry<String, List<Employee>> entry : company.entrySet()) {

            List<Employee> currentList = new ArrayList<>(entry.getValue());
            double totalSellary = 0;

            for (Employee emploee : currentList) {
                totalSellary += emploee.getSalary();
            }

            if (totalSellary > hiestSellary){
                hiestSellary = totalSellary;
                hiestSellaryDep = entry.getKey();
            }
        }

        List<Employee> winList = new ArrayList<>(company.get(hiestSellaryDep));

        TreeSet<Employee> current;
        current = new TreeSet<>(Comparator.comparing(winList::getSalary));


        System.out.println();
    }
}

