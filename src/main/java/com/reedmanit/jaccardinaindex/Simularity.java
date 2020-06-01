/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reedmanit.jaccardinaindex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author paul
 */
public class Simularity implements SimularityAlgorithm {

    private Double similarScore;

    public Simularity() {

    }

    //
    // This is my way of calculating similarity score. Different from others
    // This is a test comment
    //
    public void calculate(CharSequence A, CharSequence B) {

        if ((A == null) || (B == null)) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        Set<String> union = new HashSet<String>();   // create two hashsets, a union and a intersection
        Set<String> intersection = new HashSet<String>();

        int lenA = A.length();  // find the length of each input item
        int lenB = B.length();

        for (int i = 0; i < lenA; i++) {
            union.add(String.valueOf(A.charAt(i)));    // put the values of input a into union
        }
        for (int x = 0; x < lenB; x++) {
            union.add(String.valueOf(B.charAt(x)));   // put the values of input b into union, duplicates will be ignored because of Hashset

        }

        for (int i = 0; i < lenA; i++) {
            for (int x = 0; x < lenB; x++) {
                String p = String.valueOf(B.charAt(x));  // put the value of A and B into a string
                String r = String.valueOf(A.charAt(i));
                if (p.equals(r)) {                      // do these values equal to each other.?   
                    intersection.add(String.valueOf(A.charAt(i)));   // yes, the values are the same so we have a common element, put this into intersection
                }
            }
        }

        similarScore = Double.valueOf(intersection.size()) / Double.valueOf(union.size());   // score = intersection.size / union.size
        similarScore = Math.round(similarScore * 100d) / 100d;  // express score as a decimal. 1.0 the same, 0.1 very different

    }

    /**
     * @return the similarScore
     */
    public Double getSimilarScore() {
        return similarScore;
    }

}
