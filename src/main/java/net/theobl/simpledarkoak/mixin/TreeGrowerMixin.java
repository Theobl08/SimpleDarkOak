package net.theobl.simpledarkoak.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.theobl.simpledarkoak.worldgen.ModConfiguredFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.util.Optional;

@Mixin(TreeGrower.class)
public class TreeGrowerMixin {
//    @Shadow
//    //@Final
//    public static final TreeGrower DARK_OAK = new TreeGrower("dark_oak", Optional.of(TreeFeatures.DARK_OAK), Optional.of(ModConfiguredFeatures.SIMPLE_DARK_OAK_KEY), Optional.empty());
//
//    @Shadow
//    public static final TreeGrower PALE_OAK = new TreeGrower("pale_oak", Optional.of(TreeFeatures.PALE_OAK_BONEMEAL), Optional.of(ModConfiguredFeatures.SIMPLE_PALE_OAK_KEY), Optional.empty());
}
