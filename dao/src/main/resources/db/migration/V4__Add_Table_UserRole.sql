CREATE TABLE UserRole (
	userId INT NOT NULL,
	roleId INT NOT NULL,
	PRIMARY KEY (userId, roleId),
  CONSTRAINT FKUserRoleId
   FOREIGN KEY (userId) REFERENCES User (id),
  CONSTRAINT FKRoleUserId
   FOREIGN KEY (roleId) REFERENCES Role (id)
);

ALTER TABLE User
  DROP FOREIGN KEY FK_UsersRole;
ALTER TABLE User DROP COLUMN roleId;

ALTER TABLE Role
  DROP FOREIGN KEY FK_RolesUser;
ALTER TABLE Role DROP COLUMN userId;

ALTER TABLE User
  ADD CONSTRAINT uniqueIndexUsername UNIQUE KEY(username);

INSERT INTO Role (name) values ("ROLE_ADMIN"), ("ROLE_USER");