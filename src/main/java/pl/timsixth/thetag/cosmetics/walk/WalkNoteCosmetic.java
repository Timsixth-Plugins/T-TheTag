package pl.timsixth.thetag.cosmetics.walk;

import org.bukkit.Particle;

public class WalkNoteCosmetic implements WalkCosmetic {
    @Override
    public String getName() {
        return "WALK_NOTE";
    }

    @Override
    public Particle getParticle() {
        return Particle.NOTE;
    }
}
