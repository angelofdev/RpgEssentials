package me.duckdoom5.RpgEssentials.blocks.misc;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.StoreMenu;

import org.bukkit.World;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.material.block.GenericCubeCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

public class CheckoutBlockE extends GenericCubeCustomBlock{
	private static int[] id = {0,0,0,0,0,0};
	private RpgEssentials plugin;
	public CheckoutBlockE(RpgEssentials plugin) {
		super(plugin, "Checkout(E)", false,new GenericCubeBlockDesign(plugin, plugin.misc, id));
		this.setBlockDesign(new CheckoutDesign(plugin, plugin.misc, "East"));
		this.plugin = plugin;
	}
	
	@Override
	public boolean onBlockInteract(World world, int x, int y, int z, SpoutPlayer splayer) {
	StoreMenu.open(plugin, splayer);
	return true;
	}
}