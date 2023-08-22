package net.origamiking.mcmods.oapi.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.HoverEvent;
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

    /**
     * To use
     * <p>CommandsUtil.linkReturnCommand("Command-Name", "Link", "Hover-Text");</p>
     */
    public static void linkReturnCommand(String commandName, String link, String hoverText) {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal(commandName)
                    .executes(context -> {
                        context.getSource().sendMessage(Text.literal(link).styled(style -> style.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, link))).styled(style -> style.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.of(hoverText)))));
                        return 1;
                    }));
        });
    }

    public static void linkReturnCommand(LiteralArgumentBuilder<ServerCommandSource> command, String commandName, String link, String hoverText) {
        command.then(literal(commandName).executes(context -> {
            context.getSource().sendMessage(Text.literal(link).styled(style -> style.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, link))).styled(style -> style.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.of(hoverText)))));
            return 1;
        }));
    }
    public static void versionCommand(LiteralArgumentBuilder<ServerCommandSource> command, String version, String modid) {
        command.then(literal("version").executes(context -> {
            context.getSource().sendMessage(Text.of("You are on " + version + " of " + modid));
            return 1;
        }));
    }
    public static void simpleStringReturnCommand(LiteralArgumentBuilder<ServerCommandSource> command, String commandName, String text) {
        command.then(literal(commandName)
                .executes(context -> {
                    context.getSource().sendMessage(Text.of(text));
                    return 1;
                }));
    }
}

