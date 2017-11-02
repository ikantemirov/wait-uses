package io.ikantemirov;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:AccountData.properties")
public interface AccountData extends Config {
    String login();
    String password();
}
