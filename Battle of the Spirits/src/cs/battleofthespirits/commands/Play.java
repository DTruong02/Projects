package cs.battleofthespirits.commands;

import cs.battleofthespirits.Main;
import cs.battleofthespirits.ui.Format;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * This class initializes the instructions.
 * @authors Danny T., Esha S., Ahmad G.
 *
 */

public class Play extends ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(Main.prefix + "play")) {
			EmbedBuilder play = new EmbedBuilder(); 
			
			Format.formatMain(play, "Battle of the Spirits ⚔️🔮 ", "https://media.giphy.com/media/YmPuKJoibswQVvaDRa/source.gif", 0x8a0b00, event);
			
			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(play.build()).queue();
			play.clear();
			
		}
	}
}
			
