package de.thro.inf.prg3.a09.flyweight;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;

import de.thro.inf.prg3.a09.model.Fighter;

public class Flyweight {
    // intrinsic state
    private final BitmapDrawable bitmapDrawable;

    Flyweight(int imageId, Context context) throws URISyntaxException, IOException {
        bitmapDrawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeResource(context.getResources(), imageId));
    }
    public Drawable getFighterImage(){
        return bitmapDrawable;
    }

    public void describe(PrintStream ps, Fighter fighter) {
        ps.println(String.format("%s: %d x %d",
                fighter.getFighterType(),
                bitmapDrawable.getMinimumHeight(),
                bitmapDrawable.getMinimumWidth()
        ));
    }
}
