package net.origamiking.mcmods.oapi.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.*;

import static net.minecraft.server.command.CommandManager.literal;

public class CommandsUtil {
    /** To use make this
     * <p>CommandsUtil.makeVersionCommand(MOD_ID, VERSION);</p>
     */
    public static void makeVersionCommand(String id, String version) {
        CommandRegistrationCallback.EVENT.register((dispatcher, commandSender) -> {
            LiteralArgumentBuilder<ServerCommandSource> builder = CommandManager.literal(id + "-version")
                    .executes((CommandContext<ServerCommandSource> context) -> {
                        context.getSource().sendFeedback(Text.of(version), false);
                        return 1;
                    });
            dispatcher.register(builder);
        });
    }
    /** To use make this
     * <p>CommandsUtil.simpleStringReturnCommand("Command-Name", "Text to say");</p>
     */
    public static void simpleStringReturnCommand(String commandName, String text) {
        CommandRegistrationCallback.EVENT.register((dispatcher, commandSender) -> dispatcher.register(literal(commandName)
                .executes(context -> {
                    context.getSource().sendFeedback(Text.of(text), false);
                    return 1;
                })));
    }

    /**
     * To use
     * <p>CommandsUtil.linkReturnCommand("Command-Name", "Link", "Hover-Text");</p>
     */

    public static void linkReturnCommand(String commandName, String link, String hoverText) {
        CommandRegistrationCallback.EVENT.register((dispatcher, commandSender) -> {
            LiteralArgumentBuilder<ServerCommandSource> builder = CommandManager.literal(commandName)
                    .executes((CommandContext<ServerCommandSource> context) -> {
                        Style style = Style.EMPTY.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, link))
                                .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new LiteralText(hoverText)));
                        context.getSource().sendFeedback(new LiteralText(link).setStyle(style), false);
                        return 1;
                    });
            dispatcher.register(builder);
        });
    }
}

