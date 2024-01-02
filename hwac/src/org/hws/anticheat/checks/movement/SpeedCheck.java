package org.hws.anticheat.checks.movement;

import org.hws.anticheat.util.Distance;
import org.hws.anticheat.util.Settings;
import org.hws.anticheat.util.User;
import org.hws.anticheat.checks.CheckResult;
import org.hws.anticheat.checks.CheckType;
import org.hws.anticheat.checks.Level;

public class SpeedCheck {

	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.SPEED);
	
	public static CheckResult runCheck(Distance d, User u) {
		Double xz_speed = (d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff());
		if (xz_speed > Settings.MAX_XZ_SPEED)
			return new CheckResult(Level.DEFINITELY, "Tried to move faster than normal, Speed: " + xz_speed.toString() + ", Max: " + Settings.MAX_XZ_SPEED, CheckType.SPEED);
		return PASS;
	}
	
}
