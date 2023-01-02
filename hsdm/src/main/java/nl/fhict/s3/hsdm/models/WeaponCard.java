package nl.fhict.s3.hsdm.models;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "weaponCard")
public class WeaponCard extends Card {
    private Integer attack;
    private Integer durability;

    public WeaponCard() {
    }

    public WeaponCard(String cardClass, String name, String image, Integer cost, Rarity rarity, String set, String effect, Integer attack, Integer durability) {
        super(cardClass, name, image, cost, rarity, set, effect);
        this.attack = attack;
        this.durability = durability;
    }

    public WeaponCard(Integer id, String cardClass, String name, String image, Integer cost, Rarity rarity, String set, String effect, Integer attack, Integer durability) {
        super(id, cardClass, name, image, cost, rarity, set, effect);
        this.attack = attack;
        this.durability = durability;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDurability() {
        return durability;
    }

    public void setDurability(Integer durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        return "WeaponCard{" +
                "attack=" + attack +
                ", durability=" + durability +
                '}';
    }
}
