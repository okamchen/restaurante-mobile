package br.com.restaurantemobile.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by kone on 10/13/17.
 */

public final class CurrencyUtil {

    public static String getCurrency(String numero){

        if(numero == null){
            return "";
        }

        return NumberFormat.getCurrencyInstance().format(Float.parseFloat(numero));
    }
}
