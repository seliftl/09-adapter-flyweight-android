package de.fhro.inf.prg3.a09;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.fhro.inf.prg3.a09.model.NameGenerator;

import static de.fhro.inf.prg3.a09.TestConstants.LOGGING_TAG;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class NameGeneratorTests {

    @Test
    public void testGenerateRandomName() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();

        NameGenerator nameGenerator = new NameGenerator(appContext);
        String generatedName = nameGenerator.generateName();

        assertNotNull(generatedName);
        assertNotEquals(0, generatedName.length());
        Log.d(LOGGING_TAG, String.format("Generated name: %s", generatedName));    }
}
