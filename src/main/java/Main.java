/* COP 3503C Assignment 1
This program is written by: Alexys Veloz */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.io.IOException;

public class Main {
     static int[] getCandidatePair(int A[], int target){
        int  size = A.length;
        int[] answer = new int[2];
        int n = 0; int m = 1;
        while (n != size && m != size)
        {
            System.out.printf("target = m = %d, n = %d, A[n] = %d, A[m] = %d, sum = %d\n", m, n, A[n], A[m], A[n] + A[m]);
            if (n == m){
                m++;
            }
            else if (A[n] + A[m] == target){
                answer[0] = A[n];
                answer[1] = A[m];
                return answer;
            }
            else
            {
                if (A[n] <= A[m] && A[n] + A[m] < target)
                {
                    n++;
                }
                else if (A[n] >= A[m] && A[n] + A[m] < target)
                {
                    m++;
                }
                else if (A[n] + A[m] > target)
                {
                    n--;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        try (Scanner in = new Scanner(Paths.get("in.txt"))) {
            while (in.hasNext()) {
                int total = in.nextInt();
                for (int i = 0; i < total; i++) {

                    int isSorted = in.nextInt();
                    int size = in.nextInt();

                    if (isSorted == 1) { // this is sorted
                        int[] array = new int[size];
                        //do the slmp thing with the rest
                        for (int k = 0; k < size; k++) {
                            array[k] = in.nextInt();
                        }
                        int target = in.nextInt();
                        int[] properAnswer = getCandidatePair(array, target);
                        if (properAnswer[0] == 0 && properAnswer[1] == 0) {
                            System.out.printf("Test case #%d: The target of %d is NOT achievable.\n", i+1, target);
                            target = 0;
                        } else {
                            System.out.printf("Test case #%d: The target of %d is achievable by %d and %d\n", i+1, target, properAnswer[0], properAnswer[1]);
                            target = 0; properAnswer[0] = 0; properAnswer[1] = 0;
                        }
                        //use the function given to us
                        //print
                    } else {
                        HashSet<Integer> curHashSet = new HashSet<>();
                        int[] array = new int[size];
                        for (int k = 0; k < size; k++) {
                            array[k] = in.nextInt();
                        }
                        int target = in.nextInt();
                        //this is not sorted
                        //either use Hashset for full credit or Collections sort for 75%
                        System.out.printf("hey i haven't implemented this yet don't worry\n");
                    }
                }
            }
        }
        catch (IOException | NoSuchElementException | IllegalStateException e)
        {
            e.printStackTrace();
            //Send it to another class
        }
    }
}

