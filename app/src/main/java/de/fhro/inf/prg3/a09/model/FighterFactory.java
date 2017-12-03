package de.fhro.inf.prg3.a09.model;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.util.Random;

import de.fhro.inf.prg3.a09.R;
import de.fhro.inf.prg3.a09.model.empire.TieBomber;
import de.fhro.inf.prg3.a09.model.empire.TieFighter;
import de.fhro.inf.prg3.a09.model.empire.TieInterceptor;
import de.fhro.inf.prg3.a09.model.rebellion.AWing;
import de.fhro.inf.prg3.a09.model.rebellion.XWing;
import de.fhro.inf.prg3.a09.model.rebellion.YWing;

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

    public Fighter createFighter(Party party){
        switch (party){
            case Rebellion:
                return createRebellionFighter(random.nextInt(3));
            default:
                return createImperialFighter(random.nextInt(3));
        }
    }

    private Fighter createRebellionFighter(int index){
        switch (index) {
            case 0:
                return new AWing(nameGenerator.generateName(), loadImage(R.drawable.awing));
            case 1:
                return new XWing(nameGenerator.generateName(), loadImage(R.drawable.xwing));
            default:
                return new YWing(nameGenerator.generateName(), loadImage(R.drawable.ywing));
        }
    }

    private Fighter createImperialFighter(int index){
        switch (index) {
            case 0:
                return new TieBomber(nameGenerator.generateName(), loadImage(R.drawable.tiebomber));
            case 1:
                return new TieFighter(nameGenerator.generateName(), loadImage(R.drawable.tiefighter));
            default:
                return new TieInterceptor(nameGenerator.generateName(), loadImage(R.drawable.tieinterceptor));
        }
    }

    private Drawable loadImage(int imageId){
        return new BitmapDrawable(context.getResources(), BitmapFactory.decodeResource(context.getResources(), imageId));
    }

    public enum Party {
        Rebellion,
        Empire
    }
}
