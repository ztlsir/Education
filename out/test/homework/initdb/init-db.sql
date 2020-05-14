-- 创建homeworks表
CREATE TABLE homeworks
(
  innerId INT IDENTITY PRIMARY KEY,
  ID           VARCHAR(64) NOT NULL,
  JSON_CONTENT JSON        NOT NULL
);
