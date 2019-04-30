CREATE TABLE ORDER(
    ID NUMBER,
    CONSTRAINT ROOM_PK PRIMARY KEY (ID),

    USER_ORDERED_ID NUMBER,
    CONSTRAINT USER_ORDERED_ID_FK FOREIGN KEY (USER_ORDERED_ID) REFERENCES USER(ID),

    ROOM_ID NUMBER,
    CONSTRAINT ROOM_ID_FK FOREIGN KEY (ROOM_ID) REFERENCES ROOM(ID),

    DATE_FROM TIMESTAMP NOT NULL,
    DATE_TO TIMESTAMP NOT NULL,
    MONEY_PAID NUMBER NOT NULL
);