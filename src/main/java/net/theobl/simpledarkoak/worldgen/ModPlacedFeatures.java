package net.theobl.simpledarkoak.worldgen;

import net.theobl.simpledarkoak.SimpleDarkOak;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> SIMPLE_DARK_OAK_PLACED_KEY = registerKey("simple_dark_oak_placed");
    public static final ResourceKey<PlacedFeature> SIMPLE_PALE_OAK_PLACED_KEY = registerKey("simple_pale_oak_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, SIMPLE_DARK_OAK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SIMPLE_DARK_OAK_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2,0.1f,1),
                        Blocks.DARK_OAK_SAPLING));

        register(context, SIMPLE_PALE_OAK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SIMPLE_PALE_OAK_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2,0.1f,1),
                        Blocks.PALE_OAK_SAPLING));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(SimpleDarkOak.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
