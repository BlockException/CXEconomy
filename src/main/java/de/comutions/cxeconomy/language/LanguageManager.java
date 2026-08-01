package de.comutions.cxeconomy.language;

import de.comutions.cxeconomy.CXEconomy;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LanguageManager {

    private final CXEconomy plugin;
    private final Map<String, FileConfiguration> languageConfigs = new HashMap<>();
    private String currentLanguage;

    public LanguageManager(CXEconomy plugin) {
        this.plugin = plugin;
        loadLanguages();
        currentLanguage = plugin.getConfig().getString("language", "en");
    }

    private void loadLanguages() {
        String[] languages = {"en", "de", "fr", "es", "it", "pt", "nl", "pl", "ru", "ja",
                "zh", "ko", "ar", "tr", "sv", "da", "no", "fi", "el", "he",
                "hi", "th", "vi", "id", "ms", "cs", "sk", "hu", "ro", "uk"};
        for (String lang : languages) {
            loadLanguage(lang);
        }
    }

    private void loadLanguage(String langCode) {
        String fileName = "messages_" + langCode + ".yml";
        File file = new File(plugin.getDataFolder(), fileName);
        if (!file.exists()) {
            plugin.saveResource(fileName, false);
        }
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        try (InputStreamReader reader = new InputStreamReader(plugin.getResource(fileName))) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(reader);
            config.setDefaults(defaultConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }
        languageConfigs.put(langCode, config);
    }

    public void reloadLanguages() {
        languageConfigs.clear();
        loadLanguages();
        currentLanguage = plugin.getConfig().getString("language", "en");
    }

    public String getMessage(String key) {
        FileConfiguration config = languageConfigs.get(currentLanguage);
        if (config == null) {
            config = languageConfigs.get("en");
        }
        return config.getString(key, key);
    }

    public String getMessage(String key, Map<String, String> placeholders) {
        String message = getMessage(key);
        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            message = message.replace("{" + entry.getKey() + "}", entry.getValue());
        }
        return message;
    }
}





