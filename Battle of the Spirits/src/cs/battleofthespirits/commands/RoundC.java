package cs.battleofthespirits.commands;

import net.dv8tion.jda.api.EmbedBuilder; 


import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Random;

import cs.battleofthespirits.entities.Noctis;
import cs.battleofthespirits.entities.Player;
import cs.battleofthespirits.ui.Format;

/**
 * This class controls the third round of combat.
 * @authors Danny T., Esha S., Ahmad G.
 *
 */

public class RoundC extends ListenerAdapter {
	
	Player player = new Player(10, 30, 125); //Use same player object from previous classes
	
	Noctis noctis = new Noctis(30, 50, 125);
	
	boolean roundC = true;
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase("round3")) {
			EmbedBuilder round3a = new EmbedBuilder(); 
			Format.formatBattle(round3a, "Battle of the Spirits ⚔️🔮: Round 3", "https://i.imgur.com/bjUeIAc.png", "The Final Round Begins\n"
					 + "Your Health: " + player.getCharacterHealthPoints() + "\n" + "Enemy's Health: " + noctis.getHealthPoints(), 0x8a0b00, event);

			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(round3a.build()).queue();
			round3a.clear();
			
			EmbedBuilder round3b = new EmbedBuilder(); 
			Format.formatBattle(round3b, "Battle of the Spirits ⚔️🔮: Round 3", "https://i.imgur.com/okNKQ1j.png", "The Final Round Begins\n"
					 + "Your Health: " + player.getCharacterHealthPoints() + "\n" + "Enemy's Health: " + noctis.getHealthPoints(), 0x8a0b00, event);

			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(round3b.build()).queue();
			round3b.clear();
			
			EmbedBuilder round3c = new EmbedBuilder(); 
			Format.formatBattle(round3c, "Battle of the Spirits ⚔️🔮: Type Your Move", "https://media.giphy.com/media/YRKrlmlc9SC2qC4V2Y/source.gif", "1c. Swing your Sword\n" + "2c. Raise your Shield\n"
								+ "3c. Throw a Punch\n" + "Your Health: " + player.getCharacterHealthPoints() + "\n" + "Enemy's Health: " + noctis.getHealthPoints(), 0x8a0b00, event);
			
			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(round3c.build()).queue();
			round3c.clear();

		}
			
			if (args[0].equalsIgnoreCase("1c")) {
				Random r = new Random();
				int min = 0; 
				int max = 5; 
				int random_number = r.nextInt(max - min + 1) + min;
				
				if (random_number >= 0 && random_number <= 4) {
				EmbedBuilder battleMove1cP = new EmbedBuilder(); 

				if (noctis.getHealthPoints() - player.swordSwingAttack() > 0) {
					noctis.setHealthPoints(noctis.getHealthPoints() - player.swordSwingAttack());
				} 
				else if (noctis.getHealthPoints() - player.swordSwingAttack() <= 0) { 
					noctis.setHealthPoints(0);
				}
				
				Format.formatBattle(battleMove1cP, "Battle of the Spirits ⚔️🔮: Your Attack ", "https://media.giphy.com/media/kZtxjQYWLCLlI6wdFR/source.gif", "*Your Sword Swing was successful!*\n"
									+ "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + noctis.getHealthPoints(), 0x8a0b00, event);
				
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(battleMove1cP.build()).queue();
				battleMove1cP.clear();
				
				EmbedBuilder enemyMove1cP = new EmbedBuilder(); 
				
				if (player.getCharacterHealthPoints() - noctis.attack() > 0) {	
					player.setCharacterHealthPoints(player.getCharacterHealthPoints() - noctis.attack()); 
				} 
				else if (player.getCharacterHealthPoints() - noctis.attack() <= 0) {
					player.setCharacterHealthPoints(0);
				}
			
				Format.formatBattle(enemyMove1cP, "Battle of the Spirits ⚔️🔮: Type Your Next Move", "https://media.giphy.com/media/iGFvAqokdmbKd13oja/source.gif", "*You have been hit!*\n" +  "1c. Swing your Sword\n"
									+ "2c. Raise your Shield\n" + "3c. Throw a Punch\n" + "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + noctis.getHealthPoints(), 0x8a0b00, event);
			
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(enemyMove1cP.build()).queue();
				enemyMove1cP.clear();
				
				}
				
				else if (random_number == 5) {
					EmbedBuilder battleMove1cF = new EmbedBuilder(); 
					
					Format.formatBattle(battleMove1cF, "Battle of the Spirits ⚔️🔮: Your Attack! ", "https://media.giphy.com/media/lkcKYcQGuEjiOhYDBS/source.gif", "*Your Sword Swing has failed!*\n" + "Your Health: "
										+ player.getCharacterHealthPoints() + "\n" + "Enemy's Health: " + noctis.getHealthPoints(), 0x8a0b00, event);
					
					event.getChannel().sendTyping().queue(); 
					event.getChannel().sendMessage(battleMove1cF.build()).queue();
					battleMove1cF.clear();
					
					EmbedBuilder enemyMove1cP = new EmbedBuilder(); 
					
					if (player.getCharacterHealthPoints() - noctis.attack() > 0) {	
						player.setCharacterHealthPoints(player.getCharacterHealthPoints() - noctis.attack()); 
					} 
					else if (player.getCharacterHealthPoints() - noctis.attack() <= 0) {
						player.setCharacterHealthPoints(0);
					}
					
					Format.formatBattle(enemyMove1cP, "Battle of the Spirits ⚔️🔮: Type Your Next Move", "https://media.giphy.com/media/iGFvAqokdmbKd13oja/source.gif", "*You have been hit!*\n" +  "1c. Swing your Sword\n"
							+ "2c. Raise your Shield\n" + "3c. Throw a Punch\n" + "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + noctis.getHealthPoints(), 0x8a0b00, event);
				
					event.getChannel().sendTyping().queue(); 
					event.getChannel().sendMessage(enemyMove1cP.build()).queue();
					enemyMove1cP.clear();
					
				}
					
						
					}
		
			if (args[0].equalsIgnoreCase("2c")) {
				int min = 0; 
				int max = 2; 
				int random_number = (int)(Math.random() * (max - min + 1) + min);
				
				if (random_number >= 0 && random_number <= 1) {
				EmbedBuilder battleMove2cP = new EmbedBuilder(); 
				
				Format.formatBattle(battleMove2cP, "Battle of the Spirits ⚔️🔮: Your Move ", "https://media.giphy.com/media/ZaERaq8FwuE4ufUsgs/source.gif", "*You raised your shield and it has protected you!*\n"
									+ "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + noctis.getHealthPoints(), 0x8a0b00, event);
				
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(battleMove2cP.build()).queue();
				battleMove2cP.clear();
				
				EmbedBuilder nextMove2c = new EmbedBuilder(); 
				
				Format.formatBattle(nextMove2c, "Battle of the Spirits ⚔️🔮: Type Your Next Move ", "https://media.giphy.com/media/frT8982EmmCbLZPke0/source.gif", "1c. Swing your Sword\n" + "2c. Raise your Shield\n" + "3c. Throw a Punch\n"
									+ "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + noctis.getHealthPoints(), 0x8a0b00, event);
				
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(nextMove2c.build()).queue();
				nextMove2c.clear();
				
				
				}
				if (random_number == 2) {
				EmbedBuilder battleMove2cS = new EmbedBuilder(); 
				
				if (noctis.getHealthPoints() - player.shieldReflection() > 0) {
					noctis.setHealthPoints(noctis.getHealthPoints() - player.shieldReflection());
				}
				else if (noctis.getHealthPoints() - player.shieldReflection() <= 0) {
					noctis.setHealthPoints(0);
				}
				
				Format.formatBattle(battleMove2cS, "Battle of the Spirits ⚔️🔮: Your Move ", "https://media.giphy.com/media/MBCkaYcU90tcxx3L3a/source.gif", "*You raised your shield and it has reflected the lightening!*\n"
						+ "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + noctis.getHealthPoints(), 0x8a0b00, event);
					
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(battleMove2cS.build()).queue();
				battleMove2cS.clear();
				
						
				}
			}
			
			if (args[0].equalsIgnoreCase("3c")) {
				
				Random r = new Random();
				int min = 0; 
				int max = 4; 
				int random_number = r.nextInt(max - min + 1) + min;
				
				if (random_number >= 0 && random_number <= 2) {
				EmbedBuilder battleMove3cP = new EmbedBuilder(); 

				if (noctis.getHealthPoints() - player.punchAttack() > 0) {
					noctis.setHealthPoints(noctis.getHealthPoints() - player.punchAttack());
				}
				else if (noctis.getHealthPoints() - player.punchAttack() <= 0) {
					noctis.setHealthPoints(0);
				}
				Format.formatBattle(battleMove3cP, "Battle of the Spirits ⚔️🔮: Your Attack ", "https://media.giphy.com/media/mC1cOCER450yag24gV/source.gif", "*Your punch was successful!*\n"
									+ "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + noctis.getHealthPoints(), 0x8a0b00, event);
				
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(battleMove3cP.build()).queue();
				battleMove3cP.clear();
				
				EmbedBuilder enemyMove3cP = new EmbedBuilder(); 
				
				if (noctis.getHealthPoints() - player.punchAttack() > 0) {
					player.setCharacterHealthPoints(player.getCharacterHealthPoints() - noctis.attack());
				}
				else if (noctis.getHealthPoints() - player.getCharacterHealthPoints() <= 0) {
					player.setCharacterHealthPoints(0);
				}
				
				Format.formatBattle(enemyMove3cP, "Battle of the Spirits ⚔️🔮: Type Your Next Move", "https://media.giphy.com/media/iGFvAqokdmbKd13oja/source.gif", "*You have been hit!*\n" +  "1c. Swing your Sword\n"
									+ "2c. Raise your Shield\n" + "3c. Throw a Punch\n" + "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + noctis.getHealthPoints(), 0x8a0b00, event);
			
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(enemyMove3cP.build()).queue();
				enemyMove3cP.clear();
				
				}
				
				else if (random_number >= 3 && random_number <= 4) {
					EmbedBuilder battleMove1cF = new EmbedBuilder(); 
					
					Format.formatBattle(battleMove1cF, "Battle of the Spirits ⚔️🔮: Your Attack! ", "https://media.giphy.com/media/lkcKYcQGuEjiOhYDBS/source.gif", "*You missed your punch!*\n" + "Your Health: "
										+ player.getCharacterHealthPoints() + "\n" + "Enemy's Health: " + noctis.getHealthPoints(), 0x8a0b00, event);
					
					event.getChannel().sendTyping().queue(); 
					event.getChannel().sendMessage(battleMove1cF.build()).queue();
					battleMove1cF.clear();
					
					EmbedBuilder enemyMove3cP = new EmbedBuilder(); 
					
					if (player.getCharacterHealthPoints() - noctis.attack() > 0) {
						player.setCharacterHealthPoints(player.getCharacterHealthPoints() - noctis.attack()); 
					}
					else if (player.getCharacterHealthPoints() - noctis.attack() <= 0) {
						player.setCharacterHealthPoints(0);
					}
					
					Format.formatBattle(enemyMove3cP, "Battle of the Spirits ⚔️🔮: Type Your Next Move! ", "https://media.giphy.com/media/iGFvAqokdmbKd13oja/source.gif", "*You have been hit!*\n" +  "1c. Swing your Sword\n"
										+ "2c. Raise your Shield\n" + "3c. Throw a Left Hook\n" + "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + noctis.getHealthPoints(), 0x8a0b00, event);
				
					event.getChannel().sendTyping().queue(); 
					event.getChannel().sendMessage(enemyMove3cP.build()).queue();
					enemyMove3cP.clear();
				}
				
			}
			if (player.getCharacterHealthPoints() == 0 && !event.getAuthor().isBot() && roundC == true) {
				EmbedBuilder gameOver = new EmbedBuilder(); 
	
				Format.formatBattle(gameOver, "Battle of the Spirits ⚔️🔮: Game Over!", "https://i.imgur.com/MwBDG85.png", "*You have died!*\n"
									 + "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + noctis.getHealthPoints(), 0x8a0b00, event);
			
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(gameOver.build()).queue();
				gameOver.clear();
				
				roundC = false; 
			}
			
			if (noctis.getHealthPoints() == 0 && !event.getAuthor().isBot() && roundC == true) {
				EmbedBuilder youWon = new EmbedBuilder(); 
				
				Format.formatBattle(youWon, "Battle of the Spirits ⚔️🔮: You Won!", "https://i.imgur.com/IcUEzVo.png", "*You have defeated the evil spirit, Noctis!*\n"
									 + "Your Health: " + player.getCharacterHealthPoints() + "\n" +  "Enemy's Health: " + noctis.getHealthPoints(), 0x8a0b00, event);
			
				event.getChannel().sendTyping().queue(); 
				event.getChannel().sendMessage(youWon.build()).queue();
				youWon.clear();
				
				roundC = false; 
			}
	}
}
				
	


			
