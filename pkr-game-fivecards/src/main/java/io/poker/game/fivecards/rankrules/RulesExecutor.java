package io.poker.game.fivecards.rankrules;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import io.poker.core.AbstractRulesExecutor;
import io.poker.core.IRankRule;
import io.poker.models.Card;
import io.poker.models.Hand;

/**
 * This is class houses the functions required for the 5 cards game 
 * which is decoupled from the solution and therefore easily interchangeable
 * 
 * It has to extend AbstractRulesExecutor
 * 
 * This implementation used specific rule set for 5 card game included in this package
 * 
 * @author arshadmayet
 *
 */
@Component
public class RulesExecutor extends AbstractRulesExecutor {

	

	@Override
	public String getRuleSetPackageName() {
		return RulesExecutor.class.getPackage().getName();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(List<Card> hand1) {
		Hand hand = new Hand();
		hand.setHand(hand1);
		
		List<IRankRule> rules = (List<IRankRule>) getRuleSetObjects();
		rules = chain(rules);

		IRankRule rule = rules.get(0).check(hand1);
		
		setPlayersHandRank(hand, rule.getRankName(), rule.getRank());
		System.out.println(hand);

	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {

		System.out.println("RulesExecutor - start");

		List<Card> hand1 = new ArrayList<>();
		hand1.add(new Card("Ace", 14, "Hearts"));
		hand1.add(new Card("Ace", 14, "Spades"));
		hand1.add(new Card("Ace", 14, "Clubs"));
		hand1.add(new Card("10", 10, "Clubs"));
		hand1.add(new Card("Jack", 11, "Clubs"));

		AbstractRulesExecutor rulesExecutor = new RulesExecutor();
		System.out.println(rulesExecutor.getRuleSetPackageName());

		rulesExecutor.execute(hand1);
	}

}
