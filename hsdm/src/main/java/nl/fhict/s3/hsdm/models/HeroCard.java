package nl.fhict.s3.hsdm.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "heroCard")
public class HeroCard extends Card {
    public String heroPower;
    public String heroPowerEffect;
    public Integer heroPowerCost;

    public HeroCard() {
    }

    public HeroCard(String cardClass, String name, String image, Integer cost, Rarity rarity, String set, String effect, String heroPower, String heroPowerEffect, Integer heroPowerCost) {
        super(cardClass, name, image, cost, rarity, set, effect);
        this.heroPower = heroPower;
        this.heroPowerEffect = heroPowerEffect;
        this.heroPowerCost = heroPowerCost;
    }

    public HeroCard(Integer id, String cardClass, String name, String image, Integer cost, Rarity rarity, String set, String effect, String heroPower, String heroPowerEffect, Integer heroPowerCost) {
        super(id, cardClass, name, image, cost, rarity, set, effect);
        this.heroPower = heroPower;
        this.heroPowerEffect = heroPowerEffect;
        this.heroPowerCost = heroPowerCost;
    }

    public String getHeroPower() {
        return heroPower;
    }

    public void setHeroPower(String heroPower) {
        this.heroPower = heroPower;
    }

    public String getHeroPowerEffect() {
        return heroPowerEffect;
    }

    public void setHeroPowerEffect(String heroPowerEffect) {
        this.heroPowerEffect = heroPowerEffect;
    }

    public Integer getHeroPowerCost() {
        return heroPowerCost;
    }

    public void setHeroPowerCost(Integer heroPowerCost) {
        this.heroPowerCost = heroPowerCost;
    }

    @Override
    public String toString() {
        return "HeroCard{" +
                "heroPower='" + heroPower + '\'' +
                "heroPowerEffect='" + heroPowerEffect + '\'' +
                "heroPowerCost='" + heroPowerCost + '\'' +
                '}';
    }
}
