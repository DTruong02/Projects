package cs.battleofthespirits.commands;

import net.dv8tion.jda.api.EmbedBuilder; 

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Random;

import cs.battleofthespirits.entities.Nyx;
import cs.battleofthespirits.entities.Player;
import cs.battleofthespirits.ui.Format;

/**
 * This class controls the second round of combat.
 * @authors Danny T., Esha S., Ahmad G.
 *
 */

public class RoundB extends ListenerAdapter {
	
	Player player = new Player(20, 40, 100); //Use same player object from previous classes
	
	Nyx nyx = new Nyx(20, 35, 110);
	
	boolean roundB = true; 
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase("round2")) {
			EmbedBuilder round2a = new EmbedBuilder(); 
			Format.formatBattle(round2a, "Battle of the Spirits ⚔️🔮: Round 2", "https://i.imgur.com/WSWUtKB.jpg", "The New Round Begins\n"
					 + "Your Health: " + player.getCharacterHealthPoints() + "\n" + "Enemy's Health: " + nyx.getHealthPoints(), 0x8a0b00, event);

			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(round2a.build()).queue();
			round2a.clear();
			
			EmbedBuilder round2b = new EmbedBuilder(); 
			Format.formatBattle(round2b, "Battle of the Spirits ⚔️🔮: Type Your Move", "https://media.giphy.com/media/W1SyMKZVBEyIjXqrHr/source.gif", "1b. Swing your Sword\n" + "2b. Raise your Shield\n"
								+ "3b. Throw a Kick\n" + "Your Health: " + player.getCharacterHealthPoints() + "\n" + "Enemy's Health: " + nyx.getHealthPoints(), 0x8a0b00, event);
			
			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(round2b.build()).queue();
			round2b.clear();

		}
			
			if (args[0].equalsIgnoreCase("1b")) {
				Random r = new Random();
				int min = 0; 
				int max = 4; 
				int random_number = r.nextInt(max - min + 1) + min;
				
				if (random_number >= 0 && random_number <= 3) {
					EmbedBuilder battleMove1bP = new EmbedBuilder(); 
				
					if (nyx.getHealthPoints() - player.swordSwingAttack() > 0) {
						nyx.setHealthPoints(nyx.getHealthPoints() - player.swordSwingAttack());
					}
					
					else if (nyx.getHealthPoints() - player.swordSwingAttack() <= 0) { 
						nyx.setHealthPoints(0);
					}
				
					Format.formatBattle(battleMove1bP, "Battle of the Spirits ⚔️🔮: Your Attack ", "https://media.giphy.com/media/lMf6jIBPbOzKklg86t/source.gif", "*Your Sword Swing was successful!*\n"
									+ "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + nyx.getHealthPoints(), 0x8a0b00, event);
				
					event.getChannel().sendTyping().queue(); 
					event.getChannel().sendMessage(battleMove1bP.build()).queue();
					battleMove1bP.clear();
				
					EmbedBuilder enemyMove1bP = new EmbedBuilder(); 
				
					if (player.getCharacterHealthPoints() - nyx.attack() > 0) {
						player.setCharacterHealthPoints(player.getCharacterHealthPoints() - nyx.attack());
					}
					else if (player.getCharacterHealthPoints() - nyx.attack() <= 0 ) {
						player.setCharacterHealthPoints(0);
					}
			
					Format.formatBattle(enemyMove1bP, "Battle of the Spirits ⚔️🔮: Type Your Next Move", "https://media.giphy.com/media/jnESbDbr5NdwXYC4FN/source.gif", "*You have been hit!*\n" +  "1b. Swing your Sword\n"
									+ "2b. Raise your Shield\n" + "3b. Throw a Kick\n" + "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + nyx.getHealthPoints(), 0x8a0b00, event);
			
					event.getChannel().sendTyping().queue(); 
					event.getChannel().sendMessage(enemyMove1bP.build()).queue();
					enemyMove1bP.clear();
				
				}
				
				else if (random_number == 4) {
					EmbedBuilder battleMove1bF = new EmbedBuilder(); 
					
					Format.formatBattle(battleMove1bF, "Battle of the Spirits ⚔️🔮: Your Attack! ", "https://media.giphy.com/media/fAVo69uKI6GxdFpcl4/source.gif", "*Your Sword Swing has failed!*\n" + "Your Health: "
										+ player.getCharacterHealthPoints() + "\n" + "Enemy's Health: " + nyx.getHealthPoints(), 0x8a0b00, event);
					
					event.getChannel().sendTyping().queue(); 
					event.getChannel().sendMessage(battleMove1bF.build()).queue();
					battleMove1bF.clear();
					
					EmbedBuilder enemyMove1bP = new EmbedBuilder(); 
					
					if (player.getCharacterHealthPoints() - nyx.attack() > 0) {	
						player.setCharacterHealthPoints(player.getCharacterHealthPoints() - nyx.attack()); 
					}
					else if (player.getCharacterHealthPoints() - nyx.attack() <= 0) {
						player.setCharacterHealthPoints(0);
					}
					
					Format.formatBattle(enemyMove1bP, "Battle of the Spirits ⚔️🔮: Type Your Next Move", "https://media.giphy.com/media/jnESbDbr5NdwXYC4FN/source.gif", "*You have been hit!*\n" +  "1b. Swing your Sword\n"
							+ "2b. Raise your Shield\n" + "3b. Throw a Kick\n" + "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + nyx.getHealthPoints(), 0x8a0b00, event);
				
					event.getChannel().sendTyping().queue(); 
					event.getChannel().sendMessage(enemyMove1bP.build()).queue();
					enemyMove1bP.clear();
					
				}
				
			}
		
			if (args[0].equalsIgnoreCase("2b")) {
				int min = 0; 
				int max = 2; 
				int random_number = (int)(Math.random() * (max - min + 1) + min);
				
				if (random_number >= 0 && random_number <= 1) {
				EmbedBuilder battleMove2bP = new EmbedBuilder(); 
				
				if (nyx.getHealthPoints() - player.shieldProtection() > 0) {
					nyx.setHealthPoints(nyx.getHealthPoints() - player.shieldProtection());
				}
				else if (nyx.getHealthPoints() - player.shieldProtection() <= 0 ) {
					nyx.setHealthPoints(0);
				}
				
				
				Format.formatBattle(battleMove2bP, "Battle of the Spirits ⚔️🔮: Your Move ", "https://media.giphy.com/media/SA6uu0On5CqF9Lyj4x/source.gif", "*You raised your shield and it has protected you!*\n"
									+ "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + nyx.getHealthPoints(), 0x8a0b00, event);
				
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(battleMove2bP.build()).queue();
				battleMove2bP.clear();
				
				EmbedBuilder nextMove2b = new EmbedBuilder(); 
				
				Format.formatBattle(nextMove2b, "Battle of the Spirits ⚔️🔮: Type Your Next Move ", "https://media.giphy.com/media/SA6uu0On5CqF9Lyj4x/source.gif", "1b. Swing your Sword\n" + "2b. Raise your Shield\n" + "3b. Throw a Kick\n"
									+ "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + nyx.getHealthPoints(), 0x8a0b00, event);
				
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(nextMove2b.build()).queue();
				nextMove2b.clear();
				
				
				}
				if (random_number == 2 ) {
				EmbedBuilder battleMove2bF = new EmbedBuilder(); 
					
				Format.formatBattle(battleMove2bF, "Battle of the Spirits ⚔️🔮: Your Move ", "https://media.giphy.com/media/lrc1CrWyuTkkPUeHdR/source.gif", "*You failed to raise your shield!*\n"
										+ "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + nyx.getHealthPoints(), 0x8a0b00, event);
					
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(battleMove2bF.build()).queue();
				battleMove2bF.clear();
				
				EmbedBuilder enemyMove2bP = new EmbedBuilder(); 
				
				if (player.getCharacterHealthPoints() - nyx.attack() > 0) {
					player.setCharacterHealthPoints(player.getCharacterHealthPoints() - nyx.attack());
				}
				else if (player.getCharacterHealthPoints() - nyx.attack() <= 0) {
					player.setCharacterHealthPoints(0);
				}
			
				Format.formatBattle(enemyMove2bP, "Battle of the Spirits ⚔️🔮: Type Your Next Move", "https://media.giphy.com/media/U2MDo1urRggnleRzkS/source.gif", "*You have been hit!*\n" +  "1b. Swing your Sword\n"
									+ "2b. Raise your Shield\n" + "3b. Throw a Kick\n" + "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + nyx.getHealthPoints(), 0x8a0b00, event);
			
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(enemyMove2bP.build()).queue();
				enemyMove2bP.clear();
				
				
					
				}
			}
			
			if (args[0].equalsIgnoreCase("3b")) {
				
				EmbedBuilder battleMove3bP = new EmbedBuilder(); 
				
				if (player.getCharacterHealthPoints() - nyx.biteLeg() > 0) {
					player.setCharacterHealthPoints(player.getCharacterHealthPoints() - nyx.biteLeg());
				}
				else if (player.getCharacterHealthPoints() - nyx.biteLeg() <= 0) {
					player.setCharacterHealthPoints(0);
				}
				Format.formatBattle(battleMove3bP, "Battle of the Spirits ⚔️🔮: Your Attack ", "https://media.giphy.com/media/fwDpnoPwSbf4724aWF/source.gif", "*Oh no, Nyx bit your leg and you are now dying!*\n"
									+ "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + nyx.getHealthPoints(), 0x8a0b00, event);
				
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(battleMove3bP.build()).queue();
				battleMove3bP.clear();
				
				
					}
				
				
				if (player.getCharacterHealthPoints() == 0 && !event.getAuthor().isBot() && roundB == true) {
					EmbedBuilder gameOver = new EmbedBuilder(); 
		
					Format.formatBattle(gameOver, "Battle of the Spirits ⚔️🔮: Game Over!", "https://i.imgur.com/aDn9sn8.jpg", "*You have died!*\n"
										 + "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + nyx.getHealthPoints(), 0x8a0b00, event);
				
					event.getChannel().sendTyping().queue(); 
					event.getChannel().sendMessage(gameOver.build()).queue();
					gameOver.clear();
					
					roundB = false;
				}
				
				if (nyx.getHealthPoints() == 0 && !event.getAuthor().isBot() && roundB == true) {
					EmbedBuilder nextRound = new EmbedBuilder(); 
					
					Format.formatBattle(nextRound, "Battle of the Spirits ⚔️🔮: You Defeated Nyx!", "https://i.imgur.com/lVdPezt.png", "*You have won!*\n"
										 + "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + nyx.getHealthPoints(), 0x8a0b00, event);
				
					event.getChannel().sendTyping().queue(); 
					event.getChannel().sendMessage(nextRound.build()).queue();
					nextRound.clear();
					roundB = false; 
				}
				
				
				
			}
	}
				
	


			
