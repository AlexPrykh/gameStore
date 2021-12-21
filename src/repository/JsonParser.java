package repository;

import data.model.order.Order;
import data.model.product.*;
import data.model.user.Role;
import data.model.user.User;
import org.json.JSONObject;

import java.util.Date;

public class JsonParser {

    public User getUser(String response) {
        JSONObject userJson = new JSONObject(response);
        String realName = userJson.getString("realName");
        Long id = userJson.getLong("id");
        Role role = userJson.getEnum(Role.class, "role");
        String password = userJson.getString("password");
        String email = userJson.getString("email");
        Double balance = userJson.getDouble("balance");
        Double bonusBalance = userJson.getDouble("bonusBalance");

        return new User(realName, id, role, password, email, balance, bonusBalance);
    }

//    public Product getProduct(String response) {
//        JSONObject productJson = new JSONObject(response);
//         String name = productJson.getString("name");
//         Genre genre = productJson.getEnum(Genre.class, "genre");
//         GameCopyType gameCopyType = productJson.getEnum(GameCopyType.class, "gameCopyType");
//         GameType gameType = productJson.getEnum(GameType.class, "gameType");
//         String publisher = productJson.getString("publisher");
//         Long id = productJson.getLong("id");
//         Integer copiesAvailable = productJson.getInt("copiesAvailable");
//         Double price = productJson.getDouble("price");
//
//         return new Product(name, genre, gameCopyType, gameType, publisher, id, copiesAvailable, price);
//    }

//    public Order getOrder(String response) {
//        JSONObject orderJson = new JSONObject(response);
//        Long id = orderJson.getLong("id");
//        Date date; // ???
//        User user; // ???
//        Product product; // ???
//        Status status = orderJson.getEnum(Status.class, "status");
//
//        return new Order(id, date, user, product, status);
//    }

}
