package com.pugzarecute.nomorelevels.mixin;

import com.pugzarecute.nomorelevels.BadMinecraftFix;
import com.pugzarecute.nomorelevels.util.TruncationUtils;
import net.minecraft.client.gui.screens.inventory.AnvilScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Pseudo
@Mixin(value = AnvilScreen.class, priority = 1,remap = true)
public class AnvilMixin {
    @ModifyArg(method = "Lnet/minecraft/client/gui/screens/inventory/AnvilScreen;renderLabels(Lcom/mojang/blaze3d/vertex/PoseStack;II)V", at=@At(value="INVOKE",target="Lnet/minecraft/network/chat/Component;translatable(Ljava/lang/String;[Ljava/lang/Object;)Lnet/minecraft/network/chat/MutableComponent;"),index=1)
    private Object[] injector(Object... p_237112_){
        return new Object[]{TruncationUtils.format(BadMinecraftFix.getExperienceForLevel(Integer.parseInt(p_237112_[0].toString())))};
    }
}
