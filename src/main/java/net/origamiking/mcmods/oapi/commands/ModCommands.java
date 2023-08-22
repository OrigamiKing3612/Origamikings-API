package net.origamiking.mcmods.oapi.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.origamiking.mcmods.oapi.OrigamiKingsApi;

public class ModCommands {
    public static void registerCommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            LiteralArgumentBuilder<ServerCommandSource> command = LiteralArgumentBuilder.literal(OrigamiKingsApi.MOD_ID);

            CommandsUtil.versionCommand(command, OrigamiKingsApi.VERSION, OrigamiKingsApi.MOD_ID);
            CommandsUtil.linkReturnCommand(command, "website", "https://modrinth.com/mod/origamikings-api", "To Website");
            CommandsUtil.linkReturnCommand(command, "issues", "https://github.com/OrigamiKing3612/Origamikings-API/issues", "To Issues Page");

            dispatcher.register(command);
        });
    }
}
