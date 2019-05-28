package de.thro.inf.prg3.a09.model;

import android.graphics.drawable.Drawable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.PrintStream;

import de.thro.inf.prg3.a09.flyweight.Flyweight;

/**
 * @author Peter Kurfer
 */

public abstract class Fighter {

    private final String pilot;
    private final Flyweight flyweight;

    public Fighter(String pilot, Flyweight flyweight) {
        this.pilot = pilot;
        this.flyweight = flyweight;
    }

    public String getPilot() {
        return pilot;
    }

    // Woher?
    public Drawable getFighterImage(){
        return flyweight.getFighterImage();
    }

    public abstract String getFighterType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Fighter)) return false;

        Fighter fighter = (Fighter) o;

        return new EqualsBuilder()
                .append(getPilot(), fighter.getPilot())
                .append(getFighterType(), fighter.getFighterType())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getPilot())
                .append(getFighterType())
                .toHashCode();
    }

    void describe(PrintStream ps) {
        // inject extrinsic state to flyweight
        flyweight.describe(ps, this);
    }
}
