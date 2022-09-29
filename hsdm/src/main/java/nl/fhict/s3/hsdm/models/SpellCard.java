package nl.fhict.s3.hsdm.models;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "spellCard")
public class SpellCard extends Card {
    public String spellType;

    public SpellCard() {
    }

    public SpellCard(String cardClass, String name, String image, Integer cost, Rarity rarity, String set, String effect, String spellType) {
        super(cardClass, name, image, cost, rarity, set, effect);
        this.spellType = spellType;
    }

    public SpellCard(Integer id, String cardClass, String name, String image, Integer cost, Rarity rarity, String set, String effect, String spellType) {
        super(id, cardClass, name, image, cost, rarity, set, effect);
        this.spellType = spellType;
    }

    public String getSpellType() {
        return spellType;
    }

    public void setSpellType(String spellType) {
        this.spellType = spellType;
    }

    @Override
    public String toString() {
        return "SpellCard{" +
                "spellType='" + spellType + '\'' +
                '}';
    }
}
