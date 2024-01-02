package org.hws.anticheat;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.hws.anticheat.checks.CheckResult;
import org.hws.anticheat.events.JoinLeaveListener;
import org.hws.anticheat.events.MoveListener;
import org.hws.anticheat.util.Settings;
import org.hws.anticheat.util.User;

import static org.bukkit.ChatColor.*;

public class WAC extends JavaPlugin implements Listener {
	
	public static HashMap<UUID, User> USERS = new HashMap<>();
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new JoinLeaveListener(), this);
		pm.registerEvents(new MoveListener(), this);
		
		
		for (Player p : Bukkit.getOnlinePlayers())
			USERS.put(p.getUniqueId(), new User(p));
	}

	public static void log(CheckResult cr, User u) {
		String message = DARK_PURPLE.toString() + BOLD + "[HWAC]" + RESET.toString() + RED + u.getPlayer().getName() + GRAY + " " + cr.getLevel().toString().toLowerCase() + " " + DARK_PURPLE + cr.getType().getName() + GRAY + "; " + cr.getMessage();
		for (Player p : Bukkit.getOnlinePlayers())
			if (p.hasPermission(Settings.NOTIFY))
				p.sendMessage(message);
		Bukkit.getConsoleSender().sendMessage(message);
	}
}
