package com.ponsun.aml.banktransaction.common.converter;


import com.ponsun.aml.banktransaction.common.entity.Status;
import jakarta.persistence.AttributeConverter;

public class StatusEnumToCodeConverter implements AttributeConverter<Status, Integer> {

    @Override
    public Integer convertToDatabaseColumn(final Status status) {
        return status.getCode();
    }

    @Override
    public Status convertToEntityAttribute(final Integer code) {
        if(code != null)
        {
            return (code==1) ? Status.ACTIVE : Status.DELETE;
            //return (code.equalsIgnoreCase("A")) ? Status.ACTIVE : Status.DELETE;
        }
        return null;
    }
//
//    @Override
//    public Status convertToEntityAttribute(final int code) {
//        if(code != null)
//        {
//            return (code==1) ? Status.ACTIVE : Status.DELETE;
//            //return (code.equalsIgnoreCase("A")) ? Status.ACTIVE : Status.DELETE;
//        }
//        return 0;
//    }
}