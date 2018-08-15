# AssessmentBackend
Reading an MySql Database with tables: Movies, Usercredentials
CREATE TABLE `movies` (
  `MovieId` int(11) NOT NULL,
  `Title` varchar(45) DEFAULT NULL,
  `Genre` varchar(45) DEFAULT NULL,
  `Language` varchar(45) DEFAULT NULL,
  `Year` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MovieId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usercredentials` (
  `usercredentialsId` int(11) NOT NULL,
  `Username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`usercredentialsId`),
  UNIQUE KEY `Username_UNIQUE` (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `video_store`.`movies`
(`MovieId`,
`Title`,
`Genre`,
`Language`,
`Year`)
VALUES
(0,
'Dead Pool 1',
'Action',
'2019',
<{Year: }>);

INSERT INTO `video_store`.`usercredentials`
(`usercredentialsId`,
`Username`,
`password`)
VALUES
(<{usercredentialsId: }>,
<{Username: }>,
<{password: }>);


Assessment Backend
