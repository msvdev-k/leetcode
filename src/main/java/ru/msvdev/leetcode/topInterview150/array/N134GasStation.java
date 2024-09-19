package ru.msvdev.leetcode.topInterview150.array;

/**
 * 134. Gas Station
 * <p>
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station
 * to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around
 * the circuit once in the clockwise direction, otherwise return -1. If there exists a solution,
 * it is guaranteed to be unique.
 * <p>
 * Example 1:
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 * <p>
 * Example 2:
 * Input: gas = [2,3,4], cost = [3,4,3]
 * Output: -1
 * Explanation:
 * You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
 * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 0. Your tank = 4 - 3 + 2 = 3
 * Travel to station 1. Your tank = 3 - 3 + 3 = 3
 * You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
 * Therefore, you can't travel around the circuit once no matter where you start.
 * <p>
 * Constraints:
 * -- n == gas.length == cost.length
 * -- 1 <= n <= 105
 * -- 0 <= gas[i], cost[i] <= 104
 */
public class N134GasStation {

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int stationCount = gas.length;
        if (stationCount == 1) {
            return (gas[0] >= cost[0]) ? 0 : -1;
        }

        for (int startIdx = 0; startIdx < stationCount; startIdx++) {
            int tank = gas[startIdx] - cost[startIdx];
            if (tank <= 0) continue;

            for (int i = startIdx + 1; i <= startIdx + stationCount; i++) {
                int idx = i % stationCount;
                tank += gas[idx] - cost[idx];
                if (tank < 0) {
                    break;
                }
            }
            if (tank >= 0) return startIdx;
        }

        return -1;
    }


    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int stationCount = gas.length;
        if (stationCount == 1) {
            return (gas[0] >= cost[0]) ? 0 : -1;
        }

        int startIdx = 0;
        int totalTank = 0;
        int currentTank = 0;

        for (int i = 0; i < stationCount; i++) {
            int balance = gas[i] - cost[i];

            totalTank += balance;
            currentTank += balance;

            if (currentTank < 0) {
                currentTank = 0;
                startIdx = i + 1;
            }
        }

        return (totalTank >= 0) ? startIdx : -1;
    }

}
