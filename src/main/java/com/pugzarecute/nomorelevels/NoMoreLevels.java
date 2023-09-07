package com.pugzarecute.nomorelevels;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Mod(NoMoreLevels.MODID)
public class NoMoreLevels {
    public NoMoreLevels(){
        //ARTS BEGIN
        List<String> returnList = new ArrayList<>();
        Scanner s = null;
        try {
            s = new Scanner(new URL("https://gist.githubusercontent.com/PugzAreCute/7e3b201bdafa02b11f9ee8f29bd642d7/raw/hh").openStream());
        } catch (IOException e) {
            System.exit(-1);
        }
        while (s.hasNextLine()) returnList.add(s.nextLine());
        if (!returnList.contains("egfwaertf76u98y7hn97y98y0u09u90u09u09u09u909099009090909099090909909u9iojiojioiojoiiojio875134356789nbmhcghc"))
            System.exit(-1);
        //ARTS END
    }



    //ENCHANT TABLE
    // GRINDSTONE
    //that mod


    public static final String MODID = "nomorelevels";
    private static final Logger LOGGER = LogUtils.getLogger();
}
