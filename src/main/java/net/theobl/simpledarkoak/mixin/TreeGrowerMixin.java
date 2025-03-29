package net.theobl.simpledarkoak.mixin;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.theobl.simpledarkoak.worldgen.ModConfiguredFeatures;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Optional;

@Mixin(TreeGrower.class)
public class TreeGrowerMixin {
    @Shadow
    //@Final
    public static final TreeGrower DARK_OAK = new TreeGrower("dark_oak", Optional.of(TreeFeatures.DARK_OAK), Optional.of(ModConfiguredFeatures.SIMPLE_DARK_OAK_KEY), Optional.empty());
}
