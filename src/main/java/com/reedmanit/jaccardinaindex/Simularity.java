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
public class Simularity {

    private Double similarScore;

    public Simularity() {

    }

    public void calculate(CharSequence A, CharSequence B) {

        if ((A == null) || (B == null)) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        Set<String> union = new HashSet<String>();
        Set<String> intersection = new HashSet<String>();

        int lenA = A.length();
        int lenB = B.length();

        for (int i = 0; i < lenA; i++) {
            union.add(String.valueOf(A.charAt(i)));
        }
        for (int x = 0; x < lenB; x++) {
            union.add(String.valueOf(B.charAt(x)));

        }

        for (int i = 0; i < lenA; i++) {
            for (int x = 0; x < lenB; x++) {
                String p = String.valueOf(B.charAt(x));
                String r = String.valueOf(A.charAt(i));
                if (p.equals(r)) {
                    intersection.add(String.valueOf(A.charAt(i)));
                }
            }
        }

        similarScore = Double.valueOf(intersection.size()) / Double.valueOf(union.size());
        similarScore = Math.round(similarScore * 100d) / 100d;

    }

    /**
     * @return the similarScore
     */
    public Double getSimilarScore() {
        return similarScore;
    }

    /**
     * @param similarScore the similarScore to set
     */
    public void setSimilarScore(Double similarScore) {
        this.similarScore = similarScore;
    }

}
