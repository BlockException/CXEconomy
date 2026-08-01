package de.comutions.cxeconomy.command;

import de.comutions.cxeconomy.CXEconomy;
import de.comutions.cxeconomy.util.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BalanceCommand implements CommandExecutor {

    private final CXEconomy plugin;

    public BalanceCommand(CXEconomy plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            ColorUtil.sendMessage(sender, plugin.getLanguageManager().getMessage("only-players"));
            return true;
        }
        if (!player.hasPermission("cxeconomy.balance")) {
            ColorUtil.sendMessage(player, plugin.getLanguageManager().getMessage("no-permission"));
            return true;
        }
        double balance = plugin.getBalanceStorage().getBalance(player.getUniqueId());
        ColorUtil.sendMessage(player, plugin.getLanguageManager().getMessage("balance", 
                java.util.Map.of("amount", ColorUtil.formatMoney(balance, plugin.getCurrencySymbol()))));
        return true;
    }
}





