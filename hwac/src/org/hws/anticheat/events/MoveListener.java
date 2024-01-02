package org.hws.anticheat.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import org.hws.anticheat.WAC;
import org.hws.anticheat.checks.CheckResult;
import org.hws.anticheat.checks.movement.SpeedCheck;
import org.hws.anticheat.util.Distance;
import org.hws.anticheat.util.User;

public class MoveListener implements Listener {

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		User u = WAC.USERS.get(e.getPlayer().getUniqueId());
		Distance d = new Distance(e);
		CheckResult speed = SpeedCheck.runCheck(d, u);
		if (speed.failed()) {
			e.setTo(e.getFrom());
			WAC.log(speed, u);
		}
	}
}
