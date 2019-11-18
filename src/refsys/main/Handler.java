package refsys.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Handler implements Listener, CommandExecutor{

	private RefSys plugin;
	
	public Handler(RefSys plugin) { this.plugin = plugin; }
	
	SettingsManager settings = SettingsManager.getInstance();	
	
/*
 * 1 код = 15 использований
 */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = Bukkit.getPlayer(sender.getName());
		
		if ((cmd.getName().equalsIgnoreCase("code")) && ((args.length == 0))){
			
			p.sendMessage(ChatColor.RED + " Daily" + ChatColor.GOLD + "Rest" + " " + ChatColor.WHITE + "Помощь по плагину: Реферальная система");
			p.sendMessage(" ----------------------------------------------------------------------");
			p.sendMessage(ChatColor.WHITE + " Создай реферальный код и приглашай своих друзей. ");
			p.sendMessage(ChatColor.WHITE + " Каждый приглашенный друг получает 3 ключа от кейса с" + ChatColor.GRAY + " Редкими титулами");
			p.sendMessage(ChatColor.WHITE + " За каждого приглашенного друга ты получаешь 1 ключ от кейса с" + ChatColor.LIGHT_PURPLE + " Хайповыми титулами");
			p.sendMessage(ChatColor.GOLD + " Создать свой реф. код (макс. 1 раз)" + ChatColor.WHITE + " /code new");
			p.sendMessage(ChatColor.GOLD + " Стать рефералом (первые 5 минут игры)" + ChatColor.WHITE + " /code accept [никнейм]");
			p.sendMessage(" ----------------------------------------------------------------------");
			
			return true;		

		}
		
		if ((cmd.getName().equalsIgnoreCase("code")) && ((args.length >= 1) && (args[0].compareToIgnoreCase("new") != 0) && (args[0].compareToIgnoreCase("accept") != 0))){
			
			p.sendMessage(ChatColor.RED + " Daily" + ChatColor.GOLD + "Rest" + " " + ChatColor.WHITE + "Помощь по плагину: Реферальная система");
			p.sendMessage(" ----------------------------------------------------------------------");
			p.sendMessage(ChatColor.WHITE + " Создай реферальный код и приглашай своих друзей. ");
			p.sendMessage(ChatColor.WHITE + " Каждый приглашенный друг получает 3 ключа от кейса с" + ChatColor.GRAY + " Редкими титулами");
			p.sendMessage(ChatColor.WHITE + " За каждого приглашенного друга ты получаешь 1 ключ от кейса с" + ChatColor.LIGHT_PURPLE + " Хайповыми титулами");
			p.sendMessage(ChatColor.GOLD + " Создать свой реф. код (макс. 1 раз)" + ChatColor.WHITE + " /code new");
			p.sendMessage(ChatColor.GOLD + " Стать рефералом (первые 5 минут игры)" + ChatColor.WHITE + " /code accept [никнейм]");
			p.sendMessage(" ----------------------------------------------------------------------");
			
			return true;		
			
		}		
		
		if ((cmd.getName().equalsIgnoreCase("code")) && (args[0].compareToIgnoreCase("new") == 0) && (args.length >= 1)){
			
			if (!settings.getData().contains(p.getName())) {
							
				p.sendMessage(ChatColor.GOLD + "[Реф. система] " + ChatColor.WHITE + "Ты успешно установил реферальный код: " + p.getName());

				settings.getData().set(p.getName(), 15);
				
				settings.saveData();
				
				return true;
				
			}
			
			if (settings.getData().contains(p.getName())) {

				String amount = settings.getData().getString(p.getName());
				
				p.sendMessage(ChatColor.GOLD + "[Реф. система] " + ChatColor.WHITE + "Ты уже установил реферальный код: " + p.getName());
				
				if (Integer.valueOf(amount) <= 0) {p.sendMessage(ChatColor.GOLD + "[Реф. система] " + ChatColor.WHITE + "Этот код можно больше нельзя использовать");}
				if (Integer.valueOf(amount) == 1) {p.sendMessage(ChatColor.GOLD + "[Реф. система] " + ChatColor.WHITE + "Этот код можно использовать " + amount + " раз");}
				if (Integer.valueOf(amount) == 2) {p.sendMessage(ChatColor.GOLD + "[Реф. система] " + ChatColor.WHITE + "Этот код можно использовать " + amount + " раза");}
				if (Integer.valueOf(amount) == 3) {p.sendMessage(ChatColor.GOLD + "[Реф. система] " + ChatColor.WHITE + "Этот код можно использовать " + amount + " раза");}
				if (Integer.valueOf(amount) == 4) {p.sendMessage(ChatColor.GOLD + "[Реф. система] " + ChatColor.WHITE + "Этот код можно использовать " + amount + " раза");}
				if (Integer.valueOf(amount) >= 5) {p.sendMessage(ChatColor.GOLD + "[Реф. система] " + ChatColor.WHITE + "Этот код можно использовать " + amount + " раз");}
				
				return true;
				
			}			
			
			return true;
			
		}
		
		if ((cmd.getName().equalsIgnoreCase("code")) && (args[0].compareToIgnoreCase("accept") == 0) && (args.length == 1)){
			
			p.sendMessage(ChatColor.RED + " Daily" + ChatColor.GOLD + "Rest" + " " + ChatColor.WHITE + "Помощь по плагину: Реферальная система");
			p.sendMessage(" ----------------------------------------------------------------------");
			p.sendMessage(ChatColor.WHITE + " Создай реферальный код и приглашай своих друзей. ");
			p.sendMessage(ChatColor.WHITE + " Каждый приглашенный друг получает 3 ключа от кейса с" + ChatColor.GRAY + " Редкими титулами");
			p.sendMessage(ChatColor.WHITE + " За каждого приглашенного друга ты получаешь 1 ключ от кейса с" + ChatColor.LIGHT_PURPLE + " Хайповыми титулами");
			p.sendMessage(ChatColor.GOLD + " Создать свой реф. код (макс. 1 раз)" + ChatColor.WHITE + " /code new");
			p.sendMessage(ChatColor.GOLD + " Стать рефералом (первые 5 минут игры)" + ChatColor.WHITE + " /code accept [никнейм]");
			p.sendMessage(" ----------------------------------------------------------------------");
			
			return true;	
			
		}
		
		if ((cmd.getName().equalsIgnoreCase("code")) && (args[0].compareToIgnoreCase("accept") == 0) && (args.length >= 2)){
			
			if(!settings.getData().contains(args[1])) {
				
				p.sendMessage(ChatColor.GOLD + "[Реф. система] " + ChatColor.WHITE + "Такого кода не существует");
				
				return true;
				
			}
			
			if (settings.getData().contains(args[1])) {
				
				if (args[1].compareToIgnoreCase(p.getName()) == 0) {
					
					p.sendMessage(ChatColor.GOLD + "[Реф. система] " + ChatColor.WHITE + "Нельзя вводить свой же код.");
					
					return true;
					
				}
				
				if (!settings.getData().contains("checker." + p.getName())) {
					
					int amount = settings.getData().getInt(args[1]);
					
					if (amount <= 0) {
						
						p.sendMessage(ChatColor.GOLD + "[Реф. система] " + ChatColor.WHITE + "Введен недействительный код");
						
						return true;
						
					}
					
					p.sendMessage(ChatColor.GOLD + "[Реф. система] " + ChatColor.WHITE + "Ты получил 3 ключа от кейса с" + ChatColor.GRAY + " Редкими титулами");
					
					p.sendMessage(ChatColor.GOLD + "[Реф. система] " + ChatColor.WHITE + "Ты можешь открыть их на спавне!");
					
					Player target = Bukkit.getPlayer(args[1]);
					
					if (target != null) {
						
						target.sendMessage(ChatColor.GOLD + "[Реф. система] " + ChatColor.WHITE + "Ты получил 1 ключ от кейса с" + ChatColor.LIGHT_PURPLE + " Хайповыми титулами");	
					
					}
					
					settings.getData().set(args[1], amount - 1);
					
					settings.getData().set("checker." + p.getName(), false);
					
					settings.saveData();
					
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "dc givekey " + args[1] + " Хайповые_титулы 1");
					
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "dc givekey " + p.getName() + " Редкие_титулы 3");
					
					return true;
					
				}
				
				if (settings.getData().contains("checker." + p.getName())) {
					
					p.sendMessage(ChatColor.GOLD + "[Реф. система] " + ChatColor.WHITE + "Ты уже стал чьим-то рефералом!");
					
					return true;
					
				}
				
				return true;
				
			}
			
			return true;
			
		}
		
		return false;
		
	}
	
	@EventHandler
	public void join(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();		
		
		if (!settings.getData().contains("checker." + p.getName())){
			
			p.sendMessage(ChatColor.GOLD + "[Реф. система] " + ChatColor.WHITE + "Если тебя пригласил друг, то вы можете получить донат-ключи");
			p.sendMessage(ChatColor.GOLD + "[Реф. система] " + ChatColor.WHITE + "от кейсов с титулами! " + ChatColor.GOLD + "Подробнее /code");
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
	
				@Override
				public void run() {
					
					settings.getData().set("checker." + p.getName(), false);
					
					settings.saveData();
					
				}
				
				}, 20*300);
				
		}
		
	}
	
}
