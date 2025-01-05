package com.maxima.rest_security.config.security.user_details;

import com.maxima.rest_security.model.Account;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

//UserDetails - что есть наш пользователь?
@Getter
public class AccountUserDetails implements UserDetails {

    private final Account account;

    public AccountUserDetails(Account account) {
        this.account = account;
    }

    //Какие права есть у нашего пользователя?
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(account.getRole().name()));
    }

    //Какой пароль у нашего пользователя?
    @Override
    public String getPassword() {
        return account.getPassword();
    }

    //Какой username у нашего пользователя?
    @Override
    public String getUsername() {
        return account.getEmail();
    }

    //Флаг, просрочен ли аккаунт у нашего пользователя?
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //Флаг, заблокирован ли аккаунт у нашего пользователя?
    @Override
    public boolean isAccountNonLocked() {
        return !account.getState().equals(Account.State.BANNED);
    }

    //Не просрочены ли креды (т.е. логин и пароль) у нашего пользователя?
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //Активен ли наш аккаунт?
    @Override
    public boolean isEnabled() {
        return account.getState().equals(Account.State.CONFIRMED);
    }
}
