package de.fhro.inf.prg3.a09;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.fhro.inf.prg3.a09.model.Fighter;
import de.fhro.inf.prg3.a09.model.NameGenerator;
import de.fhro.inf.prg3.a09.model.empire.TieBomber;
import de.fhro.inf.prg3.a09.model.empire.TieFighter;
import de.fhro.inf.prg3.a09.model.empire.TieInterceptor;

import static junit.framework.Assert.assertNotNull;

/**
 * @author Peter Kurfer
 */

@RunWith(AndroidJUnit4.class)
public class ImperialFighterTests {

    private NameGenerator nameGenerator;

    @Test
    public void testCreateTieBomber(){
        Context appContext = InstrumentationRegistry.getTargetContext();
        nameGenerator = new NameGenerator(appContext);

        Bitmap tieBomberBitmap = BitmapFactory.decodeResource(appContext.getResources(), R.drawable.tiebomber);
        Drawable tieBomberImage = new BitmapDrawable(appContext.getResources(), tieBomberBitmap);
        assertNotNull(tieBomberImage);

        Fighter tieBomber = new TieBomber(nameGenerator.generateName(), tieBomberImage);
        assertNotNull(tieBomber);
    }

    @Test
    public void testCreateTieFighter(){
        Context appContext = InstrumentationRegistry.getTargetContext();
        nameGenerator = new NameGenerator(appContext);

        Bitmap tieFighterBitmap = BitmapFactory.decodeResource(appContext.getResources(), R.drawable.tiefighter);
        Drawable tieFighterImage = new BitmapDrawable(appContext.getResources(), tieFighterBitmap);
        assertNotNull(tieFighterImage);

        Fighter tieFighter = new TieFighter(nameGenerator.generateName(), tieFighterImage);
        assertNotNull(tieFighter);
    }

    @Test
    public void testCreateTieInterceptor(){
        Context appContext = InstrumentationRegistry.getTargetContext();
        nameGenerator = new NameGenerator(appContext);

        Bitmap tieInterceptorBitmap = BitmapFactory.decodeResource(appContext.getResources(), R.drawable.tieinterceptor);
        Drawable tieInterceptorImage = new BitmapDrawable(appContext.getResources(), tieInterceptorBitmap);
        assertNotNull(tieInterceptorImage);

        Fighter tieInterceptor = new TieInterceptor(nameGenerator.generateName(), tieInterceptorImage);
        assertNotNull(tieInterceptor);
    }
}
