package nl.fhict.s3.hsdm.models;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "cardType",
        discriminatorType = DiscriminatorType.STRING
)
@Table(name = "cards")
public abstract class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cardClass;
    private String name;
    private String image;
    private Integer cost;
    @Enumerated(value = EnumType.STRING)
    private Rarity rarity;
    private String set;
    private String effect;

    public Card() {
    }

    public Card(String cardClass, String name, String image, Integer cost, Rarity rarity, String set, String effect) {
        this.cardClass = cardClass;
        this.name = name;
        this.image = image;
        this.cost = cost;
        this.rarity = rarity;
        this.set = set;
        this.effect = effect;
    }

    public Card(Integer id, String cardClass, String name, String image, Integer cost, Rarity rarity, String set, String effect) {
        this.id = id;
        this.cardClass = cardClass;
        this.name = name;
        this.image = image;
        this.cost = cost;
        this.rarity = rarity;
        this.set = set;
        this.effect = effect;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardClass() {
        return cardClass;
    }

    public void setCardClass(String cardClass) {
        this.cardClass = cardClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardClass='" + cardClass + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", cost=" + cost +
                ", rarity='" + rarity + '\'' +
                ", set='" + set + '\'' +
                ", effect='" + effect + '\'' +
                '}';
    }
}
