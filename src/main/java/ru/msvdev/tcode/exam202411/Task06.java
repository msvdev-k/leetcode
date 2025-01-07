package ru.msvdev.tcode.exam202411;

import java.util.*;


/**
 * Дана некоторая система для обработки данных. Все задачи в этой системе могут выполняться параллельно,
 * причём распараллеливать задачи можно до бесконечности. Каждая задача выполняется некоторое определённое
 * время. Решение некоторых задач может зависеть от решения других задач. Это означает, что зависимые задачи
 * запускаются на выполнение только после завершения всех задач от которых они зависят.
 * <p>
 * Гарантируется, что все задачи завершатся за конечное время, и среди них нет циклических зависимостей.
 * <p>
 * Определить минимальное время за которое вычислительная система сможет решить весь набор задач.
 * При подсчёте минимального времени учитывать только время решения задач, временем переключения между
 * задачами пренебречь.
 * <p>
 * Формат входных данных:
 * -- В первой строке дано число N, определяющее количество решаемых задач.
 * -- Далее перечисляются N строк. В каждой строке указывается несколько целых чисел разделённых пробелами.
 * Первое число задаёт условное время выполнения задачи. Оставшиеся числа со второго до последнего
 * (если они есть) соответствуют номерам задач, от которых зависит решение текущей задачи (нумерация
 * начинается с единицы).
 * <p>
 * Формат выходных данных:
 * -- Минимальное время выполнения всех задач.
 * <p>
 * Пример входных и выходных данных можно посмотреть в тестах.
 */
public class Task06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int processCount = Integer.parseInt(scanner.nextLine());

        long[] processTime = new long[processCount];
        Map<Integer, Set<Integer>> dependencies = new HashMap<>(processCount);

        for (int i = 0; i < processCount; i++) {
            String[] data = scanner.nextLine().split(" ");
            processTime[i] = Long.parseLong(data[0]);

            Set<Integer> depend = new HashSet<>();
            for (int j = 1; j < data.length; j++) {
                depend.add(Integer.parseInt(data[j]) - 1);
            }

            if (!depend.isEmpty()) {
                dependencies.put(i, depend);
            }
        }


        List<Integer> stopProcess = new ArrayList<>();
        while (!dependencies.isEmpty()) {
            for (Map.Entry<Integer, Set<Integer>> entry : dependencies.entrySet()) {
                boolean endProcessFlag = true;
                long maxTimeShift = 0;

                for (Integer parentProcess : entry.getValue()) {
                    if (dependencies.containsKey(parentProcess)) {
                        endProcessFlag = false;
                        break;
                    }
                    if (maxTimeShift < processTime[parentProcess]) {
                        maxTimeShift = processTime[parentProcess];
                    }
                }

                if (endProcessFlag) {
                    Integer processId = entry.getKey();
                    processTime[processId] += maxTimeShift;
                    stopProcess.add(processId);
                }
            }

            for (Integer processId : stopProcess) {
                dependencies.remove(processId);
            }

            stopProcess.clear();
        }

        long totalTime = processTime[0];
        for (int i = 1; i < processTime.length; i++) {
            if (totalTime < processTime[i]) {
                totalTime = processTime[i];
            }
        }

        System.out.println(totalTime);
    }

}
