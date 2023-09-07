package com.pugzarecute.nomorelevels;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;

public class BadMinecraftFix {
        public static int trueXP(Player player) {
            System.out.println(player.experienceProgress);
            System.out.println(player.getXpNeededForNextLevel());
            return (int) (getExperienceForLevel(player.experienceLevel)+ ((double)player.experienceProgress*(double)player.getXpNeededForNextLevel()));

        }

        public static int getExperienceForLevel(int level) {
            if (level == 0) return 0;
            else if (level <= 16) return level*level+level*6;
            else if (level <= 31) return (int) (2.5*level*level-40.5*level+360);
            else return (int)(4.5 *level*level -162.5*level + 2220);
        }
        public static int getTrueXPCost(LocalPlayer player, int levelCost){
            return getExperienceForLevel(player.experienceLevel) - getExperienceForLevel(player.experienceLevel-levelCost);
        }
}