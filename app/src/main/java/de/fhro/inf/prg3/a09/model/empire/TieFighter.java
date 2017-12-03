package de.fhro.inf.prg3.a09.model.empire;

import android.graphics.drawable.Drawable;

import de.fhro.inf.prg3.a09.model.Fighter;

/**
 * @author Peter Kurfer
 */

public class TieFighter extends Fighter {

    public TieFighter(String pilot, Drawable fighterImage) {
        super(pilot, fighterImage);
    }

    @Override
    public String getFighterType() {
        return "Tie fighter";
    }
}
