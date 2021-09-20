package cs.battleofthespirits.commands;

import net.dv8tion.jda.api.EmbedBuilder; 

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Random;

import cs.battleofthespirits.entities.Enemy;
import cs.battleofthespirits.entities.Player;
import cs.battleofthespirits.ui.Format;

/**
 * This class controls the first round of combat.
 * @authors Danny T., Esha S., Ahmad G.
 *
 */

public class RoundA extends ListenerAdapter {
	
	// Initializing the player and enemy within fight
	Player player = new Player(20, 40, 100);
	Enemy redEye = new Enemy(10, 20, 100);
	
	boolean roundA = true; 
	
	// Detects if message is sent in a discord channel
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		// Array of words from sent message
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		 
		
		if (args[0].equalsIgnoreCase("begin")) {
			
			EmbedBuilder begin = new EmbedBuilder(); 
			
			Format.formatBattle(begin, "Battle of the Spirits ⚔️🔮: Type Your Move", "https://media.giphy.com/media/KETCI529b6u4nLAiL0/source.gif", "1a. Swing your Sword\n" + "2a. Raise your Shield\n"
								+ "3a. Throw a Left Hook\n" + "Your Health: " + player.getCharacterHealthPoints() + "\n" + "Enemy's Health: " + redEye.getHealthPoints(), 0x8a0b00, event);
			
			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(begin.build()).queue();
			begin.clear();

		}
			
			if (args[0].equalsIgnoreCase("1a")) {
				
				
				Random r = new Random();
				int min = 0; 
				int max = 4; 
				int random_number = r.nextInt(max - min + 1) + min;
				
				if (random_number >= 0 && random_number <= 3) {
				EmbedBuilder battleMove1aP = new EmbedBuilder(); 

				// If and else if statement to prevent enemy health from going below 0.
				if (redEye.getHealthPoints() - player.swordSwingAttack() > 0) {
					redEye.setHealthPoints(redEye.getHealthPoints() - player.swordSwingAttack());
				}
				else if (redEye.getHealthPoints() - player.swordSwingAttack() <= 0) {
					redEye.setHealthPoints(0);
				}
				
				Format.formatBattle(battleMove1aP, "Battle of the Spirits ⚔️🔮: Your Attack ", "https://media.giphy.com/media/hv4vxkvJtzPH5RND9H/source.gif", "*Your Sword Swing was successful!*\n"
									+ "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + redEye.getHealthPoints(), 0x8a0b00, event);
				
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(battleMove1aP.build()).queue();
				battleMove1aP.clear();
				
				EmbedBuilder enemyMove1aP = new EmbedBuilder(); 
				
				// If and else if statement to prevent player health from going below 0.
				if (player.getCharacterHealthPoints() - redEye.attack() > 0) {
					player.setCharacterHealthPoints(player.getCharacterHealthPoints() - redEye.attack());
				}
				else if (player.getCharacterHealthPoints() - redEye.attack() <= 0 ) {
					player.setCharacterHealthPoints(0);
				}
				
				Format.formatBattle(enemyMove1aP, "Battle of the Spirits ⚔️🔮: Type Your Next Move", "https://media.giphy.com/media/U2MDo1urRggnleRzkS/source.gif", "*You have been hit!*\n" +  "1a. Swing your Sword\n"
									+ "2a. Raise your Shield\n" + "3a. Throw a Left Hook\n" + "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + redEye.getHealthPoints(), 0x8a0b00, event);
			
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(enemyMove1aP.build()).queue();
				enemyMove1aP.clear();
				
				}
				
				else if (random_number == 4) {
					EmbedBuilder battleMove1aF = new EmbedBuilder(); 
					
					Format.formatBattle(battleMove1aF, "Battle of the Spirits ⚔️🔮: Your Attack! ", "https://media.giphy.com/media/kF0DvMygDwSzTIgNKg/source.gif", "*Your Sword Swing has failed!*\n" + "Your Health: "
										+ player.getCharacterHealthPoints() + "\n" + "Enemy's Health: " + redEye.getHealthPoints(), 0x8a0b00, event);
					
					event.getChannel().sendTyping().queue(); 
					event.getChannel().sendMessage(battleMove1aF.build()).queue();
					battleMove1aF.clear();
					
					EmbedBuilder enemyMove1aP = new EmbedBuilder(); 
					
					if (player.getCharacterHealthPoints() - redEye.attack() > 0) {
						player.setCharacterHealthPoints(player.getCharacterHealthPoints() - redEye.attack()); 
					}
					else if (player.getCharacterHealthPoints() - redEye.attack() <= 0) {
						player.setCharacterHealthPoints(0);
					}
					
					Format.formatBattle(enemyMove1aP, "Battle of the Spirits ⚔️🔮: Type Your Next Move! ", "https://media.giphy.com/media/U2MDo1urRggnleRzkS/source.gif", "*You have been hit!*\n" +  "1a. Swing your Sword\n"
										+ "2a. Raise your Shield\n" + "3a. Throw a Left Hook\n" + "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + redEye.getHealthPoints(), 0x8a0b00, event);
				
					event.getChannel().sendTyping().queue(); 
					event.getChannel().sendMessage(enemyMove1aP.build()).queue();
					enemyMove1aP.clear();
					
				}
					
						
					}
		
			if (args[0].equalsIgnoreCase("2a")) {
				int min = 0; 
				int max = 2; 
				int random_number = (int)(Math.random() * (max - min + 1) + min);
				
				if (random_number >= 0 && random_number <= 1) {
				EmbedBuilder battleMove2aP = new EmbedBuilder(); 
				
				Format.formatBattle(battleMove2aP, "Battle of the Spirits ⚔️🔮: Your Move ", "https://media.giphy.com/media/U2MDo1urRggnleRzkS/source.gif", "*You raised your shield and has protected you!*\n"
									+ "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + redEye.getHealthPoints(), 0x8a0b00, event);
				
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(battleMove2aP.build()).queue();
				battleMove2aP.clear();
				
				EmbedBuilder nextMove2a = new EmbedBuilder(); 
				
				Format.formatBattle(nextMove2a, "Battle of the Spirits ⚔️🔮: Type Your Next Move ", "https://media.giphy.com/media/VbDtFRu2YHmGeyxX6B/giphy.gif", "1a. Swing your Sword\n" + "2a. Raise your Shield\n" + "3a. Throw a Left Hook\n"
									+ "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + redEye.getHealthPoints(), 0x8a0b00, event);
				
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(nextMove2a.build()).queue();
				nextMove2a.clear();
				
				
				}
				if (random_number == 2 ) {
				EmbedBuilder battleMove2aF = new EmbedBuilder(); 
					
				Format.formatBattle(battleMove2aF, "Battle of the Spirits ⚔️🔮: Your Move ", "https://media.giphy.com/media/kyL5t3kPjjqlVHMiD0/source.gif", "*You failed to raise your shield!*\n"
										+ "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + redEye.getHealthPoints(), 0x8a0b00, event);
					
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(battleMove2aF.build()).queue();
				battleMove2aF.clear();
				
				EmbedBuilder enemyMove2aP = new EmbedBuilder(); 
				
				if (player.getCharacterHealthPoints() - redEye.attack() > 0 ) {
					player.setCharacterHealthPoints(player.getCharacterHealthPoints() - redEye.attack());
				}
				else if (player.getCharacterHealthPoints() -redEye.attack() <= 0) {
					player.setCharacterHealthPoints(0);
				}
				
				Format.formatBattle(enemyMove2aP, "Battle of the Spirits ⚔️🔮: Type Your Next Move", "https://media.giphy.com/media/U2MDo1urRggnleRzkS/source.gif", "*You have been hit!*\n" +  "1a. Swing your Sword\n"
									+ "2a. Raise your Shield\n" + "3a. Throw a Left Hook\n" + "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + redEye.getHealthPoints(), 0x8a0b00, event);
			
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(enemyMove2aP.build()).queue();
				enemyMove2aP.clear();
				
				
					
				}
			}
			
			if (args[0].equalsIgnoreCase("3a")) {
				Random r = new Random();
				int min = 0; 
				int max = 4; 
				int random_number = r.nextInt(max - min + 1) + min;
				
				if (random_number >= 0 && random_number <= 2) {
				EmbedBuilder battleMove3aP = new EmbedBuilder(); 

				if (redEye.getHealthPoints() - player.punchAttack() > 0) {
					redEye.setHealthPoints(redEye.getHealthPoints() - player.punchAttack());
				}
				else if (redEye.getHealthPoints() - player.punchAttack() <= 0) {
					redEye.setHealthPoints(0);
				}
				Format.formatBattle(battleMove3aP, "Battle of the Spirits ⚔️🔮: Your Attack ", "https://media.giphy.com/media/MaV9tvxKKK0wBnOY73/source.gif", "*Your punch was successful!*\n"
									+ "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + redEye.getHealthPoints(), 0x8a0b00, event);
				
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(battleMove3aP.build()).queue();
				battleMove3aP.clear();
				
				EmbedBuilder enemyMove3aP = new EmbedBuilder(); 
				
				if (player.getCharacterHealthPoints() - redEye.attack() > 0) {
					player.setCharacterHealthPoints(player.getCharacterHealthPoints() - redEye.attack());
				}
				else if (player.getCharacterHealthPoints() - redEye.attack() <= 0) {
					player.setCharacterHealthPoints(0);
				}
				
				Format.formatBattle(enemyMove3aP, "Battle of the Spirits ⚔️🔮: Type Your Next Move", "https://media.giphy.com/media/U2MDo1urRggnleRzkS/source.gif", "*You have been hit!*\n" +  "1a. Swing your Sword\n"
									+ "2a. Raise your Shield\n" + "3a. Throw a Left Hook\n" + "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + redEye.getHealthPoints(), 0x8a0b00, event);
			
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(enemyMove3aP.build()).queue();
				enemyMove3aP.clear();
				
				}
				
				else if (random_number >= 3 && random_number <= 4) {
					EmbedBuilder battleMove1aF = new EmbedBuilder(); 
					
					Format.formatBattle(battleMove1aF, "Battle of the Spirits ⚔️🔮: Your Attack! ", "https://media.giphy.com/media/kF0DvMygDwSzTIgNKg/source.gif", "*You missed your punch!*\n" + "Your Health: "
										+ player.getCharacterHealthPoints() + "\n" + "Enemy's Health: " + redEye.getHealthPoints(), 0x8a0b00, event);
					
					event.getChannel().sendTyping().queue(); 
					event.getChannel().sendMessage(battleMove1aF.build()).queue();
					battleMove1aF.clear();
					
					EmbedBuilder enemyMove3aP = new EmbedBuilder(); 
					
					if (player.getCharacterHealthPoints() - redEye.attack() > 0) {
						player.setCharacterHealthPoints(player.getCharacterHealthPoints() - redEye.attack());
					}
					else if (player.getCharacterHealthPoints() - redEye.attack() <= 0) {
						player.setCharacterHealthPoints(0); 
					}
					
					Format.formatBattle(enemyMove3aP, "Battle of the Spirits ⚔️🔮: Type Your Next Move! ", "https://media.giphy.com/media/U2MDo1urRggnleRzkS/source.gif", "*You have been hit!*\n" +  "1a. Swing your Sword\n"
										+ "2a. Raise your Shield\n" + "3a. Throw a Left Hook\n" + "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + redEye.getHealthPoints(), 0x8a0b00, event);
				
					event.getChannel().sendTyping().queue(); 
					event.getChannel().sendMessage(enemyMove3aP.build()).queue();
					enemyMove3aP.clear();
					
				}
					
						
					}
				
				
				
				if (player.getCharacterHealthPoints() == 0 && !event.getAuthor().isBot() && roundA == true) {
					EmbedBuilder gameOver = new EmbedBuilder(); 
					
					Format.formatBattle(gameOver, "Battle of the Spirits ⚔️🔮: Game Over!", "https://i.imgur.com/3xFtuF8.png", "*You have died!*\n"
										 + "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + redEye.getHealthPoints(), 0x8a0b00, event);
				
					event.getChannel().sendTyping().queue(); 
					event.getChannel().sendMessage(gameOver.build()).queue();
					gameOver.clear();
					roundA = false; 
				}
				
				if (redEye.getHealthPoints() == 0 && !event.getAuthor().isBot() && roundA == true)  {
					EmbedBuilder nextRound = new EmbedBuilder(); 
					
					Format.formatBattle(nextRound, "Battle of the Spirits ⚔️🔮: You Defeated Red Eye!", "https://i.imgur.com/J4C9ey7.png", "*You have won!*\n"
										 + "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + redEye.getHealthPoints(), 0x8a0b00, event);
					
					event.getChannel().sendTyping().queue(); 
					event.getChannel().sendMessage(nextRound.build()).queue();
					nextRound.clear();
					
					roundA = false; 
				}
				
				
				
			}
}
				
	


			
