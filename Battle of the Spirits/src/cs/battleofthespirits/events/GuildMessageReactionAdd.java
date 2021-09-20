package cs.battleofthespirits.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReactionAdd extends ListenerAdapter{
	public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
		
		System.out.println(event.getReactionEmote().getName());
		if (event.getReactionEmote().getName().equals("⚔")) {
			EmbedBuilder play = new EmbedBuilder(); 
			play.setTitle("Battle of the Spirits âš”ï¸�ðŸ”® "); 
			play.setImage("https://media.giphy.com/media/KETCI529b6u4nLAiL0/source.gif");
			play.setDescription("1. Swing your Sword\n" + "2. Raise your Shield\n" + "3. Throw a Left Hook" );
			play.setColor(0x8a0b00);
			play.setFooter("Created by ICS4UO", event.getMember().getUser().getAvatarUrl()); 
			play.clear();
			}
		}
}