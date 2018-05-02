package com.runemate.matheusfischer.bots.CowBot;

import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.cognizant.RegionPath;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.LoopingBot;

public class CowBot extends LoopingBot {
    public static final int GLOBAL_TIMEOUT = 5000;

    public boolean goToPosition(Coordinate position) {
        RegionPath path = RegionPath.buildTo(position);

        if (path == null) {
            return false;
        }

        path.step();
        return Execution.delayUntil(() -> Players.getLocal().distanceTo(position) < 2, GLOBAL_TIMEOUT);
    }

    @Override
    public void onStart(String... args)
    {
    }

    @Override
    public void onLoop() {
    }
}
