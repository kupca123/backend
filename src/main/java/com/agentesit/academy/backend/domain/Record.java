package com.agentesit.academy.backend.domain;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Super Class for extends another Entity class.
 */

@MappedSuperclass
public class Record {

    /** ID of records */
    @Id
    protected Long id;
    /** Time stamp when was created the record. */
    protected LocalDateTime timeStampCreateRecord;
    /** Time stamp when was a last change of the record. */
    protected LocalDateTime timeStampLastChangeOfRecord;

    /* Getters and Setters of instance variables */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimeStampCreateRecord() {
        return timeStampCreateRecord;
    }

    public void setTimeStampCreateRecord(LocalDateTime timeStampCreateRecord) {
        this.timeStampCreateRecord = timeStampCreateRecord;
    }

    public LocalDateTime getTimeStampLastChangeOfRecord() {
        return timeStampLastChangeOfRecord;
    }

    public void setTimeStampLastChangeOfRecord(LocalDateTime timeStampLastChangeOfRecord) {
        this.timeStampLastChangeOfRecord = timeStampLastChangeOfRecord;
    }
}
