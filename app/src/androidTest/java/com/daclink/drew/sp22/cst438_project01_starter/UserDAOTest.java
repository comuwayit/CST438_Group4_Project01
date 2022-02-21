package com.daclink.drew.sp22.cst438_project01_starter;

import android.content.Context;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class UserDAOTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        UserDAO myTestDB1 = Room.databaseBuilder(appContext, AppDataBase.class, AppDataBase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getDao();

        User user = new User("Jeff", "password");

        myTestDB1.delete(user);

        myTestDB1.insert(user);

        User user2 = myTestDB1.getUserbyUsername(user.getUsername());

        assertEquals(user, user2);

        user2.setUserId(7777);

        User user3 = myTestDB1.getUserbyUserId(user.getUserId());

        assertNotEquals(user, user3);
        assertEquals(user2, user3);

        myTestDB1.update(user, user3);

        assertEquals(user, user3);

        assertEquals("com.daclink.drew.sp22.cst438_project01_starter", appContext.getPackageName());
    }
}