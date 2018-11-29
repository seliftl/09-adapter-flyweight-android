package de.thro.inf.prg3.a09.model.empire;

import android.graphics.drawable.Drawable;

import de.thro.inf.prg3.a09.model.Fighter;

/**
 * @author Peter Kurfer
 */

public class TieInterceptor extends Fighter {

    public TieInterceptor(String pilot, Drawable fighterImage) {
        super(pilot, fighterImage);
    }

    @Override
    public String getFighterType() {
        return "Tie interceptor";
    }
}
