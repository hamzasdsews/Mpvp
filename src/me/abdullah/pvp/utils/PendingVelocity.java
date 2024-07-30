/*
 * Decompiled with CFR 0.137.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package me.abdullah.pvp.utils;

import org.bukkit.entity.Player;

public class PendingVelocity {
    private Player pending;
    private Player attacker;
    private long timeStamp;

    public PendingVelocity(Player pending, Player attacker) {
        this.pending = pending;
        this.attacker = attacker;
        this.timeStamp = System.currentTimeMillis();
    }

    public Player getPending() {
        return this.pending;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public Player getAttacker() {
        return this.attacker;
    }
}

