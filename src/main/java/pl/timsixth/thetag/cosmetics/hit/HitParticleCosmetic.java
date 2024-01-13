package pl.timsixth.thetag.cosmetics.hit;

import pl.timsixth.minigameapi.api.cosmetics.ParticleCosmetic;

public interface HitParticleCosmetic extends ParticleCosmetic {

    @Override
    default int getParticleHeight() {
        return 1;
    }
}
