package nl.fhict.s3.hsdm.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "minionCard")
public class MinionCard extends Card {
    private Integer attack;
    private Integer health;
    private String tribe;

    public MinionCard() {
    }

    public MinionCard(String cardClass, String name, String image, Integer cost, Rarity rarity, String set, String effect, Integer attack, Integer health, String tribe) {
        super(cardClass, name, image, cost, rarity, set, effect);
        this.attack = attack;
        this.health = health;
        this.tribe = tribe;
    }

    public MinionCard(Integer id, String cardClass, String name, String image, Integer cost, Rarity rarity, String set, String effect, Integer attack, Integer health, String tribe) {
        super(id, cardClass, name, image, cost, rarity, set, effect);
        this.attack = attack;
        this.health = health;
        this.tribe = tribe;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public String getTribe() {
        return tribe;
    }

    public void setTribe(String tribe) {
        this.tribe = tribe;
    }

    @Override
    public String toString() {
        return "MinionCard{" +
                "attack=" + attack +
                ", health=" + health +
                ", tribe='" + tribe + '\'' +
                '}';
    }
}
