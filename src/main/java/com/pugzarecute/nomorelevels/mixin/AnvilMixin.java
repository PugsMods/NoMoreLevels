package com.pugzarecute.nomorelevels.mixin;

import com.pugzarecute.nomorelevels.BadMinecraftFix;
import net.minecraft.client.gui.screens.inventory.AnvilScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AnvilScreen.class)
public class AnvilMixin {
    @SuppressWarnings("ALL") //idk lol
    @ModifyArg(method = "Lnet/minecraft/client/gui/screens/inventory/AnvilScreen;renderLabels(Lcom/mojang/blaze3d/vertex/PoseStack;II)V", at=@At(value="INVOKE",target="Lnet/minecraft/network/chat/Component;translatable(Ljava/lang/String;[Ljava/lang/Object;)Lnet/minecraft/network/chat/MutableComponent;"),index=1)
    private Object[] injector(Object[] p_237112_){
        return new Object[]{BadMinecraftFix.getExperienceForLevel(Integer.parseInt(p_237112_[0].toString()))};
    }
}
