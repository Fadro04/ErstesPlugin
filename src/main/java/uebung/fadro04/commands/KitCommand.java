package uebung.fadro04.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import uebung.fadro04.IO;

import java.util.ArrayList;

public class KitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (IO.isInstance(sender)) {
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage("Kits: Food, Starter, Adventure, OP");
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("Starter")) {
                givePlayerKit(player, getStarterKit());
                player.sendMessage("Now you can start");
            } else if (args[0].equalsIgnoreCase("Food")) {
                givePlayerKit(player, getFoodKit());
                player.sendMessage("Enjoy your Meal");
            } else if (args[0].equalsIgnoreCase("Adventure")) {
                givePlayerKit(player, getAdventureKit());
                player.sendMessage("Good luck Adventurer");
            } else if (args[0].equalsIgnoreCase("OP")) {
                givePlayerKit(player, getOPKit());
                player.sendMessage("Now you are safe!");
            }
        }
        return true;
    }

    public void givePlayerKit(Player player, ArrayList<ItemStack> kit) {
        int itemSlot = 0;
        for (ItemStack itemStack : kit) {
            player.getInventory().setItem(itemSlot, itemStack);
            itemSlot++;
        }
    }

    public ArrayList<ItemStack> getStarterKit() {
        ArrayList<ItemStack> starterKit = new ArrayList<>();
        starterKit.add(new ItemStack(Material.LEATHER_HELMET, 1));
        starterKit.add(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
        starterKit.add(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        starterKit.add(new ItemStack(Material.LEATHER_BOOTS, 1));
        return starterKit;
    }

    public ArrayList<ItemStack> getFoodKit() {
        ArrayList<ItemStack> foodKit = new ArrayList<>();
        foodKit.add(new ItemStack(Material.PORKCHOP, 16));
        foodKit.add(new ItemStack(Material.BREAD, 32));
        foodKit.add(new ItemStack(Material.GOLDEN_APPLE, 1));
        return foodKit;
    }

    public ArrayList<ItemStack> getAdventureKit() {
        ArrayList<ItemStack> adventureKit = new ArrayList<>();
        adventureKit.add(new ItemStack(Material.TURTLE_HELMET, 1));
        adventureKit.add(new ItemStack(Material.ELYTRA, 1));
        adventureKit.add(new ItemStack(Material.GOLDEN_LEGGINGS, 1));
        adventureKit.add(new ItemStack(Material.LEATHER_BOOTS, 1));
        adventureKit.add(new ItemStack(Material.FIREWORK_ROCKET, 32));
        adventureKit.add(new ItemStack(Material.MAP, 32));
        return adventureKit;
    }

    public ArrayList<ItemStack> getOPKit() {
        ArrayList<ItemStack> opKit = new ArrayList<>();
        opKit.add(new ItemStack(Material.NETHERITE_HELMET, 1));
        opKit.add(new ItemStack(Material.NETHERITE_CHESTPLATE, 1));
        opKit.add(new ItemStack(Material.NETHERITE_LEGGINGS, 1));
        opKit.add(new ItemStack(Material.NETHERITE_BOOTS, 1));
        opKit.add(new ItemStack(Material.NETHERITE_SWORD, 1));
        opKit.add(new ItemStack(Material.BOW, 1));
        opKit.add(new ItemStack(Material.GOLDEN_APPLE, 32));
        opKit.add(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 10));
        opKit.get(0).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        opKit.get(0).addEnchantment(Enchantment.THORNS, 3);
        opKit.get(0).addEnchantment(Enchantment.MENDING, 1);
        opKit.get(0).addEnchantment(Enchantment.OXYGEN, 3);
        opKit.get(0).addEnchantment(Enchantment.WATER_WORKER, 1);


        opKit.get(1).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        opKit.get(1).addEnchantment(Enchantment.THORNS, 3);
        opKit.get(1).addEnchantment(Enchantment.MENDING, 1);

        opKit.get(2).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        opKit.get(2).addEnchantment(Enchantment.THORNS, 3);
        opKit.get(2).addEnchantment(Enchantment.MENDING, 1);
        opKit.get(2).addEnchantment(Enchantment.SWIFT_SNEAK, 3);

        opKit.get(3).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        opKit.get(3).addEnchantment(Enchantment.THORNS, 3);
        opKit.get(3).addEnchantment(Enchantment.MENDING, 1);
        opKit.get(3).addEnchantment(Enchantment.PROTECTION_FALL, 4);
        opKit.get(3).addEnchantment(Enchantment.SOUL_SPEED, 3);

        opKit.get(4).addEnchantment(Enchantment.DAMAGE_ALL, 5);
        opKit.get(4).addEnchantment(Enchantment.LOOT_BONUS_MOBS, 3);
        opKit.get(4).addEnchantment(Enchantment.MENDING, 1);
        opKit.get(4).addEnchantment(Enchantment.FIRE_ASPECT, 2);
        opKit.get(4).addEnchantment(Enchantment.SWEEPING_EDGE, 3);

        opKit.get(5).addEnchantment(Enchantment.ARROW_DAMAGE, 5);
        opKit.get(5).addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
        opKit.get(5).addEnchantment(Enchantment.ARROW_FIRE, 1);
        opKit.get(5).addEnchantment(Enchantment.ARROW_INFINITE, 1);
        return opKit;
    }
}
