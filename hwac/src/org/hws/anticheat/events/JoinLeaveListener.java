package org.hws.anticheat.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.hws.anticheat.util.User;
import org.hws.anticheat.WAC;

public class JoinLeaveListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		WAC.USERS.put(p.getUniqueId(), new User(p));
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		WAC.USERS.remove(p.getUniqueId());
	}
}
