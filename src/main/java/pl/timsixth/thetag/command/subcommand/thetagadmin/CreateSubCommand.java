package pl.timsixth.thetag.command.subcommand.thetagadmin;

import lombok.RequiredArgsConstructor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.timsixth.minigameapi.api.MiniGame;
import pl.timsixth.minigameapi.api.arena.manager.ArenaManager;
import pl.timsixth.minigameapi.api.command.SubCommand;
import pl.timsixth.thetag.config.Messages;
import pl.timsixth.thetag.util.PlayerUtil;

@RequiredArgsConstructor
public class CreateSubCommand implements SubCommand {

    private final ArenaManager arenaManager;
    private final Messages messages;

    @Override
    public boolean executeCommand(CommandSender sender, String[] args) {
        if (args.length == 2) {
            Player player = (Player) sender;

            if (arenaManager.getArena(args[1]).isPresent()) {
                PlayerUtil.sendMessage(player, messages.getArenaExists());
                return true;
            }
            arenaManager.addArena(MiniGame.getArenaFactory().createArena(args[1], player.getLocation()));
            PlayerUtil.sendMessage(player, messages.getArenaCreated());
        }

        return false;
    }

    @Override
    public String getName() {
        return "create";
    }
}
