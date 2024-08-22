package pneumono.pneumonos_stuff.compat;

import net.fabricmc.loader.api.FabricLoader;

public class Compat {
    public static boolean TRINKETS = false;

    public static void register() {
        FabricLoader loader = FabricLoader.getInstance();
        if (loader.isModLoaded("trinkets")) {
            TRINKETS = true;
       }
    }
}
