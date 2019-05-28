package de.thro.inf.prg3.a09.model;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

import de.thro.inf.prg3.a09.R;
import de.thro.inf.prg3.a09.flyweight.Flyweight;
import de.thro.inf.prg3.a09.flyweight.FlyweightFactory;
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
   // private final Flyweight flyweight;
    FlyweightFactory factory;

    public FighterFactory(Context context) {
        this.context = context;
        nameGenerator = new NameGenerator(context);
        random = new Random();

        factory = new FlyweightFactory();
    }

    public Fighter createFighter() throws IOException, URISyntaxException {
        switch (random.nextInt(6)) {
            case 0:
                return new AWing(nameGenerator.generateName(), factory.getFlyweight(R.drawable.awing, context));
            case 1:
                return new XWing(nameGenerator.generateName(), factory.getFlyweight(R.drawable.xwing, context));
            case 2:
                return new YWing(nameGenerator.generateName(), factory.getFlyweight(R.drawable.ywing, context));
            case 3:
                return new TieBomber(nameGenerator.generateName(), factory.getFlyweight(R.drawable.tiebomber, context));
            case 4:
                return new TieFighter(nameGenerator.generateName(), factory.getFlyweight(R.drawable.tiefighter, context));
            default:
                return new TieInterceptor(nameGenerator.generateName(), factory.getFlyweight(R.drawable.tieinterceptor, context));
        }
    }
//  gehört hier nicht mehr hin
//    private Drawable loadImage(int imageId) {
//        return new BitmapDrawable(context.getResources(), BitmapFactory.decodeResource(context.getResources(), imageId));
//    }
}
