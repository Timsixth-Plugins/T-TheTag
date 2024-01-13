package pl.timsixth.thetag.cosmetics.walk;

import org.bukkit.Particle;

public class WalkSlimeCosmetic implements WalkCosmetic {
    @Override
    public String getName() {
        return "WALK_SLIME";
    }

    @Override
    public Particle getParticle() {
        return Particle.SLIME;
    }
}
