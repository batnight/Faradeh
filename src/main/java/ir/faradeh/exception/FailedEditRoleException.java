/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ir.faradeh.exception;

import ir.faradeh.utility.UtilMethod;

/**
 *
 * @author Mohammad
 */
public class FailedEditRoleException extends Exception{

    public FailedEditRoleException() {
        super(UtilMethod.getExceptionMessages("FailedEditRoleException"));
    }
    
}
