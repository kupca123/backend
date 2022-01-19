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

    @Id
    @NotNull
    private Long id;
    private LocalDateTime timeStampCreateRecord;
    private LocalDateTime timeStampLastChangeOfRecord;

    public Record(Long id, LocalDateTime timeStampCreateRecord, LocalDateTime timeStampLastChangeOfRecord) {
        this.id = id;
        this.timeStampCreateRecord = timeStampCreateRecord;
        this.timeStampLastChangeOfRecord = timeStampLastChangeOfRecord;
    }

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
