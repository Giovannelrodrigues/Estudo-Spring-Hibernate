package br.com.giovanneestudocontmatic.estudocontmatic.resources.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fieldName;
    private String mesage;

    public FieldMessage(){}

    public FieldMessage(String fieldName, String mesage) {
        this.fieldName = fieldName;
        this.mesage = mesage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }
}
