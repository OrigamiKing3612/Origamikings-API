package net.origamiking.mcmods.oapi.commands;

import net.origamiking.mcmods.oapi.OrigamiKingsApi;

public class ModCommands {
    public static void registerCommands() {
        CommandsUtil.makeVersionCommand(OrigamiKingsApi.MOD_ID, OrigamiKingsApi.VERSION);
        CommandsUtil.linkReturnCommand(OrigamiKingsApi.MOD_ID + "-website", "https://modrinth.com/mod/origamikings-api", "To Website");
        CommandsUtil.linkReturnCommand(OrigamiKingsApi.MOD_ID + "-issues", "https://github.com/OrigamiKing3612/Origamikings-API/issues", "To Issues Page");
    }
}
