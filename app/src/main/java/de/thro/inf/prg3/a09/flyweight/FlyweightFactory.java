package de.thro.inf.prg3.a09.flyweight;

import android.content.Context;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private Map<Integer, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(int imageID, Context context) throws URISyntaxException, IOException {
        if (flyweights.containsKey(imageID))
            return flyweights.get(imageID);

        // allocate new flyweight
        Flyweight fw = new Flyweight(imageID, context);
        flyweights.put(imageID, fw);

        return fw;
    }
}
