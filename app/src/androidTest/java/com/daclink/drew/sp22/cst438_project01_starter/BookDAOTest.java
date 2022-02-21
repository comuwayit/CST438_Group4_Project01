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
public class BookDAOTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        BookDAO myTestDB2 = Room.databaseBuilder(appContext, AppDataBase.class, AppDataBase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .book();

        Book book = new Book("The Way of Kings", 5555, "Education", "Sanderson");

        myTestDB2.delete(book);

        myTestDB2.insert(book);

        Book book2 = myTestDB2.getBookByAuthor(book.getAuthor());

        assertEquals(book, book2);

        book2.setIdNumber(9999);

        Book book3 = myTestDB2.getBookbyBookId(book.getIdNumber());

        assertNotEquals(book2, book3);
        assertEquals(book, book2);

        assertEquals("com.daclink.drew.sp22.cst438_project01_starter", appContext.getPackageName());
    }
}