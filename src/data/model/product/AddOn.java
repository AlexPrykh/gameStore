package data.model.product;

import java.util.Date;
import java.util.Objects;

public class AddOn extends Product {
    private AddOnType type;

    public AddOn(String name, Date releaseDate, String publisher, Double price, AddOnType type) {
        super(name, releaseDate, publisher, price);
        this.type = type;
    }

    @Override
    public GameType getGameType() {
        return GameType.ADD_ON;
    }

    public AddOnType getType() {
        return type;
    }

    public void setType(AddOnType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AddOn:" + "\n" +
                "Type: " + type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddOn)) return false;
        if (!super.equals(o)) return false;
        AddOn addOn = (AddOn) o;
        return getType() == addOn.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getType());
    }
}