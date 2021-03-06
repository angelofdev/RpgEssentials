package me.duckdoom5.RpgEssentials.GUI;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.blocks.block.CustomBlocks;
import me.duckdoom5.RpgEssentials.blocks.ores.CustomOres;
import me.duckdoom5.RpgEssentials.config.Configuration;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;
import me.duckdoom5.RpgEssentials.util.Hashmaps;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.item.GenericCustomFood;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.material.item.GenericCustomTool;
import org.getspout.spoutapi.player.SpoutPlayer;

public class StoreMethods extends StoreMenu{

	
	public StoreMethods(RpgEssentials instance) {
		super(instance);
	}
	
	public static void buyclick(SpoutPlayer splayer, Button button){
		
		int row = (int) ((button.getY() -20) / 20);
		
		GenericLabel page = StoreMenu.pagewidget.get(splayer);
		if(page.getText().equals("2")){
			row = row + 10;
		}else if(page.getText().equals("3")){
			row = row + 20;
		}else if(page.getText().equals("4")){
			row = row + 30;
		}else if(page.getText().equals("5")){
			row = row + 40;
		}else if(page.getText().equals("6")){
			row = row + 50;
		}else if(page.getText().equals("7")){
			row = row + 60;
		}else if(page.getText().equals("8")){
			row = row + 70;
		}
		
		GenericButton amount = amountwidget.get(splayer);
		int amount2 = Integer.parseInt(amount.getText());
		
		if(!StoreMenu.custom.isEmpty()){
			if(Hashmaps.customitemsmap.containsKey(custom.get(row))){
				GenericCustomItem item = Hashmaps.customitemsmap.get(custom.get(row));
				double money = PlayerConfig.getMoney(splayer.getName());
				double price2 = (Configuration.store.getInt("Store.custom.Items."+ item.getName() +".Price")) * amount2;
				if(money < price2){
					splayer.sendNotification("Error", "Not Enough Money!", new ItemStack(Material.DIAMOND_SWORD), 2000);
				}else{
					splayer.getInventory().addItem(new SpoutItemStack(item, amount2));
					splayer.sendNotification(amount2 + "x " + item.getName(), "Bought for: " + price2 +" "+ Configuration.config.getString("store.currency"), new SpoutItemStack(item), 1000);
					//money min price
					money = money - price2;
					PlayerConfig.setMoney(splayer.getName(),money);
				}
			}else if(Hashmaps.customoresmap.containsKey(custom.get(row))){
				CustomOres ore = Hashmaps.customoresmap.get(custom.get(row));
				double money = PlayerConfig.getMoney(splayer.getName());
				double price2 = (Configuration.store.getInt("Store.custom.Ores."+ ore.getName() +".Price")) * amount2;
				if(money < price2){
					splayer.sendNotification("Error", "Not Enough Money!", new ItemStack(Material.DIAMOND_SWORD), 2000);
				}else{
					splayer.getInventory().addItem(new SpoutItemStack(ore, amount2));
					splayer.sendNotification(amount2 + "x " + ore.getName(), "Bought for: " + price2 +" "+ Configuration.config.getString("store.currency"), new SpoutItemStack(ore), 1000);
					//money min price
					money = money - price2;
					PlayerConfig.setMoney(splayer.getName(),money);
				}
			}else if(Hashmaps.customblocksmap.containsKey(custom.get(row))){
				CustomBlocks block = Hashmaps.customblocksmap.get(custom.get(row));
				double money = PlayerConfig.getMoney(splayer.getName());
				double price2 = (Configuration.store.getInt("Store.custom.Blocks."+ block.getName() +".Price")) * amount2;
				if(money < price2){
					splayer.sendNotification("Error", "Not Enough Money!", new ItemStack(Material.DIAMOND_SWORD), 2000);
				}else{
					splayer.getInventory().addItem(new SpoutItemStack(block, amount2));
					splayer.sendNotification(amount2 + "x " + block.getName(), "Bought for: " + price2 +" "+ Configuration.config.getString("store.currency"), new SpoutItemStack(block), 1000);
					//money min price
					money = money - price2;
					PlayerConfig.setMoney(splayer.getName(),money);
				}
			}else if(Hashmaps.customtoolsmap.containsKey(custom.get(row))){
				GenericCustomTool tool = Hashmaps.customtoolsmap.get(custom.get(row));
				double money = PlayerConfig.getMoney(splayer.getName());
				double price2 = (Configuration.store.getInt("Store.custom.Tools."+ tool.getName() +".Price")) * amount2;
				if(money < price2){
					splayer.sendNotification("Error", "Not Enough Money!", new ItemStack(Material.DIAMOND_SWORD), 2000);
				}else{
					splayer.getInventory().addItem(new SpoutItemStack(tool, amount2));
					splayer.sendNotification(amount2 + "x " + tool.getName(), "Bought for: " + price2 +" "+ Configuration.config.getString("store.currency"), new SpoutItemStack(tool), 1000);
					//money min price
					money = money - price2;
					PlayerConfig.setMoney(splayer.getName(),money);
				}
			}else if(Hashmaps.customfoodmap.containsKey(custom.get(row))){
				GenericCustomFood food = Hashmaps.customfoodmap.get(custom.get(row));
				double money = PlayerConfig.getMoney(splayer.getName());
				double price2 = (Configuration.store.getInt("Store.custom.Food."+ food.getName() +".Price")) * amount2;
				if(money < price2){
					splayer.sendNotification("Error", "Not Enough Money!", new ItemStack(Material.DIAMOND_SWORD), 2000);
				}else{
					splayer.getInventory().addItem(new SpoutItemStack(food, amount2));
					splayer.sendNotification(amount2 + "x " + food.getName(), "Bought for: " + price2 +" "+ Configuration.config.getString("store.currency"), new SpoutItemStack(food), 1000);
					//money min price
					money = money - price2;
					PlayerConfig.setMoney(splayer.getName(),money);
				}
			}
		}else{
			for (Material material:StoreHashmaps.food) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Food", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.tools) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Tools", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.armour) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Armour", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.gardening) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Gardening", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.furniture) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Furniture", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.mechanisms) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Mechanisms", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.brewing) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Brewing", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.materials) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Materials", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.rawmaterials) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Raw Materials", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.minerals) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Minerals", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.misc) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Miscellaneous", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.mobdrops) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Mob Drops", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.music) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Music", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.nether) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Nether", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.ores) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Ores", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.painting) {
				if(material.toString().equals(name.get(row).toString())){
					runBuy("Painting", material, row, amount2, splayer);
				}
			}
		}
	}
	public static void runBuy(String type, Material material, int row, int amount2, SpoutPlayer splayer){
		if(material.toString().toLowerCase().equals("wool") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Painting", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("ink_sack") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Painting", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("coal") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Raw Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("log") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("leaves") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("smooth_brick") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("step") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("double_step") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("sapling") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Gardening", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("long_grass") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Gardening", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("leaves") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Gardening", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("monster_egg") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataBuy("Miscellaneous", material, data, row, amount2, splayer);
		}else{
			if(material.toString().equals(name.get(row).toString())){
				double price2 = Configuration.store.getDouble("Store." + type + "." + material.toString().toLowerCase().replace("_", " ") +".Price");
				double money = PlayerConfig.getMoney(splayer.getName());
				price2 = price2 * amount2;
				if(money < price2){
					splayer.sendNotification("Error", "Not Enough Money!", new ItemStack(Material.DIAMOND_SWORD), 2000);
				}else{
					splayer.getInventory().addItem(new ItemStack(material, amount2));
					splayer.sendNotification(amount2 + "x " + material.toString().toLowerCase().replace("_", " "), "Bought for: " + price2 +" "+ Configuration.config.getString("store.currency"), new ItemStack(material), 1000);
					//money min price
					money = money - price2;
					PlayerConfig.setMoney(splayer.getName(), money);
				}
			}
			
		}
	}
	public static void rundataBuy(String type, Material material, short data, int row, int amount2, SpoutPlayer splayer){
		double price2 = Configuration.store.getDouble("Store." + type + "." + material.toString().toLowerCase().replace("_", " ") +".Price");
		double money = PlayerConfig.getMoney(splayer.getName());
		price2 = price2 * amount2;
		if(money < price2){
			splayer.sendNotification("Not enough money", "Go kill something!", new ItemStack(Material.DIAMOND_SWORD), 2000);
		}else{
			splayer.getInventory().addItem(new ItemStack(material, amount2, data));
			splayer.sendNotification(amount2 + "x " + Methods.getDataName(material, data), "Bought for: " + price2 +" "+ Configuration.config.getString("store.currency"), new ItemStack(material, amount2, data), 1000);
			//money min price
			money = money - price2;
			PlayerConfig.setMoney(splayer.getName(), money);
		}
	}
	public static void sellclick(SpoutPlayer splayer, Button button){
		int row = (int) ((button.getY() -20) / 20);
		
		GenericLabel page = StoreMenu.pagewidget.get(splayer);
		if(page.getText().equals("2")){
			row = row + 10;
		}else if(page.getText().equals("3")){
			row = row + 20;
		}else if(page.getText().equals("4")){
			row = row + 30;
		}else if(page.getText().equals("5")){
			row = row + 40;
		}else if(page.getText().equals("6")){
			row = row + 50;
		}else if(page.getText().equals("7")){
			row = row + 60;
		}else if(page.getText().equals("8")){
			row = row + 70;
		}
		
		GenericButton amount = amountwidget.get(splayer);
		int amount2 = Integer.parseInt(amount.getText());
		
		if(!custom.isEmpty()){
			if(Hashmaps.customitemsmap.containsKey(custom.get(row))){
				GenericCustomItem item = Hashmaps.customitemsmap.get(custom.get(row));
				double money = PlayerConfig.getMoney(splayer.getName());
				double price2 = ((Configuration.store.getDouble("Store.custom.Items."+ item.getName() +".Price")) * amount2) /2;
				splayer.getInventory().removeItem(new SpoutItemStack(item, amount2));
				splayer.sendNotification(amount2 + "x " + item.getName(), "Sold for: " + price2 +" "+ Configuration.config.getString("store.currency"), new SpoutItemStack(item), 1000);
				//money plus price
				money = money + price2;
				PlayerConfig.setMoney(splayer.getName(), money);
			}else if(Hashmaps.customoresmap.containsKey(custom.get(row))){
				CustomOres ore = Hashmaps.customoresmap.get(custom.get(row));
				double money = PlayerConfig.getMoney(splayer.getName());
				double price2 = ((Configuration.store.getDouble("Store.custom.Ores."+ ore.getName() +".Price")) * amount2) /2;
				splayer.getInventory().removeItem(new SpoutItemStack(ore, amount2));
				splayer.sendNotification(amount2 + "x " + ore.getName(), "Sold for: " + price2 +" "+ Configuration.config.getString("store.currency"), new SpoutItemStack(ore), 1000);
				//money plus price
				money = money + price2;
				PlayerConfig.setMoney(splayer.getName(), money);
			}else if(Hashmaps.customblocksmap.containsKey(custom.get(row))){
				CustomBlocks block = Hashmaps.customblocksmap.get(custom.get(row));
				double money = PlayerConfig.getMoney(splayer.getName());
				double price2 = ((Configuration.store.getDouble("Store.custom.Blocks."+ block.getName() +".Price")) * amount2) /2;
				splayer.getInventory().removeItem(new SpoutItemStack(block, amount2));
				splayer.sendNotification(amount2 + "x " + block.getName(), "Sold for: " + price2 +" "+ Configuration.config.getString("store.currency"), new SpoutItemStack(block), 1000);
				//money plus price
				money = money + price2;
				PlayerConfig.setMoney(splayer.getName(), money);
			}else if(Hashmaps.customtoolsmap.containsKey(custom.get(row))){
				GenericCustomTool tool = Hashmaps.customtoolsmap.get(custom.get(row));
				double money = PlayerConfig.getMoney(splayer.getName());
				double price2 = ((Configuration.store.getDouble("Store.custom.Tools."+ tool.getName() +".Price")) * amount2) /2;
				splayer.getInventory().removeItem(new SpoutItemStack(tool, amount2));
				splayer.sendNotification(amount2 + "x " + tool.getName(), "Sold for: " + price2 +" "+ Configuration.config.getString("store.currency"), new SpoutItemStack(tool), 1000);
				//money plus price
				money = money + price2;
				PlayerConfig.setMoney(splayer.getName(), money);
			}else if(Hashmaps.customfoodmap.containsKey(custom.get(row))){
				GenericCustomFood food = Hashmaps.customfoodmap.get(custom.get(row));
				double money = PlayerConfig.getMoney(splayer.getName());
				double price2 = ((Configuration.store.getDouble("Store.custom.Food."+ food.getName() +".Price")) * amount2) /2;
				splayer.getInventory().removeItem(new SpoutItemStack(food, amount2));
				splayer.sendNotification(amount2 + "x " + food.getName(), "Sold for: " + price2 +" "+ Configuration.config.getString("store.currency"), new SpoutItemStack(food), 1000);
				//money plus price
				money = money + price2;
				PlayerConfig.setMoney(splayer.getName(), money);
			}
		}else{
			for (Material material:StoreHashmaps.food) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Food", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.tools) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Tools", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.armour) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Armour", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.gardening) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Gardening", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.furniture) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Furniture", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.mechanisms) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Mechanisms", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.brewing) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Brewing", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.materials) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Materials", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.rawmaterials) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Raw Materials", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.minerals) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Minerals", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.misc) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Miscellaneous", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.mobdrops) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Mob Drops", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.music) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Music", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.nether) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Nether", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.ores) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Ores", material, row, amount2, splayer);
				}
			}
			for (Material material:StoreHashmaps.painting) {
				if(material.toString().equals(name.get(row).toString())){
					runSell("Painting", material, row, amount2, splayer);
				}
			}
		}
	}
	public static void runSell(String type, Material material, int row, int amount2, SpoutPlayer splayer){
		if(material.toString().toLowerCase().equals("wool") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Painting", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("ink_sack") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Painting", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("coal") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Raw Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("log") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("leaves") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("smooth_brick") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("step") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("double_step") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Materials", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("sapling") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Gardening", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("long_grass") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Gardening", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("leaves") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Gardening", material, data, row, amount2, splayer);
		}else if(material.toString().toLowerCase().equals("monster_egg") && material.toString().equals(name.get(row).toString())){
			Short data = datamap.get(row);
			rundataSell("Miscellaneous", material, data, row, amount2, splayer);
		}else{
			if(material.toString().equals(name.get(row).toString())){
				double price2 = Configuration.store.getDouble("Store." + type + "." + material.toString().toLowerCase().replace("_", " ") +".Price");
				double money = PlayerConfig.getMoney(splayer.getName());
				if(!splayer.getInventory().contains(material)){
					splayer.sendNotification("Not enough " + material.toString().toLowerCase().replace("_", " "), "Please buy some!", new ItemStack(Material.ARROW), 1000);
				}else{
					if(!splayer.getInventory().contains(material, amount2)){
						splayer.sendNotification("Not enough " + material.toString().toLowerCase().replace("_", " "), "Change your amount!", new ItemStack(Material.ARROW), 1000);
					}else{
						price2 = (price2 * amount2) / 2;
						
						splayer.getInventory().removeItem(new ItemStack(material, amount2));
						splayer.sendNotification(amount2 + "x " + material.toString().toLowerCase().replace("_", " "), "Sold for: " + price2 +" "+ Configuration.config.getString("store.currency"), new ItemStack(material), 1000);
						//money plus price
						money = money + price2;
						PlayerConfig.setMoney(splayer.getName(), money);
					}
				}
			}
			
		}
	}
	public static void rundataSell(String type, Material material, short data, int row, int amount2, SpoutPlayer splayer){
		
		double price2 = Configuration.store.getDouble("Store." + type + "." + material.toString().toLowerCase().replace("_", " ") +".Price");
		double money = PlayerConfig.getMoney(splayer.getName());
		price2 = (price2 * amount2) / 2;
		
		splayer.getInventory().removeItem(new ItemStack(material, amount2, data));
		splayer.sendNotification(amount2 + "x " + Methods.getDataName(material, data), "Sold for: " + price2 +" "+ Configuration.config.getString("store.currency"), new ItemStack(material, amount2, data), 1000);
		//money plus price
		money = money + price2;
		PlayerConfig.setMoney(splayer.getName(), money);
	}
	
	public static void nextclick(Plugin plugin, SpoutPlayer splayer){
		GenericLabel page = pagewidget.get(splayer);
		int pagenum = Integer.parseInt(page.getText()) + 1;
		if(pagenum > 8){
			pagenum = 8;
		}
		page.setText(Integer.toString(pagenum));
    	if(pagenum == 2){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup2.get(splayer));
    	}else if(pagenum == 3){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup3.get(splayer));
    	}else if(pagenum == 4){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup4.get(splayer));
    	}else if(pagenum == 5){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup5.get(splayer));
    	}else if(pagenum == 6){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup6.get(splayer));
    	}else if(pagenum == 7){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup7.get(splayer));
    	}else if(pagenum == 8){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup8.get(splayer));
    	}
	}
	public static void prevclick(Plugin plugin, SpoutPlayer splayer){
		GenericLabel page = pagewidget.get(splayer);
		int pagenum = Integer.parseInt(page.getText()) - 1;
		page.setText(Integer.toString(pagenum));
		if(pagenum < 1){
			pagenum = 1;
		}
    	if(pagenum == 1){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup1.get(splayer));
    	}else if(pagenum == 2){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup2.get(splayer));
    	}else if(pagenum == 3){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup3.get(splayer));
    	}else if(pagenum == 4){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup4.get(splayer));
    	}else if(pagenum == 5){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup5.get(splayer));
    	}else if(pagenum == 6){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup6.get(splayer));
    	}else if(pagenum == 7){
    		if(splayer.getActiveScreen() == ScreenType.CUSTOM_SCREEN){
    			splayer.getMainScreen().getActivePopup().close();
    		}
    		splayer.getMainScreen().attachPopupScreen(storepopup7.get(splayer));
    	}
	}
}
