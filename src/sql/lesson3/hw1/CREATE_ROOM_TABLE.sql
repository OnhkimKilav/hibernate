CREATE TABLE ROOM(
    ID NUMBER,
    CONSTRAINT ROOM_PK PRIMARY KEY (ID),
    NUMBER_OF_GUESTS NUMBER NOT NULL,
    PRICE NUMBER NOT NULL,
    BREAKFAST_INCLUDED NUMBER CHECK (BREAKFAST_INCLUDED = 1 OR BREAKFAST_INCLUDED = 0) NOT NULL,
    PETS_ALLOWED NUMBER CHECK (PETS_ALLOWED = 1 OR PETS_ALLOWED = 0) NOT NULL,
    DATE_AVAILABLE_FROM TIMESTAMP,
    HOTEL_ID NUMBER NOT NULL,
    CONSTRAINT ROOM_FK FOREIGN KEY (HOTEL_ID)REFERENCES HOTEL(ID)
);