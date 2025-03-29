package com.theobl.simpledarkoak.mixin;

import com.theobl.simpledarkoak.worldgen.ModConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.DarkOakTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DarkOakTreeGrower.class)
public class DarkOakTreeGrowerMixin {
    @Inject(method = "getConfiguredFeature", at = @At("RETURN"), cancellable = true)
    private void addSimpleDarkOak(RandomSource p_222924_, boolean p_222925_, CallbackInfoReturnable<ResourceKey<ConfiguredFeature<?, ?>>> cir){
        cir.setReturnValue(ModConfiguredFeatures.SIMPLE_DARK_OAK_KEY);
    }
}
