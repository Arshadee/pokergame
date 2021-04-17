package io.poker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Standard Spring Configuration class used for scanning all packages required
 * @author arshadmayet
 *
 */
@Configuration
@ComponentScan(basePackages = "io.poker.controllers,io.poker.services,io.poker.game.fivecards.functions,io.poker.game.fivecards.rankrules,io.poker.core,io.poker.myshuffle")
public class AppConfig {

}
