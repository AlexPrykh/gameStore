package data.model.user;

import java.util.Objects;

public class User {
    private String realName;
    private final Long id;
    private final Role role;
    private String password;
    private final String email;
    private Double balance;
    private Double bonusBalance;

    public User(String realName, Long id, Role role, String password, String email,
                Double balance, Double bonusBalance) {
        this.realName = realName;
        this.id = id;
        this.role = role;
        this.password = password;
        this.email = email;
        this.balance = balance;
        this.bonusBalance = bonusBalance;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Long getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBonusBalance() {
        return bonusBalance;
    }

    public void setBonusBalance(Double bonusBalance) {
        this.bonusBalance = bonusBalance;
    }

    @Override
    public String toString() {
        return "User:\n" +
                "RealName: " + realName + "\n" +
                "Id: " + id + "\n" +
                "Role: " + role + "\n" +
                "Password: " + password + "\n" +
                "Email: " + email + "\n" +
                "Balance: " + balance + "\n" +
                "Bonus balance: " + bonusBalance;
    }

    public String userInfo() {
        String user = "User: \n" +
                "RealName: %s" + "\n" +
                "Id: %d" + "\n" +
                "Role: %s" + "\n" +
                "Email: %s" + "\n";

        return String.format(user, realName, id, role, email);
    }

    public String balanceInfo() {
        String balance = "Your account balance: %f" + "\n" +
                "Your account bonus balance: %f";
        return String.format(balance, this.balance, this.bonusBalance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }
}
