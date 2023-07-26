package net.origamiking.mcmods.oapi.particle;

import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ParticleUtils {
    public static DefaultParticleType registerParticle(String id, String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(id, name), particleType);
    }
}
