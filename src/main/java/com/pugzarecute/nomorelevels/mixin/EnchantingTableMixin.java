package com.pugzarecute.nomorelevels.mixin;

import com.pugzarecute.nomorelevels.BadMinecraftFix;
import com.pugzarecute.nomorelevels.util.TruncationUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.EnchantmentScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnchantmentScreen.class)
public class EnchantingTableMixin {
    @Redirect(method = "render",at = @At(value = "INVOKE",target = "Lnet/minecraft/network/chat/Component;translatable(Ljava/lang/String;[Ljava/lang/Object;)Lnet/minecraft/network/chat/MutableComponent;"))
    private MutableComponent injector(String p_237111_, Object[] p_237112_){

        if(!p_237111_.equals("container.enchant.lapis.many")&&p_237112_[0].getClass().equals(Integer.class)){
            p_237112_[0] = TruncationUtils.format(BadMinecraftFix.getExperienceForLevel(Minecraft.getInstance().player.experienceLevel) - BadMinecraftFix.getExperienceForLevel(Minecraft.getInstance().player.experienceLevel-Integer.parseInt(p_237112_[0].toString())));
        }
        return Component.translatable(p_237111_,p_237112_);
    }
}
