package nl.fhict.s3.hsdm.configs;

import nl.fhict.s3.hsdm.models.*;
import nl.fhict.s3.hsdm.repositories.*;
import nl.fhict.s3.hsdm.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoFillDB {

    private final CardService cardService;

    @Autowired
    public AutoFillDB(CardService cardService) {
        this.cardService = cardService;
    }

    @Bean
    CommandLineRunner commandLineRunner(ISpellCardRepository spellCardRepository, IHeroCardRepository heroCardRepository, IWeaponCardRepository weaponCardRepository, IMinionCardRepository minionCardRepository) {
        return args -> {
            Card heroCard = new HeroCard(1,"Mage","Frost Lich Jaina", "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/3bd2b995e589ce8af831196568ab30c5bc8751917971c8e263fc4050ecc74cfd.png",9,Rarity.Legendary,"Knights of the Frozen Throne","Battlecry: summon a 3/6 Water Elemental. Your Elementals have Lifesteal this game.","Icy Touch","Deal 1 damage. If this kills a minion, summon a Water Elemental",2);
            Card minionCard = new MinionCard(2,"Mage","Water Elemental", "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/40b81e64e1d8d58736e14f4d0fe9f562690f45bf8206e0496ceaf5590ed42e66.png",4,Rarity.Free,"Legacy","Freeze any charactar damaged by this minion.",3,6,"Elemental");
            Card weaponCard = new WeaponCard(3,"Warrior","Gorehowl", "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/1a5761e5566f27742892f0f736028a786708c30bdafee61fc5aa073876dd23e6.png",7,Rarity.Epic,"Core & Legacy","Attacking a minion costs 1 Attack instead of 1 Durability.",7,1);
            Card spellCard = new SpellCard(4,"Hunter","Freezing Trap", "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/31607aa1acd6acda0f7304e3d2fe4ea6a295e3c4545aa55cbc4f10a1e4136916.png",2,Rarity.Common,"Core & Legacy","Secret: When an enemy minion attacks, return it to its owner's hand. It costs (2) more.","Frost");
            Card minionCard2 = new MinionCard(5, "Neutral", "Helmet Hermit", "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/c362ef2c3563aa93a0bef5af4618d1370f533de615c9d56675d124523b1a1221.png", 1,Rarity.Rare,"Voyage to the Sunken City","Can't Attack",4,3,"Beast");
            spellCardRepository.save(spellCard);
            heroCardRepository.save(heroCard);
            weaponCardRepository.save(weaponCard);
            minionCardRepository.save(minionCard);
            minionCardRepository.save(minionCard2);
        };
    }
}