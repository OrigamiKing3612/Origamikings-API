package net.origamiking.mcmods.oapi.commands.versioncommand;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.text.Text;
import net.origamiking.mcmods.oapi.OrigamiKingsApi;

import static net.minecraft.server.command.CommandManager.literal;

public class ModVersionCommand {
    public static void getVersionCommand() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("origamikings-api-version")
                .executes(context -> {
                    context.getSource().sendMessage(Text.of(OrigamiKingsApi.VERSION)/*Text.literal("Called /oem with no arguments")*/);
                    return 1;
                })));
    }
}
