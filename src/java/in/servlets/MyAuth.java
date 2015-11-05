/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.servlets;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author Darshan
 */
class MyAuth extends Authenticator
{
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("darshan.project123@gmail.com", "pass123word");
    }   
}
