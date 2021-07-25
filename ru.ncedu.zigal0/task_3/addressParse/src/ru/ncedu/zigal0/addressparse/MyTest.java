package ru.ncedu.zigal0.addressparse;

/**
 * My own class for testing Class Address
 *
 * @author zigal0
 */
public class MyTest {
    private final Address forTest = new Address();
    private final Address trueResult = new Address();

    public boolean testRunner() {
        trueResult.setAddress("Russia", "Moscow", "Moscow", "Lenin", 23, 5, 127);
        boolean check;
        check = parseDefault();
        check &= parseWithManySpaces();
        check &= failWithArrayIndexOutOfBoundsException();
        check &= failWithNumberFormatException();
        check &= parseWithOtherMarks();
        check &= failWithArrayIndexOutOfBoundsExceptionOther();
        check &= failWithNumberFormatExceptionOther();
        return check;
    }

    private boolean parseDefault() {
        forTest.parseWithOneMarkAndSpaces("Russia, Moscow, Moscow, Lenin, 23, 5, 127", ",");
        return forTest.equals(trueResult);
    }

    private boolean parseWithManySpaces() {
        forTest.parseWithOneMarkAndSpaces("Russia.       Moscow     . Moscow.Lenin. 23. 5.           127", "\\.");
        return forTest.equals(trueResult);
    }

    private boolean failWithNumberFormatException() {
        try {
            forTest.parseWithOneMarkAndSpaces("Russia. Moscow. Moscow. Lenin. nope. 5. 127", "\\.");
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private boolean failWithArrayIndexOutOfBoundsException() {
        try {
            forTest.parseWithOneMarkAndSpaces("Russia. Moscow. Lenin. 23. 5. 127", "\\.");
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
        return false;
    }

    private boolean parseWithOtherMarks() {
        forTest.parseWithOtherMarks("Russia, Moscow . Moscow, Lenin; 23.     5. 127");
        return forTest.equals(trueResult);
    }

    private boolean failWithNumberFormatExceptionOther() {
        try {
            forTest.parseWithOtherMarks("Russia, Moscow . Moscow, Lenin; 23.     5. nope");
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private boolean failWithArrayIndexOutOfBoundsExceptionOther() {
        try {
            forTest.parseWithOtherMarks("Russia, Moscow . Moscow, Lenin;   5. 127");
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
        return false;
    }
}
