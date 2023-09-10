package com.pugzarecute.nomorelevels.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.pugzarecute.nomorelevels.BadMinecraftFix;
import com.pugzarecute.nomorelevels.util.TruncationUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Gui.class)
public class EXPBarMixin {
    @SuppressWarnings("ALL")// idk lol
    @Overwrite
    public void renderExperienceBar(PoseStack poseStack, int intt) {
        ((Gui)(Object)this).minecraft.getProfiler().push("expBar");
        RenderSystem.setShaderTexture(0, GuiComponent.GUI_ICONS_LOCATION);
        int i = ((Gui)(Object)this).minecraft.player.getXpNeededForNextLevel();

        ((Gui)(Object)this).minecraft.getProfiler().pop();
            ((Gui)(Object)this).minecraft.getProfiler().push("expLevel");
            String s = "" + TruncationUtils.format(BadMinecraftFix.trueXP(((Gui)(Object)this).minecraft.player));
            int i1 = (((Gui)(Object)this).screenWidth - ((Gui)(Object)this).getFont().width(s)) / 2;
            int j1 = ((Gui)(Object)this).screenHeight - 31 - 4 + 5;
            ((Gui)(Object)this).getFont().draw(poseStack, s, (float)(i1 + 1), (float)j1, 0);
            ((Gui)(Object)this).getFont().draw(poseStack, s, (float)(i1 - 1), (float)j1, 0);
            ((Gui)(Object)this).getFont().draw(poseStack, s, (float)i1, (float)(j1 + 1), 0);
            ((Gui)(Object)this).getFont().draw(poseStack, s, (float)i1, (float)(j1 - 1), 0);
            ((Gui)(Object)this).getFont().draw(poseStack, s, (float)i1, (float)j1, 8453920);
            ((Gui)(Object)this).minecraft.getProfiler().pop();
    }
}
