package de.thro.inf.prg3.a09.model.rebellion;

import android.graphics.drawable.Drawable;

import de.thro.inf.prg3.a09.flyweight.Flyweight;
import de.thro.inf.prg3.a09.model.Fighter;

/**
 * @author Peter Kurfer
 */

public class YWing extends Fighter {

    public YWing(String pilot, Flyweight flyweight) {
        super(pilot, flyweight);
    }

    @Override
    public String getFighterType() {
        return "Y-wing";
    }
}
