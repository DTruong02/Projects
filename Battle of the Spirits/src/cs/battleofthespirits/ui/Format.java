package cs.battleofthespirits.ui;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

/**
 * This class controls the graphical format of the game.
 * @authors Danny T., Esha S., Ahmad G.
 *
 */

public class Format {
	
	// Formats the text for introduction
	public static void formatMain(EmbedBuilder build, String title, String image, int colour, GuildMessageReceivedEvent event) {
		build.setTitle(title); 
		build.setImage(image);
		build.setColor(colour);
		build.setFooter("Created by ICS4UO",event.getMember().getUser().getAvatarUrl()); 
	}
	
	// Formats the text within battle stages
	public static void formatBattle(EmbedBuilder build, String title, String image, String desc, int colour, GuildMessageReceivedEvent event) {
		build.setTitle(title); 
		build.setImage(image);
		build.setDescription(desc);
		build.setColor(colour);
		build.setFooter("Created by ICS4UO",event.getMember().getUser().getAvatarUrl()); 
		
	}
	
	// Formats the text within shops
	public static void formatShop(EmbedBuilder build, String title, String image, String desc, int colour, GuildMessageReceivedEvent event) {
		build.setTitle(title); 
		build.setImage(image);
		build.setDescription(desc);
		build.setColor(colour);
		build.setFooter("Created by ICS4UO",event.getMember().getUser().getAvatarUrl()); 
		
	}
}
