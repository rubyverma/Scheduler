package com.scheduler.models;
import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

        private int appointmentId;
        private int departmentTimeId;
        private int userId;
        private int officialId;
        private Date appointmentDate;
        private String purposeOfVisit;
        private Time startTime;
        private Time endTime;
        private String meetingFinished;
        private String meetingNotes;
        private Date dateCreated;
}

