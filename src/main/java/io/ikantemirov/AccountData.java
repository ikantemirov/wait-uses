package io.ikantemirov;

import org.aeonbits.owner.Config;

@Config.Sources("file:C:/Users/Ilia/AccountData.properties")
public interface AccountData extends Config {
    String login();
    String password();
}
