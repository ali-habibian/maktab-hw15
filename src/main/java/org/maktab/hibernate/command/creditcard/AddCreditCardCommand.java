package org.maktab.hibernate.command.creditcard;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Account;
import org.maktab.hibernate.entity.CreditCard;
import org.maktab.hibernate.service.CreditCardService;

import javax.persistence.NoResultException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

public class AddCreditCardCommand implements BaseCommand<Account> {
    private CreditCardService cardService;

    public AddCreditCardCommand(CreditCardService cardService) {
        this.cardService = cardService;
    }


    public CreditCard execute(Account account) {
        CreditCard creditCard = new CreditCard();

        // Set CardNumber
        creditCard.setCardNumber();
        CreditCard byCardNumber;
        try {
            byCardNumber = cardService.findByCardNumber(creditCard.getCardNumber());
            while (byCardNumber != null) {
                creditCard.setCardNumber();
                byCardNumber = cardService.findByCardNumber(creditCard.getCardNumber());
            }
        }catch (NoResultException e){
            System.out.println(e.getMessage());
        }

        creditCard.setCvv2(generateRndCvv2());
        creditCard.setPassword(String.valueOf(generateRndPass()));
        creditCard.setExpireDate(generateRndExpDate());

        cardService.saveOrUpdate(creditCard);
        return cardService.findByCardNumber(creditCard.getCardNumber());
    }

    private Integer generateRndCvv2() {
        Random random = new Random();
        return random.nextInt(100, 999);
    }

    private Integer generateRndPass() {
        Random random = new Random();
        return random.nextInt(1000, 9999);
    }

    private static Date generateRndExpDate() {
        Random random = new Random();
        // creating a Calendar object
        Calendar c1 = Calendar.getInstance();

        // set Month starts with 0 i.e. ( 0 - Jan)
        c1.set(Calendar.MONTH, random.nextInt(0, 11));

        // set Date
        c1.set(Calendar.DATE, random.nextInt(0, 29));

        // set Year
        c1.set(Calendar.YEAR, random.nextInt(2022, 2025));

        // creating a sql date object with specified time.
        return new java.sql.Date(c1.getTime().getTime());
    }
}
