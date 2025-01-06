package ru.msvdev.tcode.exam202411;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Задание потеряно
 */
public class Task02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int previousDepth = scanner.nextInt();

        int[] depthPerDay = new int[n];
        depthPerDay[0] = previousDepth;

        for (int i = 1; i < n; i++) {
            int currentDepth = scanner.nextInt();

            if (currentDepth > 0) {
                int delta = currentDepth - previousDepth;

                if (delta > 0) {
                    depthPerDay[i] = delta;
                    previousDepth = currentDepth;

                } else {
                    System.out.println("NO");
                    return;
                }

            } else {
                depthPerDay[i] = 1;
                previousDepth++;
            }
        }

        String output = Arrays.stream(depthPerDay)
                .boxed()
                .map(Objects::toString)
                .collect(Collectors.joining(" "));

        System.out.println("YES");
        System.out.println(output);

//        for (int depth : depthPerDay) {
//            System.out.print(depth);
//            System.out.print(" ");
//        }
    }
}
