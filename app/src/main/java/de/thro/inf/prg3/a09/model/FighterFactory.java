package de.thro.inf.prg3.a09.model;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.util.Random;

import de.thro.inf.prg3.a09.R;
import de.thro.inf.prg3.a09.model.empire.TieBomber;
import de.thro.inf.prg3.a09.model.empire.TieFighter;
import de.thro.inf.prg3.a09.model.empire.TieInterceptor;
import de.thro.inf.prg3.a09.model.rebellion.AWing;
import de.thro.inf.prg3.a09.model.rebellion.XWing;
import de.thro.inf.prg3.a09.model.rebellion.YWing;

/**
 * @author Peter Kurfer
 */

public class FighterFactory {

    private final Random random;
    private final Context context;
    private final NameGenerator nameGenerator;

    public FighterFactory(Context context) {
        this.context = context;
        nameGenerator = new NameGenerator(context);
        random = new Random();
    }

    public Fighter createFighter() {
        switch (random.nextInt(6)) {
            case 0:
                return new AWing(nameGenerator.generateName(), loadImage(R.drawable.awing));
            case 1:
                return new XWing(nameGenerator.generateName(), loadImage(R.drawable.xwing));
            case 2:
                return new YWing(nameGenerator.generateName(), loadImage(R.drawable.ywing));
            case 3:
                return new TieBomber(nameGenerator.generateName(), loadImage(R.drawable.tiebomber));
            case 4:
                return new TieFighter(nameGenerator.generateName(), loadImage(R.drawable.tiefighter));
            default:
                return new TieInterceptor(nameGenerator.generateName(), loadImage(R.drawable.tieinterceptor));
        }
    }

    private Drawable loadImage(int imageId) {
        return new BitmapDrawable(context.getResources(), BitmapFactory.decodeResource(context.getResources(), imageId));
    }
}
