package org.example;

import org.example.exceptions.NotAuthenticateException;
import org.example.exceptions.WrongPinException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    private static Bank _instance;
    private static List<BankUser> users;

    private Map<String, Integer> attempts = new HashMap<>();


    private Bank() {
        this.users = loadFromDB();
    }

    private List<BankUser> loadFromDB() {
        return List.of(
            new BankUser("Mario", "Rossi", new Card("1234", true, 1234), 1000),
            new BankUser("Luca", "Verdi", new Card("5678", true, 5678), 2000),
            new BankUser("Gianluca", "Bianchi", new Card("9012", true, 9012), 3000)
        );
    }

    public static Bank getInstance() {
        if (_instance == null) {
            _instance = new Bank();
        }
        return _instance;
    }

    public void authenticate(String cardCode, int pin) throws NotAuthenticateException {
        checkCardCodeExisting(cardCode);
        try {
            if(isCardBloccked(cardCode)  || !isPinCorrect(cardCode, pin)){
                throw new NotAuthenticateException();
            }
        } catch (WrongPinException e) {
            //gestire l'eccezione bloccando la carta dopo 3 tentativi
            if(attempts.containsKey(cardCode)){
                attempts.put(cardCode, attempts.get(cardCode)+1);
            }else{
                attempts.put(cardCode, 1);
            }
            if(attempts.get(cardCode) >= 3){
                users.stream()
                        .filter(u -> u.getCard().equals(cardCode))
                        .findFirst()
                        .get().getCard().setActive(false);
            }
        }
    }

    private boolean isPinCorrect(String cardCode, int pin) throws WrongPinException {
        return this.users.stream()
                .filter(u -> u.getCard().getCode().equals(cardCode))
                .findFirst()
                .map(u -> u.getCard().getPin() == pin)
                .orElseThrow(() -> new WrongPinException("Carta non trovata")
        );
    }
    private boolean isCardBloccked(String cardCode){
        return !this.users.stream()
                .filter(u -> u.getCard().getCode().equals(cardCode))
                .findFirst()
                .get()
                .getCard()
                .isActive();
    }

    private void checkCardCodeExisting(String cardCode) {
        this.users.stream()
                .filter(u -> u.getCard().getCode().equals(cardCode))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Carta non trovata")
        );
    }


}
