package data.model.product;

import java.util.Date;
import java.util.Objects;

public class Game extends Product {
    private Date releaseDate;

    public Game(String name, Genre genre, GameCopyType gameCopyType, GameType gameType,
                Date releaseDate, String publisher, Long id, Integer copiesAvailable, Double price) {
        super(name, genre, gameCopyType, gameType, publisher, id, copiesAvailable, price);
        this.releaseDate = releaseDate;
    }

    @Override
    public GameType getGameType() {
        return GameType.GAME;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Game:" + "\n" +
                "Release date: " + releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        if (!super.equals(o)) return false;
        Game game = (Game) o;
        return getReleaseDate().equals(game.getReleaseDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getReleaseDate());
    }
}
