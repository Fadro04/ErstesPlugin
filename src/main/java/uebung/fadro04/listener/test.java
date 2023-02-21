package uebung.fadro04.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.*;

public class test {
    public static void main(String[] args) throws SQLException {


        String name = "Fadro04";
        String datei = "Claiming.db";
        String url = "jdbc:sqlite:" + datei;

        try {
            Connection conn = DriverManager.getConnection(url);
            String sql = "Select player_id from Player";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            if (resultSet.getString(2) == null) {
                sql = "Insert into Player player_name" +
                        "Values (" + name + ")";
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }

    }
}
