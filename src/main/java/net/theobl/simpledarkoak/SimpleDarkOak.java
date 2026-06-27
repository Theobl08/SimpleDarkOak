package net.theobl.simpledarkoak;

import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.theobl.simpledarkoak.worldgen.ModConfiguredFeatures;
import org.slf4j.Logger;

import java.util.Optional;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(SimpleDarkOak.MODID)
public class SimpleDarkOak {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "simpledarkoak";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public SimpleDarkOak(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (SimpleDarkOak) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("Initializing SimpleDarkOak");
        if(TreeGrower.DARK_OAK.tree.isEmpty()) {
            TreeGrower.DARK_OAK.tree = Optional.of(ModConfiguredFeatures.SIMPLE_DARK_OAK_KEY);
        }
        if(TreeGrower.PALE_OAK.tree.isEmpty()) {
            TreeGrower.PALE_OAK.tree = Optional.of(ModConfiguredFeatures.SIMPLE_PALE_OAK_KEY);
        }
        LOGGER.info("SimpleDarkOak Initialized !");
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
//        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
//            LOGGER.info("HELLO FROM CLIENT SETUP");
//            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
