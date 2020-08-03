package io.poker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "io.poker.controllers,io.poker.services,io.poker.game.fivecards.functions,io.poker.game.fivecards.rankrules,o.poker.core")
public class AppConfig {

}
