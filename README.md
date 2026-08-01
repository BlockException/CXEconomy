# CXEconomy

[![Language](https://img.shields.io/badge/Language-Java-ED8B00?style=flat-square&logo=java&logoColor=white)](https://www.java.com/)
[![Build](https://img.shields.io/badge/Build-Maven-C71A36?style=flat-square&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![Platform](https://img.shields.io/badge/Platform-Paper%20MC-4E9CD9?style=flat-square&logo=minecraft&logoColor=white)](https://papermc.io/)
[![Dependencies](https://img.shields.io/badge/Dependencies-Vault%20%7C%20PlaceholderAPI-black?style=flat-square)](https://www.spigotmc.org/)
[![License](https://img.shields.io/badge/License-Proprietary-orange?style=flat-square)](#license)

A professional, high-performance Economy Plugin for Minecraft 1.21+ (Paper).
CXEconomy provides a modern Vault integration and user-friendly GUI interfaces using Anvil menus for economy transactions.

## Features

* **Vault Integration**: Fully compatible with the standard Vault API.
* **Modern Formatting**: Uses MiniMessage API for complete Hex color support and gradient formatting.
* **Anvil GUI**: Modern UI approach using Anvil menus for `/pay` and `/eco` inputs to prevent chat-based command errors.
* **Multi-Language Support**: Built-in support for 30 languages, dynamically configurable.
* **High Performance**: Optimized for Java 21 and modern Paper environments.

## Commands & Permissions

| Command | Description | Permission |
|---------|-------------|------------|
| `/pay <player>` | Transfer money to another player via Anvil GUI | `cxeconomy.pay` (Default: true) |
| `/balance`, `/bal` | Check your current account balance | `cxeconomy.balance` (Default: true) |
| `/eco <action> <player>` | Manage economy (add, set, remove, reset) | `cxeconomy.manage.admin` (Default: op) |
| `/ecoreload` | Reload the plugin configuration and language files | `cxeconomy.manage.reload.admin` (Default: op) |

## Requirements

* **Minecraft Server**: Paper 1.21 or higher
* **Java**: Version 21 or higher
* **Dependencies**: 
  * [Vault](https://dev.bukkit.org/projects/vault) (Hard Dependency)
  * [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/) (Hard Dependency)
  * Any Permissions Plugin (e.g. LuckPerms)

## Installation

1. Download the latest `CXEconomy.jar` from the releases section.
2. Place the jar file into your server's `plugins` folder.
3. Ensure Vault is installed.
4. Restart your server.
5. Configure the plugin in `plugins/CXEconomy/config.yml`.

## Configuration

The default configuration file allows you to set the currency symbol, default starting balance, and the server language.

```yaml
currency-symbol: "$"
starting-balance: 0.0
language: "en"
```

## Compilation

To compile this project yourself, you need Maven installed.

```bash
git clone https://github.com/BlockException/CXEconomy.git
cd CXEconomy
mvn clean package
```

The compiled jar file will be available in the `target/` directory.

## License

This project is proprietary and belongs to [comutions](https://comutions.de). Unauthorized distribution or modification is prohibited unless explicitly stated otherwise.




