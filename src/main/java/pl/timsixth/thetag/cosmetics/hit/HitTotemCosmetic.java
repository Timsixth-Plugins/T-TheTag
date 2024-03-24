package pl.timsixth.thetag.cosmetics.hit;

import org.bukkit.Particle;

public class HitTotemCosmetic implements HitParticleCosmetic {
    @Override
    public Particle getParticle() {
        return Particle.TOTEM;
    }

    @Override
    public String getName() {
        return "HIT_TOTEM";
    }
}
