package net.origamiking.mcmods.oapi.commands;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

public class CommandsUtil {
    /** To use make this
     * <p>CommandsUtil.makeVersionCommand(MOD_ID, VERSION);</p>
     */
    public static void makeVersionCommand(String id, String version) {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal(id + "-version")
                .executes(context -> {
                    context.getSource().sendMessage(Text.of(version));
                    return 1;
                })));
    }
    /** To use make this
     * <p>CommandsUtil.simpleStringReturnCommand("Command-Name", "Text to say");</p>
     */
    public static void simpleStringReturnCommand(String commandName, String text) {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal(commandName)
                .executes(context -> {
                    context.getSource().sendMessage(Text.of(text));
                    return 1;
                })));
    }
}
