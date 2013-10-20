insert into client 
values (0000000010,'Centennial College','root','admin','Centennial@mycentennial.ca','941 Progress Campus', 'College','centlogo-1.JPEG','416-723-5501','416-723-5523','416-456-2637','Ann Buller','www.centennialcollege.ca','55757377','1','2013-10-16 14:45:16'); 

insert into campus
values (0000000011,0000000010,'Progress Campus', '940 Progress Campus', '2013-10-18 14:30:22');

insert into campus
values (0000000012,0000000010,'Morningside Campus', '939 Morningside Campus', '2013-10-19 14:45:22')

insert into campus
values (0000000013,0000000010,'Ashtonbee Campus', '938 Ashtonbee Campus', '2013-10-20 14:05:22')

insert into campus
values (0000000014,0000000010,'CCC Campus', '937 CCC Campus', '2013-10-21 13:05:22')

insert into department
values (0000000015,0000000011,'School of engineering and technology', 'Ashley Giles', 416-564-3756,'Enginnering Department','2013-10-20 14:04:22')

insert into department
values (0000000016,0000000011,'School of Business', 'Matt Giles', 416-464-3756,'Business Department','2013-10-20 14:00:22')

insert into department
values (0000000017,0000000011,'School of Continuing Education', 'Jeff Giles', 416-364-3756,'Continuing Education Department','2013-10-20 14:04:15')

insert into department
values (0000000018,0000000012,'School of Community and Health Studies', 'Michael Giles', 416-261-3756,'Community and Health Department','2013-10-20 13:04:22')

insert into department
values (0000000019,0000000012,'School of Communication & Media', 'Ashley Slater', 416-319-3756,'Media Department','2013-10-20 12:04:22')

insert into department
values (0000000020,0000000012,'School of Advancement', 'Mitchel Slater', 416-523-3756,'Advancement Department','2013-10-20 12:08:22')

insert into department
values (0000000021,0000000013,'School of Hospitality', 'Clinton Slater', 416-377-3756,'Hospitality Department','2013-10-20 12:03:22')

insert into department
values (0000000022,0000000013,'School of ChildCare', 'Arjun Slater',416-379-3756,'Childcare Department','2013-10-20 12:03:25')

insert into department
values (0000000023,0000000013,'School of Transportation', 'Mike Slater',416-341-3756,'Transportation Department','2013-10-23 12:03:25')

insert into department
values (0000000024,0000000014,'School of Aviation', 'Randy Slater',416-561-3756,'Aviation Department','2013-10-22 12:03:25')

insert into department
values (0000000025,0000000014,'Applied Research and Innovation Center', 'Amy Slater',416-591-3756,'Research Department','2013-10-22 12:03:45')

insert into department
values (0000000026,0000000014,'School of Environment Studies', 'Josh Slater',416-561-4556,'Environment Department','2013-10-22 12:02:25')
insert into officialuser
values(50,15,1,'Michael','ml@ccollge.com','admin1','2013/05/21 12:23:34','2013/05/22 12:23:34')

insert into officialuser
values(51,15,1,'Mitchel','m2@ccollge.com','admin2','2013/05/22 12:24:34','2013/05/22 12:25:34')

insert into officialuser
values(52,16,2,'Clara','m3@ccollge.com','admin3','2013/05/22 12:23:34','2013/05/22 12:23:34')

insert into officialuser
values(53,17,2,'Lara','m4@ccollge.com','admin4','2013/05/21 12:23:34','2013/05/22 12:23:34')

insert into officialuser
values(54,18,1,'Amir','m5@ccollge.com','admin5','2013/05/21 12:23:34','2013/05/22 12:23:34')

insert into officialuser
values(55,19,2,'Sandy','m6@ccollge.com','admin6','2013/05/21 12:23:34','2013/05/22 12:23:34')

insert into officialuser
values(56,20,1,'Michael','m7@ccollge.com','admin7','2013/05/21 12:23:34','2013/05/22 12:23:34')

insert into officialuser
values(57,21,2,'Priya','m8@ccollge.com','admin8','2013/05/21 12:23:34','2013/05/22 12:23:34')

insert into officialuser
values(58,22,1,'Crystal','m9@ccollge.com','admin9','2013/05/21 12:23:34','2013/05/22 12:23:34')

insert into officialuser
values(59,23,2,'Sophia','m10@ccollge.com','admin10','2013/05/21 12:23:34','2013/05/22 12:23:34')

insert into officialuser
values(60,24,1,'Sophie','m11@ccollge.com','admin11','2013/05/21 12:23:34','2013/05/22 12:23:34')

insert into officialuser
values(61,25,1,'Michael','m12@ccollge.com','admin12','2013/05/21 12:23:34','2013/05/22 12:23:34')

insert into officialuser
values(62,26,2,'Michael','m13@ccollge.com','admin13','2013/05/21 12:23:34','2013/05/22 12:23:34')



insert into roles
values (1,10,'Councillor','Access student records','Guidance to students')

insert into roles
values (2,10,'Asst Councillor','Access student records','Guidance to students')

insert into generaluser
values (100,10,'dkaith','cc1','Kaith','Devon','dkaith@ccollege.com','1985/12/14 11:23:45','45 rudington dr','female')

insert into generaluser
values (101,10,'dkemar','cc2','Kemar','Devon','dkaith1@ccollege.com','1985/12/12 11:23:45','45 rudington dr','female')

insert into announcement
values (329,56,'Department closed','Department will be closed today','2013/10/23 10:23:44') 

insert into announcement
values (330,57,'Department closed','Department will be closed today','2013/10/23 10:23:44') 

insert into notification
values (352,57,100,43242,'Meeting Postponed','Meeting has been postponed to tomorrow',1,'2013/10/23 10:23:44') 

insert into notification
values (353,58,101,43247,'Meeting Postponed','Meeting has been postponed to tomorrow',1,'2013/10/23 10:23:44') 

insert into departmenttimeslot
values (140,15,150,'1100000',30)

insert into departmenttimeslot
values (141,16,151,'1110000',25)

insert into timeslot
values (150,'08:00:00','12:00:00','Slot timings')

insert into timeslot
values (151,'08:00:00','12:00:00','Slot timings')

insert into category
values (500, 56,'General')

insert into category
values (501, 56,'Specific')

insert into category
values (503, 57,'Specific')

insert into faq
values (200, 500, 56,'How to register', 'Navigate to website and click register','2013/11/11 12:34:23')

insert into faq
values (201, 500, 57,'what is comp 302', 'It is a business course','2013/11/11 12:34:23')

insert into appointment
values (395,140,100,56,'Course Inquiry','10:00:00','10:20:00', 'Y','Explained course details','2013/11/11 12:23:45')

insert into appointment
values (396,141,101,57,'Course Inquiry','10:00:00','10:20:00', 'Y','Explained course details','2013/11/11 12:23:45')

