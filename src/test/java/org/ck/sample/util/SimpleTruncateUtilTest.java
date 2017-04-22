package org.ck.sample.util;

import org.ck.sample.App;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {App.class})
public class SimpleTruncateUtilTest {

    @Autowired
    TruncateUtil truncateUtil;

    @Test
    public void testSmallerMessage() {
        String result = truncateUtil.truncate("123456789012345", 25);
        Assert.assertEquals("truncate error", "123456789012345", result);
    }

    @Test
    public void testMessageSameAsSize() {
        String result = truncateUtil.truncate("1234567890123456789012345", 25);
        Assert.assertEquals("truncate error", "1234567890123456789012345", result);
    }

    @Test
    public void testSlightlyLargerMessage() {
        String result = truncateUtil.truncate("12345678901234567890123456", 25);
        Assert.assertEquals("truncate error", "12" + TruncateUtil.truncMessage + "56", result);
    }

    @Test
    public void testLargerMessage() {
        String result = truncateUtil.truncate("12345678901234567890123456789", 25);
        Assert.assertEquals("truncate error", "12" + TruncateUtil.truncMessage + "89", result);
    }

    @Test
    public void testLargerMessage2() {
        String result = truncateUtil.truncate("12345678901234567890123456789", 26);
        Assert.assertEquals("truncate error", "12" + TruncateUtil.truncMessage + "789", result);
    }

    @Test
    public void testEmptyMessage() {
        String result = truncateUtil.truncate("", 20);
        Assert.assertEquals("truncate error", "", result);
    }

    @Test
    public void testSizeSmallerThanTrunkMessage() {
        String result = truncateUtil.truncate("12345678901234567890123456789", 19);
        Assert.assertEquals("truncate error", "12345678901234567890123456789", result);
    }

    @Test
    public void testSizeSameAsTrunkMessage() {
        String result = truncateUtil.truncate("12345678901234567890123456789", 21);
        Assert.assertEquals("truncate error", "12345678901234567890123456789", result);
    }

    public void testSizeSlightlyLargerTrunkMessage() {
        String result = truncateUtil.truncate("12345678901234567890123456789", 22);
        Assert.assertEquals("truncate error", "12345678901234567890123456789", result);
    }
}
