package cs.battleofthespirits;

import javax.security.auth.login.LoginException;

import cs.battleofthespirits.commands.RoundA;
import cs.battleofthespirits.commands.RoundB;
import cs.battleofthespirits.commands.RoundBS;
import cs.battleofthespirits.commands.RoundC;
import cs.battleofthespirits.commands.Play;
import cs.battleofthespirits.commands.Start;
import cs.battleofthespirits.shops.Apothecary;
import cs.battleofthespirits.shops.SwordShop;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

/**
 * This class initializes the events and the bot.
 * @authors Danny T., Esha S., Ahmad G.
 *
 */

public class Main {
	
	public static JDA jda; 
	public static String prefix = "~";

	// Main method
	public static void main(String[] args) throws LoginException {
		 
		 JDABuilder builder = new JDABuilder(); 
		 builder.setToken("NzE3NDM3Njc2ODQ3ODkwNTMy.XuaQHw.on32v-fSXA5FWtNh_6r3CTdNTbA");
		 builder.setStatus(OnlineStatus.ONLINE);
		 builder.setActivity(Activity.playing("Battle of the Spirits || ~play "));
		
		 // Commands
		
		 builder.addEventListeners(new Play());
		 builder.addEventListeners(new Start()); 
		 builder.addEventListeners(new RoundA());
		 builder.addEventListeners(new RoundB()); 
		 builder.addEventListeners(new RoundBS());
		 builder.addEventListeners(new RoundC()); 
		 builder.addEventListeners(new Apothecary()); 
		 builder.addEventListeners(new SwordShop()); 
		 builder.build(); 

		 
	}

}
