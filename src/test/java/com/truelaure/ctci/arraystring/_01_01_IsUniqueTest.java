package com.truelaure.ctci.arraystring;

import org.junit.Assert;
import org.junit.Test;

public class _01_01_IsUniqueTest {
    @Test
    public void isUnique() throws Exception {
        Assert.assertTrue(new _01_01_IsUnique().isUnique(""));

        Assert.assertFalse(new _01_01_IsUnique().isUnique("aa"));
        Assert.assertFalse(new _01_01_IsUnique().isUnique("abcda"));

        Assert.assertTrue(new _01_01_IsUnique().isUnique("abcde"));
    }

}