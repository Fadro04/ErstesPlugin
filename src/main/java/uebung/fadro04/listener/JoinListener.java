package uebung.fadro04.listener;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.*;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) throws SQLException {
        joinMessage(event);
        registerPlayer(event);

    }

    public void registerPlayer(PlayerJoinEvent event) throws SQLException {
        Player p = event.getPlayer();
        String datei = "Claiming.db";
        String url = "jdbc:sqlite:" + datei;
        Connection conn = DriverManager.getConnection(url);

        try {
            String sql = "Select player_id from Player";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            if (resultSet.getString(2) == null) {
                sql = "Insert into Player player_name" +
                        "Values (" + p.getName();
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            conn.close();
        }
    }

    public void joinMessage(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, 1.5f, 0.5f);
        event.setJoinMessage(ChatColor.GREEN + "+[" + event.getPlayer().getName() + "]");
    }
}
