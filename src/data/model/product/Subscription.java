package data.model.product;

import java.util.Objects;

public class Subscription extends Product {
    private Integer days;

    public Subscription(String name, Genre genre, GameCopyType gameCopyType, GameType gameType,
                        String publisher, Integer copiesAvailable, Double price,
                        Integer days) {
        super(name, genre, gameCopyType, gameType, publisher, copiesAvailable, price);
        this.days = days;
    }

    @Override
    public GameType getGameType() {
        return GameType.SUBSCRIPTION;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Subscription: " +
                "Days: " + days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscription)) return false;
        if (!super.equals(o)) return false;
        Subscription that = (Subscription) o;
        return getDays().equals(that.getDays());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDays());
    }

    public Integer subscriptionStatus(Integer subscription) {
        subscription += days;
        return subscription;
    }
}
