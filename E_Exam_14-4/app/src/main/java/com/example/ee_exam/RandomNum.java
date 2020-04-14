package com.example.ee_exam;

import java.security.SecureRandom;

public class RandomNum {
    int[] createRD(int from, int to) {
        int n =(to - from )+ 1;
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }

        int[] result = new int[n];
        int x = n;
        SecureRandom rd = new SecureRandom();
        for (int i = 0; i < n; i++) {
            int k = rd.nextInt(x);
            result[i] = a[k];
            a[k] = a[x - 1];
            x--;
        }
        return result;
    }
}


