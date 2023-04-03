package validator;

import logger.Log;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Validator {
    SoftAssert softAssert;

    public Validator initSoftAssertions() {
        softAssert = new SoftAssert();
        return this;
    }

    public void hardValidate(String str1, String str2) {
        Log.infoBold("Actual is: " + str1);
        Log.infoBold("Expected is: " + str2);
        Assert.assertEquals(str1, str2);
    }

    public void hardValidateEquals(Object obj, Object obj1, String message) {
        Log.infoBold("Actual is: " + obj);
        Log.infoBold("Expected is: " + obj1);
        Assert.assertEquals(obj, obj1, message);
    }

    public void hardValidateNotOrder(List<?> obj1, List<?> obj2) {
        Log.infoBold("Actual list is: " + obj1);
        Log.infoBold("Expected list is: " + obj2);
        Assert.assertEqualsNoOrder(obj1.toArray(), obj2.toArray());
    }

    public void softValidate(String str1, String str2, String descr) {
        Log.infoBold("For " + descr);
        Log.infoBold("Actual is: " + str1);
        Log.infoBold("Expected is: " + str2);
        softAssert.assertEquals(str1, str2);
    }

    public void softValidateNotOrder(List<?> obj1, List<?> obj2) {
        Log.infoBold("Actual list is: " + obj1);
        Log.infoBold("Expected list is: " + obj2);
        softAssert.assertEqualsNoOrder(obj1.toArray(), obj2.toArray());
    }

    public void validateAll() {
        softAssert.assertAll();
    }
}
