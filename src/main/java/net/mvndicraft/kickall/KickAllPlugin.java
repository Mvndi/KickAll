package net.mvndicraft.kickall;

import co.aikar.commands.PaperCommandManager;
import dev.faststats.Metrics.Factory;
import dev.faststats.bukkit.BukkitContext;
import java.util.function.Supplier;
import java.util.logging.Level;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public final class KickAllPlugin extends JavaPlugin {
    private final BukkitContext context = new BukkitContext.Factory(this, "7fb05365e4ecea16d35975e99f396718")
        .metrics(Factory::create)
        .create();

    @Override
    public void onEnable() {
        new Metrics(this, 31780);
        context.ready();

        // Save config in our plugin data folder if it does not exist.
        // saveDefaultConfig();

        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new KickAllCommand());
    }

    public static KickAllPlugin getInstance() { return JavaPlugin.getPlugin(KickAllPlugin.class); }

    @Override
    public void onDisable() {
        context.shutdown();
    }

    // Usual log with debug level
    public static void log(Level level, String message) { getInstance().getLogger().log(level, message); }
    public static void log(Level level, Supplier<String> messageProvider) { getInstance().getLogger().log(level, messageProvider); }
    public static void log(Level level, String message, Throwable e) { getInstance().getLogger().log(level, message, e); }
    public static void debug(String message) {
        if (getInstance().getConfig().getBoolean("debug", false)) {
            log(Level.INFO, message);
        }
    }
    public static void debug(Supplier<String> messageProvider) {
        if (getInstance().getConfig().getBoolean("debug", false)) {
            log(Level.INFO, messageProvider);
        }
    }
    public static void info(String message) { log(Level.INFO, message); }
    public static void info(String message, Throwable e) { log(Level.INFO, message, e); }
    public static void warning(String message) { log(Level.WARNING, message); }
    public static void warning(String message, Throwable e) { log(Level.WARNING, message, e); }
    public static void error(String message) { log(Level.SEVERE, message); }
    public static void error(String message, Throwable e) { log(Level.SEVERE, message, e); }
}
