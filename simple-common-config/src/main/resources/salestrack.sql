
-- ----------------------------
-- Table structure for `salestrack`
-- ----------------------------
DROP TABLE IF EXISTS `salestrack`;
CREATE TABLE `salestrack` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `extraModel` varchar(45) NOT NULL,
  `interModel` varchar(45) NOT NULL,
  `imei1` varchar(20) NOT NULL,
  `imei2` varchar(20) NOT NULL,
  `telNum` varchar(20) DEFAULT NULL,
  `date` varchar(45) NOT NULL,
  `ip` varchar(50) DEFAULT NULL,
  `fingerPrint` varchar(255) DEFAULT NULL,
  `versionNo` varchar(50) DEFAULT NULL,
  `province` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `fullLocation` varchar(500) DEFAULT NULL,
  `mcc` varchar(3) DEFAULT NULL,
  `createDate` varchar(20) DEFAULT NULL,
  `updateDate` varchar(20) DEFAULT NULL,
  `countrySuffix` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IX_salestrack_imei1_imei2` (`imei1`,`imei2`,`extraModel`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salestrack
-- ----------------------------

-- ----------------------------
-- Table structure for `salestrack_repetition`
-- ----------------------------
DROP TABLE IF EXISTS `salestrack_repetition`;
CREATE TABLE `salestrack_repetition` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `extraModel` varchar(45) NOT NULL,
  `interModel` varchar(45) NOT NULL,
  `imei1` varchar(20) NOT NULL,
  `imei2` varchar(20) NOT NULL,
  `telNum` varchar(20) DEFAULT NULL,
  `date` varchar(45) NOT NULL,
  `ip` varchar(50) DEFAULT NULL,
  `fingerPrint` varchar(255) DEFAULT NULL,
  `versionNo` varchar(50) DEFAULT NULL,
  `province` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `fullLocation` varchar(500) DEFAULT NULL,
  `mcc` varchar(3) DEFAULT NULL,
  `createDate` varchar(20) DEFAULT NULL,
  `updateDate` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IX_salestrack_imei1_imei2` (`imei1`,`imei2`,`extraModel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salestrack_repetition
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sales_model`
-- ----------------------------
DROP TABLE IF EXISTS `t_sales_model`;
CREATE TABLE `t_sales_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `interModel` varchar(40) DEFAULT NULL,
  `extraModel` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sales_model
-- ----------------------------


-- ----------------------------
-- Table structure for `user`
-- ----------------------------
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `userRole` varchar(20) DEFAULT '0',
  `countryName` varchar(100) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `country`
-- ----------------------------
CREATE TABLE `country` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47817 DEFAULT CHARSET=utf8;

