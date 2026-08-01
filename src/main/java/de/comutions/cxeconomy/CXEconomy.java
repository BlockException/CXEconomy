package de.comutions.cxeconomy;

import de.comutions.cxeconomy.command.BalanceCommand;
import de.comutions.cxeconomy.command.EcoCommand;
import de.comutions.cxeconomy.command.PayCommand;
import de.comutions.cxeconomy.command.ReloadCommand;
import de.comutions.cxeconomy.economy.EconomyHandler;
import de.comutions.cxeconomy.language.LanguageManager;
import de.comutions.cxeconomy.placeholder.CXEconomyExpansion;
import de.comutions.cxeconomy.storage.BalanceStorage;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public final class CXEconomy extends JavaPlugin {

    private static CXEconomy instance;
    private BalanceStorage balanceStorage;
    private LanguageManager languageManager;
    private EconomyHandler economyHandler;
    private String currencySymbol;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        currencySymbol = getConfig().getString("currency-symbol", "$");
        languageManager = new LanguageManager(this);
        balanceStorage = new BalanceStorage(this);
        economyHandler = new EconomyHandler(this);
        setupVault();
        getCommand("pay").setExecutor(new PayCommand(this));
        getCommand("eco").setExecutor(new EcoCommand(this));
        getCommand("ecoreload").setExecutor(new ReloadCommand(this));
        getCommand("balance").setExecutor(new BalanceCommand(this));
        getCommand("bal").setExecutor(new BalanceCommand(this));
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new CXEconomyExpansion(this).register();
        }
    }

    @Override
    public void onDisable() {
        if (balanceStorage != null) {
            balanceStorage.saveAll();
            balanceStorage.close();
        }
    }

    private void setupVault() {
        if (Bukkit.getPluginManager().getPlugin("Vault") != null) {
            Bukkit.getServicesManager().register(Economy.class, economyHandler, this, ServicePriority.Highest);
            getLogger().info("Vault hooked successfully!");
        } else {
            getLogger().warning("Vault not found! Economy features may not work.");
        }
    }

    public static CXEconomy getInstance() {
        return instance;
    }

    public BalanceStorage getBalanceStorage() {
        return balanceStorage;
    }

    public LanguageManager getLanguageManager() {
        return languageManager;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }
}





