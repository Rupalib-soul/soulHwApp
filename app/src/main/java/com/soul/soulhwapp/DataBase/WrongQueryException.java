package com.soul.soulhwapp.DataBase;


/**
 * Custom Exception that throws a exception when Query itself is wrong or incorrect
 *
 * @throws Exception  threw when query statement itself is wrong
 */
public class WrongQueryException extends Exception {
    WrongQueryException(String s) {
        super(s);
    }
}
