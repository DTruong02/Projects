package cs.battleofthespirits.shops;

import cs.battleofthespirits.ui.Format;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * This class controls the shop after the first battle phase.
 * @authors Danny T., Esha S., Ahmad G.
 *
 */

public class SwordShop extends ListenerAdapter {
	
public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase("SwordShop")) {
			EmbedBuilder swordShop = new EmbedBuilder(); 
			
			Format.formatShop(swordShop, "Battle of the Spirits âš”ï¸�ðŸ”®: Sword Shop ", "https://i.imgur.com/2Ej9MhB.jpg","1s. Pick the first sword\n" + "2s. Pick the second sword\n" + "3s. Pick the third sword\n", 0x8a0b00, event);
			
			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(swordShop.build()).complete();
			swordShop.clear();
			
		}
		if (args[0].equalsIgnoreCase("1s") || args[0].equalsIgnoreCase("3s")) {
			EmbedBuilder fakeSword = new EmbedBuilder();
			
			Format.formatShop(fakeSword, "Battle of the Spirits âš”ï¸�ðŸ”®: You have picked a fake sword! ", "https://i.imgur.com/FYI0l8a.png","Type Round2 to continue your journey!", 0x8a0b00, event);
			
			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(fakeSword.build()).complete();
			fakeSword.clear();
		}
		
		if (args[0].equalsIgnoreCase("2s")) {
			EmbedBuilder realSword = new EmbedBuilder(); 
			
			Format.formatShop(realSword, "Battle of the Spirits âš”ï¸�ðŸ”®: Congrats, you have picked a real sword! ", "https://i.imgur.com/fEyJshH.png","Type Round2s to continue your journey!", 0x8a0b00, event);
			
			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(realSword.build()).complete();
			realSword.clear();
		}
	}

}
