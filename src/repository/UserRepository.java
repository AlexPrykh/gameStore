package repository;

import data.model.user.Role;
import data.model.user.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private static final int USER_ROW_WORDS_COUNT = 7;
    private List<User> users = new ArrayList<>();
    private String fileName;

    public UserRepository(String fileName) {
        this.fileName = fileName;
    }

    public void loadUsers() throws IOException {
        try (Reader reader = new BufferedReader(new FileReader(fileName))) {
            File file = new File(fileName);

            if (file.exists() && file.isDirectory()) {
                throw new FileNotFoundException(fileName);
            }

            char[] theChars = new char[1024];
            int charsRead = reader.read(theChars, 0, theChars.length);
            StringBuilder fileContent = new StringBuilder();
            while (charsRead != -1) {
                fileContent.append(new String(theChars, 0, charsRead));
                charsRead = reader.read(theChars, 0, theChars.length);
            }

            String content = fileContent.toString();
            if (content.isEmpty()) {
                System.err.println("You are uploading an empty file!");
            }
            String[] rawUsers = content.split("\n");
            List<User> parsedUsers = new ArrayList<>();

            for (String rawUser : rawUsers) {
                if (rawUser.isBlank()) {
                    System.err.println("Error! Invalid file format!");
                    continue;
                }
                String[] userValues = rawUser.split("\n");

                if (userValues.length != USER_ROW_WORDS_COUNT) {
                    System.err.println("Error! Invalid file format!");
                    continue;
                }

                String realName = userValues[0];
                Long id = Long.valueOf(userValues[1]);
                Role role = Role.valueOf(userValues[2]);
                String password = userValues[3];
                String email = userValues[4];
                Double balance = Double.valueOf(userValues[5]);
                Double bonusBalance = Double.valueOf(userValues[6]);

                parsedUsers.add(new User(realName, id, role, password, email, balance, bonusBalance) {
                });
            }

            this.users = parsedUsers;
            System.out.println("User loaded from file: " + fileName);
        }
    }

    public void saveToFile() {
        StringBuilder content = new StringBuilder();
        for (User user : users) {
            String userJson = user.toString();
            content.append(userJson).append("\n");
        }
        try (Writer writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content.toString());
        } catch (IOException e) {
            System.err.println("Failed to writes contents! Exception has been caught: " +
                    e.getMessage());
        }
    }

    Optional<User> findId(Long id) {
        for (User user : users) {
            if (id.equals(user.getId())) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

}
