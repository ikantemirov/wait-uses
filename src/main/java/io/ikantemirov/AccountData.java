package io.ikantemirov;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:account.properties")
public interface AccountData extends Config {
    @Key("username")
    String username();
    @Key("password")
    String password();
}
