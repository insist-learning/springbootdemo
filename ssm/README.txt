这是基于 springboot 整合 ssm 的增删改查的 demo，包括分页
没有用到 bean 工厂，由于没有用到 bean 工厂，所以没有配置 ContextLoaderListener，
也没有配置 context-param，applicationContext.xml
该项目的 sql 语句为 
CREATE TABLE USER (
  ID INT NOT NULL AUTO_INCREMENT,
  USERNAEM VARCHAR(40) NOT NULL,
  AGE INT(4) NOT NULL,
  PRIMARY KEY ('ID')
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;

建议用 STS 运行