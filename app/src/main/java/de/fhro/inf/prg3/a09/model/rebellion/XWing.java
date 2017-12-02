package de.fhro.inf.prg3.a09.model.rebellion;

import android.graphics.drawable.Drawable;

import de.fhro.inf.prg3.a09.model.Fighter;

/**
 * @author Peter Kurfer
 */

public class XWing extends Fighter {

    public XWing(String pilot, Drawable fighterImage) {
        super(pilot, fighterImage);
    }

    @Override
    public String getFighterType() {
        return "X-wing";
    }
}
