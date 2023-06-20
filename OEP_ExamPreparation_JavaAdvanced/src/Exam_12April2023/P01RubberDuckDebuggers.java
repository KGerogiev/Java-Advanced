package Exam_12April2023;

import java.util.*;
import java.util.stream.Collectors;

public class P01RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] firstLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int [] secondLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        //Създавам ОПАШКА с времената за изпълнение на всяка задача
        ArrayDeque<Integer> time = new ArrayDeque<>();
        for (int i = 0; i < firstLine.length; i++) {
            time.offer(firstLine[i]);
        }

        //Създавам СТЕК с броят на задачите
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        for (int i = 0; i < secondLine.length; i++) {
            tasks.push(secondLine[i]);
        }

        //Създавм Мап със спечелените патета
        Map<String, Integer> duckWon = new LinkedHashMap<>();
        duckWon.put("Darth Vader Ducky", 0);
        duckWon.put("Thor Ducky", 0);
        duckWon.put("Big Blue Rubber Ducky", 0);
        duckWon.put("Small Yellow Rubber Ducky", 0);

        while (!time.isEmpty()){
            //проверявам резултатът от умножението на стойностите
            int currentTime = time.peek();
            int currentTask = tasks.peek();

            int resultTime = currentTime * currentTask;

            //в зависимост от resulTime печеля пате или намалявам задачите и ги връщам в стека
            if (resultTime >= 0 && resultTime <= 60){
                //премахвам стойнстите с СЕТА и ОПАШКАТА
                currentTime = time.poll();
                currentTask = tasks.pop();
                //увеличавам съответното пате с 1
                duckWon.put("Darth Vader Ducky", duckWon.get("Darth Vader Ducky") + 1);

            } else if (resultTime >= 61 && resultTime <= 120){
                //премахвам стойнстите с СЕТА и ОПАШКАТА
                currentTime = time.poll();
                currentTask = tasks.pop();
                //увеличавам съответното пате с 1
                duckWon.put("Thor Ducky", duckWon.get("Thor Ducky") + 1);

            } else if (resultTime >= 121 && resultTime <= 180){
                //премахвам стойнстите с СЕТА и ОПАШКАТА
                currentTime = time.poll();
                currentTask = tasks.pop();
                //увеличавам съответното пате с 1
                duckWon.put("Big Blue Rubber Ducky", duckWon.get("Big Blue Rubber Ducky") + 1);

            } else if (resultTime >= 181 && resultTime <= 240) {
                //премахвам стойнстите с СЕТА и ОПАШКАТА
                currentTime = time.poll();
                currentTask = tasks.pop();
                //увеличавам съответното пате с 1
                duckWon.put("Small Yellow Rubber Ducky", duckWon.get("Small Yellow Rubber Ducky") + 1);

            } else if (resultTime > 240){
                currentTime = time.poll();
                currentTask = tasks.pop() - 2;
                /*if (currentTask < 1){
                    currentTask = 0;
                }*/
                time.offer(currentTime);
                tasks.push(currentTask);

            }
        }
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        for (Map.Entry<String, Integer> duck : duckWon.entrySet()) {
            System.out.printf("%s: %d%n", duck.getKey(), duck.getValue());
        }

    }
}
