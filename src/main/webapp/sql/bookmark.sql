CREATE TABLE `bookmarks` (
  `accountID` bigint(20) NOT NULL,
  `bookmarkID` bigint(20) NOT NULL,
  `creationDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `bookmark` varchar(1028) NOT NULL,
  PRIMARY KEY (`accountID`);
  
  
  INSERT INTO `bookmark`.`bookmarks` (`accountID`, `bookmarkID`, `creationDate`, `bookmark`) VALUES ('12346', '65432', NOW(), 'http://www.bestbuy.com/site/hp-pavilion-23-ips-led-hd-monitor/7294734.p?id=1218838643187&skuId=7294734&st=hp%20monitor&cp=1&lp=2');
