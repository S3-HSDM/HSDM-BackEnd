package nl.fhict.s3.hsdm.models;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cardClass;
    private String name;
    private Integer cost;
    private String rarity;
    private String set;
    private String effect;

    public Card() {
    }

    public Card(String cardClass, String name, Integer cost, String rarity, String set, String effect) {
        this.cardClass = cardClass;
        this.name = name;
        this.cost = cost;
        this.rarity = rarity;
        this.set = set;
        this.effect = effect;
    }

    public Card(Integer id, String cardClass, String name, Integer cost, String rarity, String set, String effect) {
        this.id = id;
        this.cardClass = cardClass;
        this.name = name;
        this.cost = cost;
        this.rarity = rarity;
        this.set = set;
        this.effect = effect;
    }
}
