package data.model.product;

import java.util.Objects;

public class InGameMoney extends Product {
    private Integer amount;
    private String currency;

    public InGameMoney(String name, Genre genre, GameCopyType gameCopyType, GameType gameType,
                       String publisher, Long id, Integer copiesAvailable, Double price,
                       Integer amount, String currency) {
        super(name, genre, gameCopyType, gameType, publisher, id, copiesAvailable, price);
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public GameType getGameType() {
        return GameType.IN_GAME_MONEY;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "InGameMoney: " + "\n" +
                "Amount: " + amount +
                "Currency: " + currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InGameMoney)) return false;
        if (!super.equals(o)) return false;
        InGameMoney that = (InGameMoney) o;
        return getAmount().equals(that.getAmount()) && getCurrency().equals(that.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAmount(), getCurrency());
    }
}
