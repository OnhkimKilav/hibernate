CREATE TABLE USER(
    ID NUMBER,
    CONSTRAINT USER_PK PRIMARY KEY (ID),

    USER_NAME NVARCHAR2(50) NOT NULL,
    PASSWORD NVARCHAR2(50) NOT NULL,
    COUNTRY NVARCHAR2(50) NOT NULL,
    USER_TYPE NVARCHAR2(50)  NOT NULL,
    ORDERS NVARCHAR2(100) NOT NULL
);