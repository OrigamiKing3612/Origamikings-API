package net.origamiking.mcmods.oapi.commands;


import net.origamiking.mcmods.oapi.OrigamiKingsApi;

public class ModCommands {
    public static void registerCommands() {
        CommandsUtil.makeVersionCommand(OrigamiKingsApi.MOD_ID, OrigamiKingsApi.VERSION);
    }
}
