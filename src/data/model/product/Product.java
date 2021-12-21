package data.model.product;

import java.util.Objects;

public abstract class Product {
    private final String name;
    private final Genre genre;
    private GameCopyType gameCopyType;
    private final GameType gameType;
    private String publisher;
    private final Long id;
    private Integer copiesAvailable;
    private Double price;


    public Product(String name, Genre genre, GameCopyType gameCopyType, GameType gameType,
                   String publisher, Long id, Integer copiesAvailable, Double price) {
        this.name = name;
        this.genre = genre;
        this.gameCopyType = gameCopyType;
        this.gameType = gameType;
        this.publisher = publisher;
        this.id = id;
        this.copiesAvailable = copiesAvailable;
        this.price = price;
    }

    public String getName() {
        return name;
    }


    public Genre getGenre() {
        return genre;
    }


    public GameCopyType getGameCopyType() {
        return gameCopyType;
    }

    public void setGameCopyType(GameCopyType gameCopyType) {
        this.gameCopyType = gameCopyType;
    }

    public GameType getGameType() {
        return gameType;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(Integer copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product: " +
                "Name: " + name + "\n" +
                "Genre: " + genre + "\n" +
                "Game copy type: " + gameCopyType + "\n" +
                "Game type: " + gameType + "\n" +
                "Publisher: " + publisher + "\n" +
                "Copies available: " + copiesAvailable + "\n" +
                "Price: " + price;
    }

    public String gameInfo() {
        String gameInfo = "Product: " +
                "Name: %s" + "\n" +
                "Genre: %s" + "\n" +
                "Game copy type: %s" + "\n" +
                "Game type: %s" + "\n" +
                "Publisher: %s" + "\n" +
                "Price: %f";

        return String.format(gameInfo, name, genre, gameCopyType, gameType, publisher, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getName().equals(product.getName()) && getGameCopyType() == product.getGameCopyType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getGameCopyType());
    }

    public Long getId() {
        return id;
    }
}
