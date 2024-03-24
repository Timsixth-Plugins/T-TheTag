package pl.timsixth.thetag.command.subcommand.thetag;

import lombok.RequiredArgsConstructor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.timsixth.minigameapi.api.arena.Arena;
import pl.timsixth.minigameapi.api.arena.manager.ArenaManager;
import pl.timsixth.minigameapi.api.command.SubCommand;
import pl.timsixth.minigameapi.api.game.GameManager;
import pl.timsixth.thetag.config.Messages;
import pl.timsixth.thetag.util.PlayerUtil;

import java.util.Optional;

@RequiredArgsConstructor
public class RandomJoinSubCommand implements SubCommand {

    private final Messages messages;
    private final ArenaManager arenaManager;
    private final GameManager gameManager;

    @Override
    public boolean executeCommand(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        randomJoin(player);

        return false;
    }

    @Override
    public String getName() {
        return "randomjoin";
    }

    private void randomJoin(Player player) {
        String randomName = gameManager.randomGame();
        if (randomName == null || randomName.isEmpty()) {
            PlayerUtil.sendMessage(player, messages.getDontHaveAnyEmptyArena());
            return;
        }

        Optional<Arena> areaOptional = arenaManager.getArena(randomName);
        if (!areaOptional.isPresent()) return;
        Arena arena = areaOptional.get();
        gameManager.joinGame(arena, player);
    }
}
