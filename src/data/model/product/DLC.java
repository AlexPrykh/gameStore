package data.model.product;

import java.util.Date;
import java.util.Objects;

public class DLC extends Product {
    private Date releaseDate;

    public DLC(String name, Genre genre, GameCopyType gameCopyType, GameType gameType,
               Date releaseDate, String publisher, Integer copiesAvailable, Double price) {
        super(name, genre, gameCopyType, gameType, publisher, copiesAvailable, price);
        this.releaseDate = releaseDate;
    }

    @Override
    public GameType getGameType() {
        return GameType.DLC;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "DLC:" + "\n" +
                "Release date: " + releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DLC)) return false;
        if (!super.equals(o)) return false;
        DLC dlc = (DLC) o;
        return getReleaseDate().equals(dlc.getReleaseDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getReleaseDate());
    }
}
