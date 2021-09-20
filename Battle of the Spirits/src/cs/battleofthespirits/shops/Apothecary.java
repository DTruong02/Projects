package cs.battleofthespirits.shops;

import cs.battleofthespirits.entities.Player;
import cs.battleofthespirits.ui.Format;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * This class controls the shop after the second battle phase.
 * @authors Danny T., Esha S., Ahmad G.
 *
 */

public class Apothecary extends ListenerAdapter {
	Player player = new Player(10, 30, 125);
	
public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase("Apothecary")) {
			EmbedBuilder apothecary = new EmbedBuilder(); 
			
			Format.formatShop(apothecary, "Battle of the Spirits âš”ï¸�ðŸ”®: Apothecary ", "https://i.imgur.com/mwF51iQ.jpg","1ap. Pick the first potion!\n" + "2ap. Pick the second potion!\n", 0x8a0b00, event);
			
			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(apothecary.build()).complete();
			apothecary.clear();
			
		}
		if (args[0].equalsIgnoreCase("1ap")) {
			EmbedBuilder poison = new EmbedBuilder(); 
			
			Format.formatShop(poison, "Battle of the Spirits âš”ï¸�ðŸ”®: You have picked the poison! ", "https://i.imgur.com/NDdXzqs.png","Game Over: You are slowly dying...", 0x8a0b00, event);
			
			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(poison.build()).complete();
			poison.clear();
			
			player.setCharacterHealthPoints(0);
			
			EmbedBuilder gameOver = new EmbedBuilder(); 
			
			Format.formatShop(gameOver, "Battle of the Spirits âš”ï¸�ðŸ”®: Game Over! ", "https://i.imgur.com/8MSDUGb.png","You have died!", 0x8a0b00, event);
			
			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(gameOver.build()).complete();
			gameOver.clear();
		}
		
		if (args[0].equalsIgnoreCase("2ap")) {
			EmbedBuilder extraHealth = new EmbedBuilder(); 
			
			Format.formatShop(extraHealth, "Battle of the Spirits âš”ï¸�ðŸ”®: Type Round3 to Continue! ", "https://i.imgur.com/d6aHz2S.png","Now you have more health! Type Round3 to Continue!.", 0x8a0b00, event);
			
			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(extraHealth.build()).complete();
			extraHealth.clear();
		}
	}

}
