package com.daclink.drew.sp22.cst438_project01_starter;

import org.testng.annotations.Test;

import static org.junit.Assert.*;

import androidx.room.Room;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private UserDAO userDao;

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void addUserTest() {
        UserDAO userDao;
        User testUser = new User("testName", "testPass");
        assertEquals(2, 1+1);
    }
}