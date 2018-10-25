# TrainTicket
Java Progrm

# Must connect to Oracle HR DB and insert the below tables

-- DDL for Table TRAINS
--------------------------------------------------------
 DROP TABLE TRAINS;

 CREATE TABLE "TRAINS"
 ( "TRAIN_NO" NUMBER(5,0) PRIMARY KEY,
"TRAIN_NAME" VARCHAR2(40),
"SOURCE" VARCHAR2(20),
"DESTINATION" VARCHAR2(20),
"TICKET_PRICE" NUMBER(8,2)
 ) ;
Insert into TRAINS (TRAIN_NO,TRAIN_NAME,SOURCE,DESTINATION,TICKET_PRICE) values (1001,'Shatabdi
Express','Bangalore','Delhi',2500);
Insert into TRAINS (TRAIN_NO,TRAIN_NAME,SOURCE,DESTINATION,TICKET_PRICE) values (1002,'Shatabdi
Express','Delhi','Bangalore',2500);
Insert into TRAINS (TRAIN_NO,TRAIN_NAME,SOURCE,DESTINATION,TICKET_PRICE) values (1003,'Udyan
Express','Bangalore','Mumbai',1500);
Insert into TRAINS (TRAIN_NO,TRAIN_NAME,SOURCE,DESTINATION,TICKET_PRICE) values (1004,'Udyan
Express','Mumbai','Bangalore',1500);
Insert into TRAINS (TRAIN_NO,TRAIN_NAME,SOURCE,DESTINATION,TICKET_PRICE) values (1005,'Brindavan
Express','Bangalore','Chennai',1000);
Insert into TRAINS (TRAIN_NO,TRAIN_N
