package com.chaca142.nv;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class Nv extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info(ChatColor.GREEN + "NVプラグインを有効にしました");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info(ChatColor.GREEN + "NVプラグインを無効にしました");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + ("ゲーム内から実行してください"));
        }else{
            Player player = (Player) sender;
            if(player.hasPotionEffect(PotionEffectType.NIGHT_VISION)){
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                player.sendMessage(ChatColor.GREEN + "暗視を外しました");
            }else{
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 9999, 1));
                player.sendMessage(ChatColor.GREEN + "暗視を付与しました");
            }
        }
        return false;
    }
}
