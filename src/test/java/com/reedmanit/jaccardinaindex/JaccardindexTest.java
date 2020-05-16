/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reedmanit.jaccardinaindex;

import com.reedmanit.jaccardinaindex.JaccardindexTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.similarity.JaccardSimilarity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author paul
 */
public class JaccardindexTest {

    public JaccardindexTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }


    @Test
    // 
    // My way of testing my algorithm.
    // Accepting the Apache approach is unlikely to be defective, then compare what its value to my value
    // If the same, then my approach is accurate.
    //
    public void testSimpleCalculateSimularity() throws Exception {
        System.out.println("calculateSimularity simple");

        Simularity sim = new Simularity();

        String A = RandomStringUtils.randomAscii(20);   // create some random strings
        String B = RandomStringUtils.randomAscii(15);

        

        Double r = calculateApacheSimularity(A.subSequence(0, A.length()), B.subSequence(0, B.length()));  // calculate the apache simularity

        System.out.println("Apache Score is " + r);
        
        sim.calculate(A.subSequence(0, A.length()), B.subSequence(0, B.length()));  // calculate using mine
        
        System.out.println("My Score is " + sim.getSimilarScore());

        System.out.println("A " + A.subSequence(0, A.length()));
        System.out.println("B " + B.subSequence(0, B.length()));

        assertEquals(r, sim.getSimilarScore());  // the two approaches should be equal.

    }

    private Double calculateApacheSimularity(CharSequence inputA, CharSequence inputB) {
        JaccardSimilarity jc = new JaccardSimilarity();
        Double r = jc.apply(inputA, inputB);
        return r = Math.round(r * 100d) / 100d;

    }

}
