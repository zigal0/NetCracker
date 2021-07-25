package ru.ncedu.zigal0.addressparse;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;


import static org.junit.Assert.*;

/**
 * First experience with JUnit
 *
 * @author zigal0
 */
public class AddressTest {

    @Rule
    public TestRule globalTimeout = new DisableOnDebug(Timeout.seconds(1));

    private final Address forTest = new Address();
    private final Address trueResult = new Address();

    @Before
    public void setUp() {
        trueResult.setAddress("Russia", "Moscow", "Moscow", "Lenin", 23, 5, 127);
    }

    @Test
    public void parseDefault() {
        forTest.parseWithOneMarkAndSpaces("Russia, Moscow, Moscow, Lenin, 23, 5, 127", ",");
        assertEquals(trueResult, forTest);
    }

    @Test
    public void parseWithManySpaces() {
        forTest.parseWithOneMarkAndSpaces("Russia.       Moscow     . Moscow.Lenin. 23. 5.           127", "\\.");
        assertEquals(trueResult, forTest);
    }

    @Test(expected = NumberFormatException.class)
    public void failWithNumberFormatException() {
        forTest.parseWithOneMarkAndSpaces("Russia. Moscow. Moscow. Lenin. nope. 5. 127", "\\.");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void failWithArrayIndexOutOfBoundsException() {
        forTest.parseWithOneMarkAndSpaces("Russia. Moscow. Lenin. 23. 5. 127", "\\.");
    }

    @Test
    public void parseWithOtherMarks() {
        forTest.parseWithOtherMarks("Russia, Moscow . Moscow, Lenin; 23.     5. 127");
        assertEquals(forTest, trueResult);
    }

    @Test(expected = NumberFormatException.class)
    public void failWithNumberFormatExceptionOther() {
        forTest.parseWithOtherMarks("Russia, Moscow . Moscow, Lenin; 23.     5. nope");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void failWithArrayIndexOutOfBoundsExceptionOther() {
        forTest.parseWithOtherMarks("Russia, Moscow . Moscow, Lenin;   5. 127");
    }
}