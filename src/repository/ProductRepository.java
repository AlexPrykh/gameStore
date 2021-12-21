package repository;

import data.model.product.GameCopyType;
import data.model.product.GameType;
import data.model.product.Genre;
import data.model.product.Product;

import java.io.*;
import java.util.*;

public class ProductRepository {
    private static final int PRODUCT_ROW_WORDS_COUNT = 8;
    List<Product> products = new ArrayList<>();
    private String fileName;

    public ProductRepository(String fileName) {
        this.fileName = fileName;
    }

    public void initProducts() throws IOException {
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
            String[] rawProducts = content.split("\n");
            List<Product> parsedProduct = new ArrayList<>();

            for (String rawProduct : rawProducts) {
                if (rawProduct.isBlank()) {
                    System.err.println("Error! Invalid file format!");
                    continue;
                }
                String[] productValues = rawProduct.split("\n");

                if (productValues.length != PRODUCT_ROW_WORDS_COUNT) {
                    System.err.println("Error! Invalid file format!");
                    continue;
                }

                String name = productValues[0];
                Genre genre = Genre.valueOf(productValues[1]);
                GameCopyType gameCopyType = GameCopyType.valueOf(productValues[2]);
                GameType gameType = GameType.valueOf(productValues[3]);
                String publisher = productValues[4];
                Long id = Long.valueOf(productValues[5]);
                Integer copiesAvailable = Integer.valueOf(productValues[6]);
                Double price = Double.valueOf(productValues[7]);
                parsedProduct.add(new Product(name, genre, gameCopyType, gameType, publisher, id, copiesAvailable,
                        price) {
                });
            }

            this.products = parsedProduct;
            System.out.println("Loaded library from file: " + fileName);
        }
    }

    public void saveToFile() {
        StringBuilder content = new StringBuilder();
        for (Product product : products) {
            String productJson = product.toString();
            content.append(productJson).append("\n");
        }
        try (Writer writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content.toString());
        } catch (IOException e) {
            System.err.println("Failed to writes contents! Exception has been caught: " +
                    e.getMessage());
        }
    }

    Optional<Product> findId(Long id) {
        for (Product product : products) {
            if (id.equals(product.getId())) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public List<Product> findAll(String name, Genre genre, GameType gameType, String publisher,
                                 Date releaseDate, Double price) {
        List<Product> filteredProduct = new ArrayList<>();
        for (Product product : products) {

            if (name != null && !product.getName().toLowerCase().contains(name.toLowerCase())) {
                continue;
            }

            if (genre != null && !product.getGenre().name().contains(genre.name())) {
                continue;
            }

            if (gameType != null && !product.getGameType().name().contains(gameType.name())) {
                continue;
            }

            if (publisher != null && !product.getPublisher().toLowerCase().contains(publisher.toLowerCase())) {
                continue;
            }

            if (releaseDate != null) {
                continue;
            }

            if (price != null && !Objects.equals(product.getPrice(), price)) {
                continue;
            }
            filteredProduct.add(product);
        }
        return filteredProduct;
    }

}
