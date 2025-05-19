package com.ponsun.aml.banktransaction.common.entity;

public enum Status {
    ACTIVE(1,"Active"), DELETE(0, "DELETED");

    private final int code;
    private final String label;
    Status(final int code, final String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static int getCodeByStatus(final Status status) {
        int code = Status.ACTIVE.getCode();
        switch (status) {
            case ACTIVE:
                code = Status.ACTIVE.getCode();
                break;
            case DELETE:
                code = Status.DELETE.getCode();
                break;
        }
        return code;
    }
}
