package com.dtcc.ruleengine.model;

import java.util.Objects;

public class Metadata {

    String kieSessionName;
    String fileName;

    public Metadata() {
    }

    public String getKieSessionName() {
        return kieSessionName;
    }

    public void setKieSessionName(String kieSessionName) {
        this.kieSessionName = kieSessionName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Metadata metadata = (Metadata) o;
        return Objects.equals(getKieSessionName(), metadata.getKieSessionName()) &&
                Objects.equals(getFileName(), metadata.getFileName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKieSessionName(), getFileName());
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "kieSessionName='" + kieSessionName + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
