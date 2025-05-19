package com.ponsun.aml.infrastructure.exceptions;

public class EQAS_AML_AppicationException extends AbstractPlatformException{

    public EQAS_AML_AppicationException(String message){
        super("error.msg.generic",message);
    }
}
