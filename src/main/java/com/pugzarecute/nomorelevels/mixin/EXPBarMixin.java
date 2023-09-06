package com.pugzarecute.nomorelevels.mixin;

import com.pugzarecute.nomorelevels.BadMinecraftFix;
import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Gui.class)
public class EXPBarMixin {
    @SuppressWarnings("ALL")// idk lol
    @ModifyVariable(method = "renderExperienceBar(Lcom/mojang/blaze3d/vertex/PoseStack;I)V", at = @At(value = "STORE"), ordinal = 0)
    private String injected(String x) {
        System.out.println(BadMinecraftFix.trueXP(((Gui)((Object)(this))).minecraft.player));
        return ""+ BadMinecraftFix.trueXP(((Gui)((Object)(this))).minecraft.player);
    }
}
