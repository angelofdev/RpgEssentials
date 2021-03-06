package me.duckdoom5.RpgEssentials.config;

import java.io.FileNotFoundException;
import java.io.IOException;

import me.duckdoom5.RpgEssentials.RpgEssentials;

public class Configuration {

private static final String h = "[RpgEssentials] ";

public static MyConfiguration config;
public static MyConfiguration block;
public static MyConfiguration entity;
public static MyConfiguration generator;
public static MyConfiguration items;
public static MyConfiguration level;
public static MyConfiguration players;
public static MyConfiguration region;
public static MyConfiguration store;
public static MyConfiguration npc;
public static MyConfiguration bank;
public static MyConfiguration texture;
public static MyConfiguration mail;
public static MyConfiguration modules;
public static MyConfiguration quests;

	static {
		config = new MyConfiguration();
		block = new MyConfiguration();
		entity = new MyConfiguration();
		generator = new MyConfiguration();
		items = new MyConfiguration();
		level = new MyConfiguration();
		players = new MyConfiguration();
		region = new MyConfiguration();
		store = new MyConfiguration();
		npc = new MyConfiguration();
		bank = new MyConfiguration();
		texture = new MyConfiguration();
		mail = new MyConfiguration();
		modules = new MyConfiguration();
		quests = new MyConfiguration();
		
		if(load(config,"config.yml")){
			config = MyConfiguration.loadConfiguration("plugins/RpgEssentials/config.yml");
			Config.set();
			save(config);
		}
		Config.set();
		try {
			config.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(block,"blocks.yml")){
			block = MyConfiguration.loadConfiguration("plugins/RpgEssentials/blocks.yml");
			BlockConfig.set();
			save(block);
		}
		BlockConfig.set();
		try {
			block.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(entity,"entities.yml")){
			entity = MyConfiguration.loadConfiguration("plugins/RpgEssentials/Temp/entities.yml");
			EntityConfig.set();
			save(entity);
		}
		EntityConfig.set();
		try {
			entity.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(generator,"worldgenerator.yml")){
			generator = MyConfiguration.loadConfiguration("plugins/RpgEssentials/worldgenerator.yml");
			GeneratorConfig.set();
			save(generator);
		}
		GeneratorConfig.set();
		try {
			generator.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(items,"items.yml")){
			items = MyConfiguration.loadConfiguration("plugins/RpgEssentials/items.yml");
			ItemConfig.set();
			save(items);
		}
		ItemConfig.set();
		try {
			items.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (load(level,"leveling.yml")){
			level = MyConfiguration.loadConfiguration("plugins/RpgEssentials/leveling.yml");
			LevelConfig.set();
			save(level);
		}
		LevelConfig.set();
		try {
			level.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(players, "Temp/Players.yml")){
			players = MyConfiguration.loadConfiguration("plugins/RpgEssentials/Temp/Players.yml");
			PlayerConfig.set();
			save(players);
		}
		PlayerConfig.set();
		try {
			players.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(region,"regions.yml")){
			region = MyConfiguration.loadConfiguration("plugins/RpgEssentials/regions.yml");
			RegionConfig.set();
			save(region);
		}
		RegionConfig.set();
		try {
			region.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(npc,"Temp/Npc.yml")){
			npc = MyConfiguration.loadConfiguration("plugins/RpgEssentials/Temp/Npc.yml");
			NpcConfig.set();
			save(npc);
		}
		NpcConfig.set();
		try {
			npc.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(bank,"Temp/Bank.yml")){
			bank = MyConfiguration.loadConfiguration("plugins/RpgEssentials/Temp/Bank.yml");
			BankConfig.set();
			save(bank);
		}
		BankConfig.set();
		try {
			bank.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(texture,"textures.yml")){
			texture = MyConfiguration.loadConfiguration("plugins/RpgEssentials/textures.yml");
			TextureConfig.set();
			save(texture);
		}
		TextureConfig.set();
		try {
			texture.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(mail,"Temp/mail.yml")){
			mail = MyConfiguration.loadConfiguration("plugins/RpgEssentials/Temp/mail.yml");
			MailConfig.set();
			save(mail);
		}
		MailConfig.set();
		try {
			mail.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(modules,"modules.yml")){
			modules = MyConfiguration.loadConfiguration("plugins/RpgEssentials/modules.yml");
			ModulesConfig.set();
			save(modules);
		}
		ModulesConfig.set();
		try {
			modules.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(quests,"quests.yml")){
			quests = MyConfiguration.loadConfiguration("plugins/RpgEssentials/quests.yml");
			QuestConfig.set();
			save(quests);
		}
		QuestConfig.set();
		try {
			quests.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(load(store,"store.yml")){
			store = MyConfiguration.loadConfiguration("plugins/RpgEssentials/store.yml");
			StoreConfig.set();
			save(store);
		}
		StoreConfig.set();
		try {
			store.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void start(){
		RpgEssentials.log.info(h+"Static Configuration loading...");
	}

	private static void exclaim(String filename){
		RpgEssentials.log.info(h+"Saved file "+ filename + "!");
	}

	private static void complain(String filename){
		RpgEssentials.log.severe(h+"On file "+ filename + ":");
		RpgEssentials.log.severe(h+"Invalid configuration! Did you use tabs or restrict permissions?");
	}

	private static void complainFileCreation(String filename){
		RpgEssentials.log.severe(h+"On file "+ filename + ":");
		RpgEssentials.log.severe(h+"Could NOT create default files! Did you restrict permissions?");
	}

// return true if defaults need to be created
	private static boolean load(MyConfiguration y, String name){
		try {
			y.load("plugins/RpgEssentials/"+name);
		} catch (FileNotFoundException e) {
			return true;
		} catch (Exception e) {
			complain(name);
		}
		return false;
	}

	private static void save(MyConfiguration y){
		try {
			y.save();
			try {
				y.load("plugins/RpgEssentials/" + y.getFilename());
			} catch (Exception e) {
			}
			exclaim(y.getFilename());
		} catch (IOException e) {
			complainFileCreation(y.getFilename());
		}
	}
}