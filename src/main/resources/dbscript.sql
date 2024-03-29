CREATE TABLE t_emp (
    eid INT PRIMARY KEY not NULL AUTO_INCREMENT,
    emp_name VARCHAR(100),
    age INT,
    sex CHAR,
    email VARCHAR(100),
    CONSTRAINT `FK_EMP_TO_DEPT` FOREIGN KEY (`did`) REFERENCES `t_dept` (`did`)
);

CREATE TABLE t_dept (
    did INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    dept_name VARCHAR(50)
);

INSERT INTO t_dept VALUES (1, 'A'), (2, 'B'), (3, 'C');

INSERT INTO t_emp VALUES (1, 'Arthur', 30, 'M', 'arthur@mail.com', 1),
(2, 'Marcia', 27, 'M', 'marcia@mail.com', 2),
(3, 'Fenghua', 55, 'M', 'fenghua@mail.com', 3),
(4, 'Yongan', 65, 'M', 'yongan@mail.com', 1),
(5, 'Fengju', 60, 'M', 'fengju@mail.com', 2);