package pl.timsixth.thetag.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.timsixth.guilibrary.core.model.MenuItem;
import pl.timsixth.guilibrary.core.model.action.AbstractAction;
import pl.timsixth.guilibrary.core.model.action.click.ClickAction;
import pl.timsixth.minigameapi.api.cosmetics.user.UserCosmetics;
import pl.timsixth.minigameapi.api.cosmetics.user.manager.UserCosmeticsManager;
import pl.timsixth.thetag.TheTagPlugin;
import pl.timsixth.thetag.util.PlayerUtil;

import java.util.Optional;

public class RestAllCosmeticsAction extends AbstractAction implements ClickAction {

    private final TheTagPlugin theTagPlugin = TheTagPlugin.getPlugin(TheTagPlugin.class);

    public RestAllCosmeticsAction() {
        super("RESET_ALL_COSMETICS");
    }

    @Override
    public void handleClickEvent(InventoryClickEvent event, MenuItem menuItem) {
        Player player = (Player) event.getWhoClicked();

        UserCosmeticsManager userCosmeticsManager = theTagPlugin.getUserCosmeticsManager();

        Optional<UserCosmetics> userCosmeticsOptional = userCosmeticsManager.getUserByUuid(player.getUniqueId());

        if (!userCosmeticsOptional.isPresent()) {
            event.setCancelled(true);
            return;
        }

        UserCosmetics userCosmeticsDbModel = userCosmeticsOptional.get();

        userCosmeticsDbModel.resetAllCosmetics();

        PlayerUtil.sendMessage(player, theTagPlugin.getMessages().getResetAllCosmetics());
        event.setCancelled(true);
    }
}
