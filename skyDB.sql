CREATE TABLE user(
    userID char(6) PRIMARY KEY,
    firstName varchar(20) NOT NULL,
    lastName varchar(20),
    roomNo varchar(8) NOT NULL,
    phone varchar(10) NOT NULL,
    CHECK (SUBSTRING(userID,1,1) = 'u')
);

CREATE TABLE admin(
    adminID char (6) PRIMARY KEY,
    adminName varchar(20) NOT NULL,
    CHECK (SUBSTRING(adminID,1,1) = 'a')
);

CREATE TABLE bookdata(
    isbn varchar(15) PRIMARY KEY,
    title varchar(50) NOT NULL,
    author varchar(50) NOT NULL,
    countAvail tinyint NOT NULL,
    year smallint,
    genre varchar(20)
);

CREATE TABLE borrowlist(
    borrowID smallint PRIMARY KEY auto_increment,
    active bit NOT NULL,
    borrowerID char(6) NOT NULL,
    lenderID char(6) NOT NULL,
    FOREIGN KEY (borrowerID) REFERENCES user(userID),
    FOREIGN KEY (lenderID) REFERENCES user(userID),
    CHECK (borrowerID != lenderID)
);

CREATE TABLE loginauth(
    loginID char(6) PRIMARY KEY,
    passkey varchar(15) NOT NULL
);
