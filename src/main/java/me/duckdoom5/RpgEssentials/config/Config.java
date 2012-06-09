package me.duckdoom5.RpgEssentials.config;

import java.util.Arrays;

public class Config {

	public static void set(){
		
		if(!Configuration.config.contains("player.join.enabled")){
			Configuration.config.set("player.join.enabled",true);
		}
		if(!Configuration.config.contains("player.leave.enabled")){
			Configuration.config.set("player.leave.enabled",true);
		}
		if(!Configuration.config.contains("player.starting money")){
			Configuration.config.set("player.starting money",100);
		}
		if(!Configuration.config.contains("player.close gui on damage")){
			Configuration.config.set("player.close gui on damage",true);
		}
		
		if(!Configuration.config.contains("deathchest.protect time in minutes")){
			Configuration.config.set("deathchest.protect time in minutes", 5);
		}
		if(!Configuration.config.contains("deathchest.unprotect time in minutes")){
			Configuration.config.set("deathchest.unprotect time in minutes", 5);
		}
		
		if(!Configuration.config.contains("worlds.enabled")){
			Configuration.config.set("worlds.enabled",Arrays.asList("RPG"));
		}
		
		if(!Configuration.config.contains("store.allow")){
			Configuration.config.set("store.allow", false);
		}
		if(!Configuration.config.contains("store.key")){
			Configuration.config.set("store.key", "o");
		}
		if(!Configuration.config.contains("store.currency")){
			Configuration.config.set("store.currency","Dollar");
		}
		
		if(!Configuration.config.contains("bank.size.18.price")){
			Configuration.config.set("bank.size.18.price", 100);
		}
		if(!Configuration.config.contains("bank.size.27.price")){
			Configuration.config.set("bank.size.27.price", 500);
		}
		if(!Configuration.config.contains("bank.size.36.price")){
			Configuration.config.set("bank.size.36.price", 1000);
		}
		if(!Configuration.config.contains("bank.size.45.price")){
			Configuration.config.set("bank.size.45.price", 2000);
		}
		if(!Configuration.config.contains("bank.size.54.price")){
			Configuration.config.set("bank.size.54.price", 5000);
		}
		if(!Configuration.config.contains("bank.bankers.openbank")){
			Configuration.config.set("bank.bankers.openbank", false);
		}
		
		if(!Configuration.config.contains("stats.allow")){
			Configuration.config.set("stats.allow", true);
		}
		if(!Configuration.config.contains("stats.key")){
			Configuration.config.set("stats.key", "l");
		}
		if(!Configuration.config.contains("spout.leave.messageicon")){
			Configuration.config.set("spout.leave.messageicon",260);
		}
		if(!Configuration.config.contains("spout.join.messageicon")){
			Configuration.config.set("spout.join.messageicon",322);
		}
		if(!Configuration.config.contains("spout.join.message")){
			Configuration.config.set("spout.join.message","Welcome to the server!");
		}
		if(!Configuration.config.contains("spout.join.submessage")){
			Configuration.config.set("spout.join.submessage","Have a good time");
		}
		if(!Configuration.config.contains("spout.precache")){
			Configuration.config.set("spout.precache", Arrays.asList("http://dl.dropbox.com/u/62672791/textures/XXMrPiggyCompanyXX.zip"));
		}
		if(!Configuration.config.contains("texturepack.default")){
			Configuration.config.set("texturepack.default","http://dl.dropbox.com/u/62672791/textures/XXMrPiggyCompanyXX.zip");
		}
		if(!Configuration.config.contains("texturepack.worldname")){
			Configuration.config.set("texturepack.worldname","http://dl.dropbox.com/u/62672791/textures/XXMrPiggyCompanyXX.zip");
		}
	}
}