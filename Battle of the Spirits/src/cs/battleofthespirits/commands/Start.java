package cs.battleofthespirits.commands;

import cs.battleofthespirits.ui.Format;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * This class initializes.
 * @authors Danny T., Esha S., Ahmad G.
 *
 */

public class Start extends ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase("start")) {
			EmbedBuilder play = new EmbedBuilder(); 
			
			Format.formatMain(play, "Battle of the Spirits ⚔️🔮 ", "https://i.imgur.com/QK4iQn4.png", 0x8a0b00, event);
			
			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(play.build()).complete();
			play.clear();
			
		}
	}
}
			
