package com.pugzarecute.nomorelevels.mixin;

import com.chirptheboy.disenchanting.block.disenchant.ScreenDisenchant;
import com.pugzarecute.nomorelevels.BadMinecraftFix;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Pseudo
@Mixin(ScreenDisenchant.class)
public class DisenchantingForgeMixin {
    @ModifyArg(method = "renderLabels", at=@At(value = "INVOKE",target = "Lcom/chirptheboy/disenchanting/block/disenchant/ScreenDisenchant;drawCostString(Lcom/mojang/blaze3d/vertex/PoseStack;Ljava/lang/String;I)V"),index = 2)
    private int inject(int par3){
        return BadMinecraftFix.getTrueXPCost(Minecraft.getInstance().player, par3);
    }
}
