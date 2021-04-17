package io.poker.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.reflections.Reflections;

import io.poker.models.Card;
import io.poker.models.Hand;
import io.poker.models.HandRank;
/**
 * This abstract class houses the core rules functionality
 * to be extend for specific implementations with specific rulesets
 * 
 * @author arshadmayet
 *
 */
public abstract class AbstractRulesExecutor {

	public AbstractRulesExecutor() {

	}

	public abstract String getRuleSetPackageName();

	public Set<Class<? extends IRankRule>> getRuleSetClasses() {
		Reflections reflections = new Reflections(getRuleSetPackageName());
		Set<Class<? extends IRankRule>> classes = reflections.getSubTypesOf(IRankRule.class);
		return classes;
	}
	
	public List<? extends IRankRule> getRuleSetObjects() {
		Set<Class<? extends IRankRule>> classes = getRuleSetClasses();
		List<IRankRule> objects = classes.stream().map(c -> {
			try {
				return c.getDeclaredConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				return null;
			}
		}).filter(c -> c != null).sorted(Comparator.comparing(IRankRule::getRank))
				.collect(Collectors.toList());
	
		return objects;
	}
	
	public List<IRankRule> chain(List<IRankRule> rules){
		for(int i=0;i<rules.size()-1;i++) {
			rules.get(i).setNext(rules.get(i+1));
		}
		return rules;
	}

	public void execute(List<Card> hand1) {
		Hand hand = new Hand();
		hand.setHand(hand1);

		Set<Class<? extends IRankRule>> classes = getRuleSetClasses();

		for (Class<? extends IRankRule> clazz : classes) {
			Object instance = null;

			try {
				instance = clazz.getDeclaredConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException e) {// | ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
			Method checkMethod;
			try {
				checkMethod = clazz.getMethod("check", List.class);
				Method getRankMethod;
				getRankMethod = clazz.getMethod("getRank");
				Integer rank = (Integer) getRankMethod.invoke(instance);

				Method getRankName = clazz.getMethod("getRankName");

				boolean checkBoolean = (boolean) checkMethod.invoke(instance, hand1);
				String rankName = (String) getRankName.invoke(instance);

				if (checkBoolean) {
					setPlayersHandRank(hand, rankName, rank);
				}

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}

		}

		System.out.println(hand);

	}

	protected void setPlayersHandRank(Hand hand, String handRankName, Integer handRankValue) {
		HandRank handRank = hand.getHandRank();
		if ((handRank == null) || (handRank.getHandRankValue() > handRankValue)) {
			hand.setHandRank(new HandRank(handRankName, handRankValue));
		}
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

		System.out.println("RulesExecutor - end");
	}

}
