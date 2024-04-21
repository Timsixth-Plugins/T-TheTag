package pl.timsixth.thetag.cosmetics.walk;

import org.bukkit.Particle;

public class WalkVillagerCosmetic implements WalkCosmetic {
    @Override
    public Particle getParticle() {
        return Particle.VILLAGER_HAPPY;
    }

    @Override
    public String getName() {
        return "WALK_VILLAGER";
    }
}
